package com.app.demo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.demo.view.CustomProgressDialog;
import com.app.demo.weight.StatusBarCompat;

/**
 * Created by slxk-002 on 2017/2/24.
 */

public class BaseActivity extends AppCompatActivity {

    public Context mContext;
    private CustomProgressDialog progressDialog;
    private RelativeLayout main_layout;
    public LinearLayout main_llback;
    public TextView main_center_tv;
    public ImageView main_right_iv;
    public TextView main_right_tv;

    public BaseActivity(){
        mContext=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.compat(this);
    }

    /**
     *   titleName 标题
     *   isImage  是否显示图片按钮  false 显示TextView
     *   rightName 文字名称
     */
    public  void init(String titleName, boolean isImage, String rigthName){
        main_layout= findViewById(R.id.actionbar_main_layout);
        main_llback= findViewById(R.id.actionbar_main_llback);
        main_center_tv=findViewById(R.id.actionbar_main_center_tv);
        main_right_iv=findViewById(R.id.actionbar_main_right_iv);
        main_right_tv=findViewById(R.id.actionbar_main_right_tv);
        main_center_tv.setText(titleName);
        main_right_iv.setVisibility(isImage ? View.VISIBLE : View.GONE);
        main_right_tv.setVisibility(isImage ? View.GONE : View.VISIBLE);
        main_right_tv.setText(rigthName);
        main_llback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                showBackwardAnim();
            }
        });
    }

    /**
     * 设置进入动画
     */
    public void showForwardAnim() {
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    /**
     * 设置退出动画
     */
    public void showBackwardAnim() {
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    /** 显示加载框 */
    protected void showWaitingDialog(String tip){
        if(progressDialog==null){
            progressDialog = CustomProgressDialog.create(mContext, tip, true, null);
        }
        progressDialog.show();
    }

    protected void showUpdataDialog(Context context, String message){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.updataMessage(message);
        }else{
            progressDialog = CustomProgressDialog.create(context, message, true, null);
            progressDialog.show();
        }
    }

    /** 取消加载框 */
    protected void dismissWaitingDialog(){
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    /**
     * 权限申请
     * permission  权限名
     * */
    public void PermissionApp(String permission){
        if(Build.VERSION.SDK_INT>=23){
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, permission);
            if(checkCallPhonePermission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(BaseActivity.this,new String[]{permission},1);
            }
        }
    }

    /** 权限申请回调 */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    //finish();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}

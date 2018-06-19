package com.app.demo.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import com.app.demo.R;


public class CustomProgressDialog extends Dialog {
	public static TextView text;
	
	public CustomProgressDialog(Context context, int theme) {
		super(context,theme);
	}
	
	public static CustomProgressDialog create(Context context, CharSequence message, boolean cancelable, OnCancelListener cancelListener) {
		CustomProgressDialog dialog = new CustomProgressDialog(context, R.style.CustomProgressDialog);
	    dialog.setTitle("");
	    dialog.setContentView(R.layout.dialog_loading);
		text = (TextView) dialog.findViewById(R.id.progressdialog_msg);
		text.setText(message);

	    
	    dialog.setCancelable(cancelable);
	    dialog.setCanceledOnTouchOutside(false);
	    dialog.setOnCancelListener(cancelListener);
	    dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
	    WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
	    // lucency background
	    lp.dimAmount = 0.2f;
	    dialog.getWindow().setAttributes(lp);
	    return dialog;
	  }

	  public static void updataMessage(String message){
		  text.setText(message);
	  }

}

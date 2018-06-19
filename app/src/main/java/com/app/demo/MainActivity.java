package com.app.demo;


import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.app.demo.fragment.HomeFragment;
import com.app.demo.fragment.MessageFragment;
import com.app.demo.fragment.MonitorFragment;
import com.app.demo.fragment.MyFragment;
import com.app.demo.model.Tab;
import com.app.demo.weight.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_main);
        initTab();
    }

    /** 初始化 */
    private void initTab(){
        Tab home=new Tab(R.drawable.selector_icon_home,R.string.fragment_home, HomeFragment.class);
        Tab monitor=new Tab(R.drawable.selector_icon_monitor,R.string.fragment_monitor, MonitorFragment.class);
        Tab message=new Tab(R.drawable.selector_icon_message,R.string.fragment_message, MessageFragment.class);
        Tab my=new Tab(R.drawable.selector_icon_my,R.string.fragment_my, MyFragment.class);

        mTabs.add(home);
        mTabs.add(monitor);
        mTabs.add(message);
        mTabs.add(my);

        mInflater= LayoutInflater.from(this);
        mTabHost=this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        for (Tab tab:mTabs){
            TabHost.TabSpec tabSpec=mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec,tab.getFragment(),null);
        }
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabHost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab){
        View view=mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img=view.findViewById(R.id.icon_tab);
        TextView title=view.findViewById(R.id.txt_indicator);
        img.setBackgroundResource(tab.getIcon());
        title.setText(tab.getTitle());
        return view;
    }
}

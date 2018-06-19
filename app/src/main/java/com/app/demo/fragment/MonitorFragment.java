package com.app.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.demo.BaseFragment;
import com.app.demo.R;


/**
 * Created by Administrator on 2018\3\20 0020.
 */

public class MonitorFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_monitor,container,false);
        return view;
    }
}

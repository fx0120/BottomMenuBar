package com.app.demo;

import android.support.v4.app.Fragment;

/**
 * Created by slxk-002 on 2017/2/24.
 */

public class BaseFragment extends Fragment {

    /**
     * 设置进入动画
     */
    public void showForwardAnim() {
        getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    /**
     * 设置退出动画
     */
    public void showBackwardAnim() {
        getActivity().overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}

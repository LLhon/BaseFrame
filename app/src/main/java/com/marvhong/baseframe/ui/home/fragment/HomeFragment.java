package com.marvhong.baseframe.ui.home.fragment;

import android.os.Bundle;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.app.Constants;
import com.marvhong.baseframe.base.fragment.BaseRootFragment;
import com.marvhong.baseframe.mvp.contract.home.HomeContract;
import com.marvhong.baseframe.mvp.presenter.home.HomePresenter;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.ui.home.fragment
 * @Date 2018/8/31 11:41
 * @description
 */
public class HomeFragment extends BaseRootFragment<HomePresenter> implements HomeContract.View {

    public static HomeFragment getInstance(boolean param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putBoolean(Constants.ARG_PARAM1, param1);
        args.putString(Constants.ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}

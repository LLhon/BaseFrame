package com.marvhong.baseframe.ui.home.activity;

import com.marvhong.baseframe.base.activity.BaseActivity;
import com.marvhong.baseframe.mvp.contract.home.MainContract;
import com.marvhong.baseframe.mvp.presenter.home.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showSwitchProject() {

    }

    @Override
    public void showSwitchNavigation() {

    }
}

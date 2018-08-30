package com.marvhong.baseframe.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.marvhong.baseframe.base.presenter.AbstractPresenter;
import com.marvhong.baseframe.base.view.AbstractView;
import com.marvhong.baseframe.utils.UIUtils;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.base.fragment
 * @Date 2018/8/30 15:49
 * @description
 */
public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements
    AbstractView {

    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Activity activity) {
        AndroidSupportInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            UIUtils.showSnackMessage(_mActivity, errorMsg);
        }
    }

    @Override
    public void showNormal() {
    }

    @Override
    public void showError() {
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void reload() {
    }

    @Override
    public void showLoginView() {
    }

    @Override
    public void showLogoutView() {
    }

    @Override
    public void showToast(String message) {
        UIUtils.showMessage(_mActivity, message);
    }

    @Override
    public void showSnackBar(String message) {
        UIUtils.showSnackMessage(_mActivity, message);
    }
}

package com.marvhong.baseframe.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.marvhong.baseframe.base.presenter.AbstractPresenter;
import com.marvhong.baseframe.base.view.AbstractView;
import com.marvhong.baseframe.utils.UIUtils;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;

/**
 * @author LLhon
 * @project BaseFrame
 * @date 2018/9/6 14:56
 * @description MVP模式的BaseDialogFragment
 */
public abstract class BaseDialogFragment<T extends AbstractPresenter> extends AbstractSimpleDialogFragment
    implements AbstractView {

    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if (getActivity() != null) {
            UIUtils.showSnackMessage(getActivity(), errorMsg);
        }
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showEmpty() {

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
        if (getActivity() == null) {
            return;
        }
        UIUtils.showMessage(getActivity(), message);
    }

    @Override
    public void showSnackBar(String message) {
        if (getActivity() == null) {
            return;
        }
        UIUtils.showSnackMessage(getActivity(), message);
    }
}

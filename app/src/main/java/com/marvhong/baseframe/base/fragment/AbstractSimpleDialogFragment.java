package com.marvhong.baseframe.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author LLhon
 * @project BaseFrame
 * @date 2018/9/6 14:50
 * @description
 */
public abstract class AbstractSimpleDialogFragment extends DialogFragment {

    private Unbinder mUnbinder;
    public View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        initEventAndData();
        return mRootView;
    }

    protected abstract int getLayoutId();

    protected abstract void initEventAndData();

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            //防止连续点击add多个fragment
            manager.beginTransaction().remove(this).commit();
            super.show(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }
}

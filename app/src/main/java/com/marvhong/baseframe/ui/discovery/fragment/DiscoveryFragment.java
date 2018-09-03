package com.marvhong.baseframe.ui.discovery.fragment;

import android.os.Bundle;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.base.fragment.BaseRootFragment;
import com.marvhong.baseframe.mvp.contract.discovery.DiscoveryContract;
import com.marvhong.baseframe.mvp.presenter.discovery.DiscoveryPresenter;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.ui.mine.fragment
 * @Date 2018/8/31 12:12
 * @description
 */
public class DiscoveryFragment extends BaseRootFragment<DiscoveryPresenter> implements DiscoveryContract.View {

    public static DiscoveryFragment getInstance() {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }
}

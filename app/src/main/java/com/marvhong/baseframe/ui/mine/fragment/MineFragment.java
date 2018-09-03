package com.marvhong.baseframe.ui.mine.fragment;

import android.os.Bundle;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.base.fragment.BaseRootFragment;
import com.marvhong.baseframe.mvp.contract.mine.MineContract;
import com.marvhong.baseframe.mvp.presenter.mine.MinePresenter;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.ui.mine.fragment
 * @Date 2018/8/31 12:12
 * @description
 */
public class MineFragment extends BaseRootFragment<MinePresenter> implements MineContract.View {

    public static MineFragment getInstance() {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}

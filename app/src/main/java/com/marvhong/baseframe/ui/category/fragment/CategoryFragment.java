package com.marvhong.baseframe.ui.category.fragment;

import android.os.Bundle;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.base.fragment.BaseRootFragment;
import com.marvhong.baseframe.mvp.contract.category.CategoryContract;
import com.marvhong.baseframe.mvp.presenter.category.CategoryPresenter;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.ui.mine.fragment
 * @Date 2018/8/31 12:12
 * @description
 */
public class CategoryFragment extends BaseRootFragment<CategoryPresenter> implements CategoryContract.View {

    public static CategoryFragment getInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }
}

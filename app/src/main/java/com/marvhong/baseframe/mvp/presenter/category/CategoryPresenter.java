package com.marvhong.baseframe.mvp.presenter.category;

import com.marvhong.baseframe.base.presenter.BasePresenter;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.mvp.contract.category.CategoryContract;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.presenter.mine
 * @Date 2018/8/31 12:12
 * @description
 */
public class CategoryPresenter extends BasePresenter<CategoryContract.View> implements
    CategoryContract.Presenter {

    private DataManager mDataManager;

    @Inject
    CategoryPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }
}

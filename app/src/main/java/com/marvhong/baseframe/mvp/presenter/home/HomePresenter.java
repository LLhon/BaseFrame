package com.marvhong.baseframe.mvp.presenter.home;

import com.marvhong.baseframe.base.presenter.BasePresenter;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.mvp.contract.home.HomeContract;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.presenter.home
 * @Date 2018/8/31 11:47
 * @description
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private DataManager mDataManager;
    private int mCurrentPage;

    @Inject
    HomePresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public void loadMore() {

    }
}

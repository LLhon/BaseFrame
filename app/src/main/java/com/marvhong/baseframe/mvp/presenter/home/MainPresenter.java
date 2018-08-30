package com.marvhong.baseframe.mvp.presenter.home;

import com.marvhong.baseframe.base.presenter.BasePresenter;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.mvp.contract.home.MainContract;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.presenter.home
 * @Date 2018/8/30 17:07
 * @description
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    MainPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void setCurrentPage(int page) {
        mDataManager.setCurrentPage(page);
    }
}

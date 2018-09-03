package com.marvhong.baseframe.mvp.presenter.discovery;

import com.marvhong.baseframe.base.presenter.BasePresenter;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.mvp.contract.discovery.DiscoveryContract;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.presenter.mine
 * @Date 2018/8/31 12:12
 * @description
 */
public class DiscoveryPresenter extends BasePresenter<DiscoveryContract.View> implements
    DiscoveryContract.Presenter {

    private DataManager mDataManager;

    @Inject
    DiscoveryPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }
}

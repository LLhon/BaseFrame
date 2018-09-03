package com.marvhong.baseframe.mvp.presenter.mine;

import com.marvhong.baseframe.base.presenter.BasePresenter;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.mvp.contract.mine.MineContract;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.presenter.mine
 * @Date 2018/8/31 12:12
 * @description
 */
public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {

    private DataManager mDataManager;

    @Inject
    MinePresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }
}

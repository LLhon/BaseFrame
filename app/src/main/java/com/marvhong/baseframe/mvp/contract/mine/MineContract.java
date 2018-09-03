package com.marvhong.baseframe.mvp.contract.mine;

import com.marvhong.baseframe.base.presenter.AbstractPresenter;
import com.marvhong.baseframe.base.view.AbstractView;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.contract.mine
 * @Date 2018/8/31 12:13
 * @description
 */
public interface MineContract {

    interface View extends AbstractView {

    }

    interface Presenter extends AbstractPresenter<View> {

    }
}

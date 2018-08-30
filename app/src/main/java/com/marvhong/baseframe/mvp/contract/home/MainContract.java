package com.marvhong.baseframe.mvp.contract.home;

import com.marvhong.baseframe.base.presenter.AbstractPresenter;
import com.marvhong.baseframe.base.view.AbstractView;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.contract
 * @Date 2018/8/30 17:00
 * @description
 */
public interface MainContract {

    interface View extends AbstractView {

        void showSwitchProject();

        void showSwitchNavigation();
    }

    interface Presenter extends AbstractPresenter<View> {

        void setCurrentPage(int page);
    }
}

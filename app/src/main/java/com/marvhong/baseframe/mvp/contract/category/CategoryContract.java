package com.marvhong.baseframe.mvp.contract.category;

import com.marvhong.baseframe.base.presenter.AbstractPresenter;
import com.marvhong.baseframe.base.view.AbstractView;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.mvp.contract.home
 * @Date 2018/8/31 11:49
 * @description
 */
public interface CategoryContract {

    interface View extends AbstractView {

    }

    interface Presenter extends AbstractPresenter<View> {

    }
}

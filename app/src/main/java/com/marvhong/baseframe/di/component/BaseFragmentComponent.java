package com.marvhong.baseframe.di.component;

import com.marvhong.baseframe.base.fragment.BaseFragment;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.component
 * @Date 2018/8/30 15:56
 * @description
 */
@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseFragmentComponent extends AndroidInjector<BaseFragment> {

    /**
     * 每一个继承于BaseFragment的Fragment都继承于同一个组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseFragment> {

    }
}

package com.marvhong.baseframe.di.component;

import com.marvhong.baseframe.base.activity.BaseActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.component
 * @Date 2018/8/30 15:55
 * @description
 */
@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {

    /**
     * 每一个继承于BaseActivity的Activity都继承于同一个子组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseActivity> {

    }
}

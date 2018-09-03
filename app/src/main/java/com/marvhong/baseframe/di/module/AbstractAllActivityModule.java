package com.marvhong.baseframe.di.module;

import com.marvhong.baseframe.di.component.BaseActivityComponent;
import com.marvhong.baseframe.ui.home.activity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.module
 * @Date 2018/8/30 15:54
 * @description
 */
@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contriburesMainActivityInjector();
}

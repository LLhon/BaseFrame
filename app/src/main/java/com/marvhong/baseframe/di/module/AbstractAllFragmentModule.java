package com.marvhong.baseframe.di.module;

import com.marvhong.baseframe.di.component.BaseFragmentComponent;
import com.marvhong.baseframe.ui.category.fragment.CategoryFragment;
import com.marvhong.baseframe.ui.discovery.fragment.DiscoveryFragment;
import com.marvhong.baseframe.ui.home.fragment.HomeFragment;
import com.marvhong.baseframe.ui.mine.fragment.MineFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.module
 * @Date 2018/8/30 16:00
 * @description
 */
@Module(subcomponents = {BaseFragmentComponent.class})
public abstract class AbstractAllFragmentModule {

    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment contributesHomeFragmentInjector();

    @ContributesAndroidInjector(modules = CategoryFragmentModule.class)
    abstract CategoryFragment contributesCategoryFragmentInjector();

    @ContributesAndroidInjector(modules = DiscoveryFragmentModule.class)
    abstract DiscoveryFragment contributesDiscoveryFragmentInjector();

    @ContributesAndroidInjector(modules = MineFragmentModule.class)
    abstract MineFragment contributesMineFragmentInjector();
}

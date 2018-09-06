package com.marvhong.baseframe.di.component;

import com.marvhong.baseframe.base.fragment.BaseDialogFragment;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author LLhon
 * @date 2018/9/6 15:21
 * @description
 */
@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseDialogFragmentComponent extends AndroidInjector<BaseDialogFragment> {

    /**
     * 每一个继承于BaseDialogFragment的Fragment都继承于同一个组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseDialogFragment> {

    }
}

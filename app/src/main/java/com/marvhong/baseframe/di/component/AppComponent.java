package com.marvhong.baseframe.di.component;

import com.marvhong.baseframe.app.App;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.di.module.AbstractAllActivityModule;
import com.marvhong.baseframe.di.module.AbstractAllDialogFragmentModule;
import com.marvhong.baseframe.di.module.AbstractAllFragmentModule;
import com.marvhong.baseframe.di.module.AppModule;
import com.marvhong.baseframe.di.module.HttpModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.component
 * @Date 2018/8/30 16:00
 * @description
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class,
    AndroidSupportInjectionModule.class,
    AbstractAllActivityModule.class,
    AbstractAllFragmentModule.class,
    AbstractAllDialogFragmentModule.class,
    AppModule.class,
    HttpModule.class})
public interface AppComponent {

    /**
     * 注入App实例
     *
     * @param app app
     */
    void inject(App app);

    /**
     * 提供App的Context
     *
     * @return App context
     */
    App getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();
}

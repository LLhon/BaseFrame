package com.marvhong.baseframe.di.module;

import com.marvhong.baseframe.app.App;
import com.marvhong.baseframe.core.DataManager;
import com.marvhong.baseframe.core.http.HttpHelper;
import com.marvhong.baseframe.core.http.HttpHelperImpl;
import com.marvhong.baseframe.core.prefs.PreferenceHelper;
import com.marvhong.baseframe.core.prefs.PreferenceHelperImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.module
 * @Date 2018/8/30 12:07
 * @description
 */
@Module
public class AppModule {

    private final App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelper) {
        return httpHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl preferenceHelper) {
        return preferenceHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferenceHelper preferenceHelper) {
        return new DataManager(httpHelper, preferenceHelper);
    }
}

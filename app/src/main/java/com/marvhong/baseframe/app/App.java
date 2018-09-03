package com.marvhong.baseframe.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.bumptech.glide.Glide;
import com.marvhong.baseframe.BuildConfig;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.di.component.AppComponent;
import com.marvhong.baseframe.di.component.DaggerAppComponent;
import com.marvhong.baseframe.di.module.AppModule;
import com.marvhong.baseframe.di.module.HttpModule;
import com.marvhong.baseframe.utils.logger.TxtFormatStrategy;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.app
 * @Date 2018/8/29 11:19
 * @description
 */
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    private static App sInstance;
    public static boolean isFirstRun = true;
    private static volatile AppComponent appComponent;

    public static synchronized App getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
            .appModule(new AppModule(sInstance))
            .httpModule(new HttpModule())
            .build().inject(this);
        sInstance = this;

        initGreenDao();

        initBugly();

        initLogger();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    private void initGreenDao() {

    }

    private void initLogger() {
        //DEBUG版本才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                tag(getString(R.string.app_name)).build()));
        }
        //把log存到本地
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().
            tag(getString(R.string.app_name))
            .build(getPackageName(), getString(R.string.app_name))));
    }

    private void initBugly() {

    }

    public static synchronized AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(sInstance))
                .httpModule(new HttpModule())
                .build();
        }
        return appComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}

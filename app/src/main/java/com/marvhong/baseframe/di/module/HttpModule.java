package com.marvhong.baseframe.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.marvhong.baseframe.BuildConfig;
import com.marvhong.baseframe.app.App;
import com.marvhong.baseframe.app.Constants;
import com.marvhong.baseframe.core.http.api.ApiService;
import com.marvhong.baseframe.utils.UIUtils;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.di.module
 * @Date 2018/8/30 12:26
 * @description
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiService.HOST);
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = chain -> {
            Request request = chain.request();
            if (!UIUtils.isNetworkConnected()) {
                request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            }
            Response response = chain.proceed(request);
            if (UIUtils.isNetworkConnected()) {
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build();
            } else {
                // 无网络时，设置超时为4周
                int maxStale = 60 * 60 * 24 * 28;
                response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
            }
            return response;
        };
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        //cookie认证
        builder.cookieJar(new PersistentCookieJar(new SetCookieCache(),
            new SharedPrefsCookiePersistor(App.getInstance())));
        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
            .baseUrl(url)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}

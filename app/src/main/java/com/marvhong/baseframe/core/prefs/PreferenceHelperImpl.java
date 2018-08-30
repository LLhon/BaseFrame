package com.marvhong.baseframe.core.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.marvhong.baseframe.app.App;
import com.marvhong.baseframe.app.Constants;
import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.core.prefs
 * @Date 2018/8/30 15:03
 * @description
 */
public class PreferenceHelperImpl implements PreferenceHelper {

    private final SharedPreferences mPreferences;

    @Inject
    PreferenceHelperImpl() {
        mPreferences = App.getInstance()
            .getSharedPreferences(Constants.MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferences.edit().putString(Constants.ACCOUNT, account).apply();
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferences.edit().putString(Constants.PASSWORD, password).apply();
    }

    @Override
    public String getLoginAccount() {
        return mPreferences.getString(Constants.ACCOUNT, "");
    }

    @Override
    public String getLoginPassword() {
        return mPreferences.getString(Constants.PASSWORD, "");
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferences.edit().putBoolean(Constants.LOGIN_STATUS, isLogin).apply();
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferences.getBoolean(Constants.LOGIN_STATUS, false);
    }

    @Override
    public void setCookie(String domain, String cookie) {
        mPreferences.edit().putString(domain, cookie).apply();
    }

    @Override
    public String getCookie(String domain) {
        return mPreferences.getString(Constants.COOKIE, "");
    }

    @Override
    public void setCurrentPage(int position) {
        mPreferences.edit().putInt(Constants.CURRENT_PAGE, position).apply();
    }

    @Override
    public int getCurrentPage() {
        return mPreferences.getInt(Constants.CURRENT_PAGE, 0);
    }

    @Override
    public void setProjectCurrentPage(int position) {
        mPreferences.edit().putInt(Constants.PROJECT_CURRENT_PAGE, position).apply();
    }

    @Override
    public int getProjectCurrentPage() {
        return mPreferences.getInt(Constants.PROJECT_CURRENT_PAGE, 0);
    }
}

package com.marvhong.baseframe.core;

import com.marvhong.baseframe.core.http.HttpHelper;
import com.marvhong.baseframe.core.prefs.PreferenceHelper;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.core
 * @Date 2018/8/30 12:16
 * @description
 */
public class DataManager implements HttpHelper, PreferenceHelper {

    private HttpHelper mHttpHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, PreferenceHelper preferenceHelper) {
        mHttpHelper = httpHelper;
        mPreferenceHelper = preferenceHelper;
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferenceHelper.setLoginPassword(password);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPreferenceHelper.getLoginPassword();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferenceHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferenceHelper.getLoginStatus();
    }

    @Override
    public void setCookie(String domain, String cookie) {
        mPreferenceHelper.setCookie(domain, cookie);
    }

    @Override
    public String getCookie(String domain) {
        return mPreferenceHelper.getCookie(domain);
    }

    @Override
    public void setCurrentPage(int position) {
        mPreferenceHelper.setCurrentPage(position);
    }

    @Override
    public int getCurrentPage() {
        return mPreferenceHelper.getCurrentPage();
    }

    @Override
    public void setProjectCurrentPage(int position) {
        mPreferenceHelper.setProjectCurrentPage(position);
    }

    @Override
    public int getProjectCurrentPage() {
        return mPreferenceHelper.getProjectCurrentPage();
    }
}

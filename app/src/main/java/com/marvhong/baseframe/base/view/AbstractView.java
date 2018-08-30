package com.marvhong.baseframe.base.view;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.base.view
 * @Date 2018/8/30 14:57
 * @description
 */
public interface AbstractView {

    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Reload
     */
    void reload();

    /**
     * Show login view
     */
    void showLoginView();

    /**
     * Show logout view
     */
    void showLogoutView();

    /**
     * Show toast
     *
     * @param message Message
     */
    void showToast(String message);

    /**
     * Show snackBar
     *
     * @param message Message
     */
    void showSnackBar(String message);
}

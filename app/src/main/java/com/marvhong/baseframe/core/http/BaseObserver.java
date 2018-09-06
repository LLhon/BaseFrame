package com.marvhong.baseframe.core.http;

import android.text.TextUtils;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.app.App;
import com.marvhong.baseframe.base.view.AbstractView;
import com.marvhong.baseframe.core.http.exception.ServerException;
import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.core.http
 * @Date 2018/9/6 12:14
 * @description
 */
public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private AbstractView mView;
    private String mErrorMsg;
    private boolean mIsShowError = true;

    protected BaseObserver(AbstractView view) {
        mView = view;
    }

    protected BaseObserver(AbstractView view, String errorMsg) {
        mView = view;
        mErrorMsg = errorMsg;
    }

    protected BaseObserver(AbstractView view, boolean isShowError) {
        mView = view;
        mIsShowError = isShowError;
    }

    protected BaseObserver(AbstractView view, String errorMsg, boolean isShowError) {
        mView = view;
        mErrorMsg = errorMsg;
        mIsShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (!TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ServerException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg(App.getInstance().getString(R.string.http_error));
        } else {
            mView.showErrorMsg(App.getInstance().getString(R.string.unknown_error));
        }
        if (mIsShowError) {
            mView.showError();
        }
    }
}

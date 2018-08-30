package com.marvhong.baseframe.core.http;

import javax.inject.Inject;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.core.http
 * @Date 2018/8/30 12:13
 * @description
 */
public class HttpHelperImpl implements HttpHelper {

    private ApiService mService;

    @Inject
    HttpHelperImpl(ApiService service) {
        mService = service;
    }
}

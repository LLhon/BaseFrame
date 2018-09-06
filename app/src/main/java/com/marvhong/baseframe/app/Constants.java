package com.marvhong.baseframe.app;

import java.io.File;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.app
 * @Date 2018/8/30 12:28
 * @description
 */
public class Constants {

    public static final String MY_SHARED_PREFERENCE = "my_shared_preference";

    /**
     * url
     */
    public static final String COOKIE = "Cookie";

    /**
     * Acache Path
     */
    public static final String PATH_DATA =
        App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final long DOUBLE_INTERVAL_TIME = 2000;

    /**
     * Shared Preference key
     */
    public static final String ACCOUNT = "account";

    public static final String PASSWORD = "password";

    public static final String LOGIN_STATUS = "login_status";

    public static final String CURRENT_PAGE = "current_page";

    public static final String PROJECT_CURRENT_PAGE = "project_current_page";

    /**
     * Intent params
     */
    public static final String ARG_PARAM1 = "param1";

    public static final String ARG_PARAM2 = "param2";

    /**
     * Tag fragment classify
     */
    public static final int TYPE_HOME = 0;

    public static final int TYPE_CATEGORY = 1;

    public static final int TYPE_DISCOVERY = 2;

    public static final int TYPE_MINE = 3;

}

package hl.applicationcollection;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import app.lib.CrashHandler;

/**
 * Created by huanglin on 2017/2/17.
 * 邮箱：1871767675@qq.com
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
        initCrashHandler();
    }

    /**
     * 初始化异常捕获类
     */
    private void initCrashHandler() {
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

    /**
     * 初始化路由框架
     */
    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}

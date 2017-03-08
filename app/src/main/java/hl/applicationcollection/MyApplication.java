package hl.applicationcollection;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by huanglin on 2017/2/17.
 * 邮箱：1871767675@qq.com
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
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

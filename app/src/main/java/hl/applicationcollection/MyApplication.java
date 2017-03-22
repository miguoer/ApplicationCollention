package hl.applicationcollection;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import app.lib.CrashHandler;

/**
 * Created by huanglin on 2017/2/17.
 * 邮箱：1871767675@qq.com
 */

public class MyApplication extends Application {
    
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
        initCrashHandler();
        initLeakCanary();
    }

    /**
     * 初始化内存泄露分析工具
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        if (BuildConfig.DEBUG) {
            refWatcher = LeakCanary.install(this);
        } else {
            refWatcher = installLeakCanary();
        }
    }

    /**
     * Release版本关闭RefWatcher
     * @return
     */
    private RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
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

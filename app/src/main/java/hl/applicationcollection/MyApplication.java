package hl.applicationcollection;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.spinytech.macore.MaApplication;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import app.lib.CrashHandler;
import hl.applicationcollection.router.MainApplicationLogic;

/**
 * Created by huanglin on 2017/2/17.
 * 邮箱：1871767675@qq.com
 */

public class MyApplication extends MaApplication {
    
    private RefWatcher refWatcher;

    /**
     * 内存泄露观察者
     * @param context
     * @return
     */
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
     * 初始化所有进程的本地路由
     */
    @Override
    public void initializeAllProcessRouter() {

    }

    /**
     * 注册Application逻辑
     */
    @Override
    protected void initializeLogic() {
        //第一个参数表示进程名，第二个表示初始化优先级，第三个是对应的Application逻辑类，在需要的时候会反射初始化
        registerApplicationLogic("hl.applicationcollection",999, MainApplicationLogic.class);
    }

    /**
     * 标记该App是否是多进程，如果是返回true，否则返回false
     * @return
     */
    @Override
    public boolean needMultipleProcess() {
        return false;
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

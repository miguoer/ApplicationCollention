package hl.applicationcollection.utils;

import android.app.Activity;
import java.util.Stack;

/**
 * Activity管理类
 * Created by huanglin on 2017/2/17.
 * 邮箱：1871767675@qq.com
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager activityManager;

    private ActivityManager() {}

    /**
     * 单例模式
     */
    public static ActivityManager getInstance() {
        return ActivityManagerBuilder.instance;
    }

    private static class ActivityManagerBuilder {
        private static ActivityManager instance = new ActivityManager();
    }

    /**
     * 将Activity加入栈顶
     * @param activity
     */
    public void addActivity(Activity activity) {;
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 取栈顶Activity
     * @return
     */
    public Activity getCurrentActivity() {
        if (activityStack == null) return null;
        if (!activityStack.empty()) {
            return activityStack.lastElement();
        }
        return null;
    }

    /**
     * 清除栈中所有的Activity
     */
    public void clearAllActivity() {
        while (true) {
            Activity activity = getCurrentActivity();
            if (activity == null) {
                break;
            }
            activity.finish();
        }
    }

    /**
     * 清除栈中所有的Activity除了clz
     * @param clz
     */
    public void clearAllActivityExceptOne(Class clz) {
        while (true) {
            Activity activity = getCurrentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(clz)) {
                break;
            }
            activity.finish();
        }
    }
}

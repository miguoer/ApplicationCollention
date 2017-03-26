package app.lib.utils;

/**
 * Created by huanglin on 2017/3/26.
 */

public class FastClickUtil {

    private static long timeInterval = 0;

    /**
     * 判断点击频率是否超过设定频率
     * @param interval
     * @return
     * @throws Exception
     */
    static boolean isFastClick(int interval) throws Exception {
        if (interval <= 0) {
            throw new Exception("interval time cannot be lower than 0");
        }

        long currentTime = System.currentTimeMillis();

        if (timeInterval == 0) {
            timeInterval = currentTime;
            return false;
        }

        timeInterval = currentTime - timeInterval;

        if (timeInterval <= interval) {
            return true;
        }
        return false;
    }
}

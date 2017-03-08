package hl.applicationcollection.base;

/**
 * Created by huanglin on 2017/2/23.
 * 邮箱：1871767675@qq.com
 */

public interface IBaseView {
    /**
     * 弹出提示
     */
    void showToast();

    /**
     * 展现等待框
     */
    void showWaitingDialog();

    /**
     * 隐藏等待框
     */
    void hideWaitingDialog();
}

package com.hl.appwebview.base;

/**
 * Created by huanglin on 2017/2/19.
 * 邮箱：1871767675@qq.com
 */

public interface IBasePresenter<V> {
    void attachView(V view);

    void detachView();

}

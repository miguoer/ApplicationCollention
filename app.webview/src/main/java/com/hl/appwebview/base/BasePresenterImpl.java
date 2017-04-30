package com.hl.appwebview.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by huanglin on 2017/2/19.
 * 邮箱：1871767675@qq.com
 */

public class BasePresenterImpl<V> implements IBasePresenter<V> {
    public V view;
    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();


    public BasePresenterImpl() {
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        compositeDisposable.dispose();
        this.view = null;
    }




    public V getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }


    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }


}

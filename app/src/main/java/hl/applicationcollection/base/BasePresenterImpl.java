package hl.applicationcollection.base;

/**
 * Created by huanglin on 2017/2/19.
 * 邮箱：1871767675@qq.com
 */

public class BasePresenterImpl<V> implements IBasePresenter<V> {
    public V view;


    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    public V getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }


}

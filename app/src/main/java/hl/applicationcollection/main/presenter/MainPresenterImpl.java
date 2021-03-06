package hl.applicationcollection.main.presenter;


import hl.applicationcollection.base.BasePresenterImpl;
import hl.applicationcollection.main.view.contract.IMainView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by huanglin on 2017/2/19.
 * 邮箱：1871767675@qq.com
 */

public class MainPresenterImpl extends BasePresenterImpl<IMainView> {
    public MainPresenterImpl(IMainView iMainView) {
        attachView(iMainView);
    }
}

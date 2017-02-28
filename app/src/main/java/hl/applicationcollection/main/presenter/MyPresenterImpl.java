package hl.applicationcollection.main.presenter;

import hl.applicationcollection.base.BasePresenterImpl;
import hl.applicationcollection.base.IBaseView;

/**
 * Created by huanglin on 2017/2/26.
 * 邮箱：1871767675@qq.com
 */

public class MyPresenterImpl extends BasePresenterImpl<IBaseView> {
    public MyPresenterImpl(IBaseView iBaseView) {
        attachView(iBaseView);
    }
}

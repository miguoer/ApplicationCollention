package hl.applicationcollection.main.presenter;

import hl.applicationcollection.base.BasePresenterImpl;
import hl.applicationcollection.base.IBaseView;

/**
 * Created by huanglin on 2017/2/23.
 * 邮箱：1871767675@qq.com
 */

public class HomePagePresenterImpl extends BasePresenterImpl<IBaseView> {
    public HomePagePresenterImpl(IBaseView iBaseView) {
        attachView(iBaseView);
    }
}

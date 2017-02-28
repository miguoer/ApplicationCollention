package hl.applicationcollection.main.presenter;

import android.support.v4.app.Fragment;

import hl.applicationcollection.base.BasePresenterImpl;
import hl.applicationcollection.base.IBaseView;

/**
 * Created by huanglin on 2017/2/26.
 * 邮箱：1871767675@qq.com
 */

public class FriendPresenterImpl extends BasePresenterImpl<IBaseView> {
    public FriendPresenterImpl(IBaseView iBaseView) {
        attachView(iBaseView);
    }
}

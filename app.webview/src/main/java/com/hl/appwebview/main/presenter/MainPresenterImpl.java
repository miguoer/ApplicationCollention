package com.hl.appwebview.main.presenter;

import com.hl.appwebview.base.BasePresenterImpl;
import com.hl.appwebview.main.view.contract.IMainView;

/**
 * Created by huanglin on 2017/5/1.
 */

public class MainPresenterImpl extends BasePresenterImpl<IMainView> {

    public MainPresenterImpl(IMainView iMainView) {
        attachView(iMainView);
    }

}

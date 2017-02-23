package hl.applicationcollection.main.view.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import butterknife.BindView;
import hl.applicationcollection.R;
import hl.applicationcollection.base.BaseActivity;
import hl.applicationcollection.main.presenter.MainPresenterImpl;
import hl.applicationcollection.main.view.activity.intrf.IMainView;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements IMainView{

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.vpMainActivity)
    ViewPager vpMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenterImpl bindPresenter() {
        return new MainPresenterImpl(this);
    }


    @Override
    public void showToast() {

    }

    @Override
    public void showWaittingDialog() {

    }

    @Override
    public void hideWaittingDialog() {

    }
}

package com.hl.appwebview.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.hl.appwebview.R;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.analytics.MobclickAgent;

import app.lib.utils.ActivityManager;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenterImpl> extends AppCompatActivity implements IBaseView{
    public final static String TAG = BaseActivity.class.getCanonicalName();//getCanonicalName()可返回完整包名信息，方便定位
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        presenter = bindPresenter();
        setContentView(bindLayout());
        ButterKnife.bind(this);
        setStatusBar();
        initData();
    }

    /**
     * 设置状态栏颜色
     */
    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected abstract void initData();

    protected abstract int bindLayout();

    protected abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public void showToast() {

    }

    @Override
    public void showWaitingDialog() {

    }

    @Override
    public void hideWaitingDialog() {

    }
}

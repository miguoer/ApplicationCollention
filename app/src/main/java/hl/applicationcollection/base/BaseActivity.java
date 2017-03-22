package hl.applicationcollection.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.squareup.leakcanary.RefWatcher;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import hl.applicationcollection.MyApplication;
import hl.applicationcollection.R;

public abstract class BaseActivity<P extends BasePresenterImpl> extends AppCompatActivity {
    public final static String TAG = BaseActivity.class.getCanonicalName();//getCanonicalName()可返回完整包名信息，方便定位
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        //销毁Activity时，检测内存泄露
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
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
}

package hl.applicationcollection.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
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
    }

    protected abstract int bindLayout();

    protected abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}

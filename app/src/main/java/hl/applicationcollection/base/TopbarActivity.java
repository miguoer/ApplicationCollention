package hl.applicationcollection.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hl.applicationcollection.R;
import hl.applicationcollection.utils.ActivityManager;

public abstract class TopbarActivity<P extends BasePresenterImpl> extends AppCompatActivity implements IBaseView{
    public final static String TAG = BaseActivity.class.getCanonicalName();//getCanonicalName()可返回完整包名信息，方便定位
    protected P presenter;
    @BindView(R.id.leftImage)
    ImageButton leftImage;
    @BindView(R.id.tvTopbarTitle)
    TextView tvTopbarTitle;
    @BindView(R.id.rlTopBar)
    RelativeLayout rlTopBar;
    @BindView(R.id.flBody)
    FrameLayout flBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_topbar);
        LayoutInflater.from(this).inflate(bindLayout(), (FrameLayout)findViewById(R.id.flBody),true);
        ButterKnife.bind(this);
        setStatusBar();
        initTop();
        initTopbarView();
        initTopbarData();
        initData();
    }

    private void initTop() {
        setTopbarTitle("");
    }

    /**
     * 设置标题
     * @param title
     */
    protected void setTopbarTitle(String title) {
        tvTopbarTitle.setText(title);
    }

    /**
     * 设置左边图片
     * @param resId
     */
    protected void setLeftImage(int resId) {
        leftImage.setImageResource(resId);
    }

    /**
     * 隐藏标题栏
     */
    protected void hideTopbar() {
        rlTopBar.setVisibility(View.GONE);
    }

    /**
     * 显示标题栏
     */
    protected void showTopbar() {
        rlTopBar.setVisibility(View.VISIBLE);
    }


    @OnClick(R.id.leftImage)
    public void onViewClicked() {
        finish();
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

    protected abstract void initTopbarData();

    protected abstract void initTopbarView();

    protected abstract int bindLayout();

    protected abstract P bindPresenter();

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

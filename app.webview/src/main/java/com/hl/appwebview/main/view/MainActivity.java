package com.hl.appwebview.main.view;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.hl.appwebview.R;
import com.hl.appwebview.base.BaseActivity;
import com.hl.appwebview.main.presenter.MainPresenterImpl;
import com.hl.appwebview.main.view.contract.IMainView;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements IMainView {

    public final static String TAG = MainActivity.class.getCanonicalName();//getCanonicalName()可返回完整包名信息，方便定位

    @BindView(R.id.btnOpenBaidu)
    Button btnOpenBaidu;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.e(TAG, "onCreate");
    }

    @Override
    protected void initData() {
//        webView.loadUrl(null);
        btnOpenBaidu.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);//允许和js交互
        webView.getSettings().setSupportZoom(true);//是否支持缩放
        webView.getSettings().setBuiltInZoomControls(true);//是否显示缩放工具
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

    }

    @Override
    protected int bindLayout() {
        return R.layout.app_webview_activity_main;
    }

    @Override
    protected MainPresenterImpl bindPresenter() {
        return new MainPresenterImpl(this);
    }

    @OnClick(R.id.btnOpenBaidu)
    public void openBaidu() {
        webView.loadUrl("http://baidu.com");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.e(TAG, "onDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.e(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.e(TAG, "onPause");

    }
}

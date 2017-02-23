package hl.applicationcollection.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by huanglin on 2017/2/19.
 * 邮箱：1871767675@qq.com
 */

public abstract class BaseFragment<P extends BasePresenterImpl> extends Fragment{

    protected View mRootView;

    protected Activity mActivity;

    protected P presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       if (bindLayout() != 0) {
           mRootView = inflater.inflate(bindLayout(),container, false);
           return mRootView;
       }else {
           return super.onCreateView(inflater, container, savedInstanceState);
       }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = bindPresenter();
        initData();
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract int bindLayout();

    protected abstract P bindPresenter();


}

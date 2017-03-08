package hl.applicationcollection.main.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hl.applicationcollection.R;
import hl.applicationcollection.base.BaseFragment;
import hl.applicationcollection.base.IBaseView;
import hl.applicationcollection.main.presenter.PublicPraisePresenterImpl;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by huanglin on 2017/2/25.
 * 邮箱：1871767675@qq.com
 */

public class PublicPraiseFragment extends BaseFragment<PublicPraisePresenterImpl> implements IBaseView {

    public PublicPraiseFragment(){}

    public static PublicPraiseFragment newInstance() {
        return FragmentBuilder.instance;
    }

    private static class FragmentBuilder {
        private static PublicPraiseFragment instance = new PublicPraiseFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_public_praise;
    }

    @Override
    protected PublicPraisePresenterImpl bindPresenter() {
        return new PublicPraisePresenterImpl(this);
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

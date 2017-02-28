package hl.applicationcollection.main.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hl.applicationcollection.R;
import hl.applicationcollection.base.BaseFragment;
import hl.applicationcollection.base.IBaseView;
import hl.applicationcollection.main.presenter.HomePagePresenterImpl;
import hl.applicationcollection.main.presenter.MyPresenterImpl;

/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends BaseFragment<MyPresenterImpl> implements IBaseView {

    public MyFragment() {
    }

    public static MyFragment newInstance() {
        return FragmentBuilder.instance;
    }

    private static class FragmentBuilder {
        private static MyFragment instance = new MyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected MyPresenterImpl bindPresenter() {
        return new MyPresenterImpl(this);
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

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
import hl.applicationcollection.main.presenter.FriendPresenterImpl;
import hl.applicationcollection.main.presenter.MyPresenterImpl;

/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link FriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendFragment extends BaseFragment<FriendPresenterImpl> implements IBaseView {

    public FriendFragment() {
        // Required empty public constructor
    }

    public static FriendFragment newInstance() {
        return FragmentBuilder.instance;
    }

    private static class FragmentBuilder {
        private static FriendFragment instance = new FriendFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
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
        return R.layout.fragment_friend;
    }

    @Override
    protected FriendPresenterImpl bindPresenter() {
        return new FriendPresenterImpl(this);
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

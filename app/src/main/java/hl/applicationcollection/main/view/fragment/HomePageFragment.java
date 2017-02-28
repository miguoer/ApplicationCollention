package hl.applicationcollection.main.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import hl.applicationcollection.R;
import hl.applicationcollection.base.BaseFragment;
import hl.applicationcollection.base.IBaseView;
import hl.applicationcollection.main.presenter.HomePagePresenterImpl;

/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends BaseFragment<HomePagePresenterImpl> implements IBaseView{;

    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    public HomePageFragment() {}

    public static HomePageFragment newInstance() {
        return FragmentBuilder.instance;
    }

    private static class FragmentBuilder {
        private static HomePageFragment instance = new HomePageFragment();
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
    protected void initData() {
        activity.setSupportActionBar(toolbar);
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected HomePagePresenterImpl bindPresenter() {
        return new HomePagePresenterImpl(this);
    }

    @Override
    protected void initView(View view) {

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
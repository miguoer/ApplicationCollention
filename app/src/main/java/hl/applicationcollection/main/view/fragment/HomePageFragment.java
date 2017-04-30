package hl.applicationcollection.main.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.spinytech.macore.MaApplication;
import com.spinytech.macore.router.LocalRouter;
import com.spinytech.macore.router.RouterRequest;
import com.spinytech.macore.router.RouterResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import hl.applicationcollection.R;
import hl.applicationcollection.base.BaseFragment;
import hl.applicationcollection.base.IBaseView;
import hl.applicationcollection.main.presenter.HomePagePresenterImpl;
import hl.applicationcollection.main.view.adapter.HomePageRecyclerViewAdapter;


/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends BaseFragment<HomePagePresenterImpl>  {
    ;

    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btnGoToGankModule)
    Button btnGoToGankModule;
    @BindView(R.id.btnPlayMusic)
    Button btnPlayMusic;

    private List<String> pluginsData;

    private HomePageRecyclerViewAdapter homePageRecyclerViewAdapter;


    public HomePageFragment() {
    }

    public static HomePageFragment newInstance() {
        return FragmentBuilder.instance;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.btnPlayMusic)
    public void playMusic() {
//        presenter.playMusic();
        final RouterRequest request = new RouterRequest.Builder(getActivity().getApplicationContext())
                .domain("hl.applicationcollection:music")
                .provider("music")
                .action("play")
                .build();
        try {

            final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                    .route(getContext(), RouterRequest.obtain(getContext())
                            .domain("hl.applicationcollection:music")
                            .provider("music")
                            .action("play"));
            response.isAsync();
        }catch (Exception e) {
            e.printStackTrace();
        }
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
//        presenter.loadData();
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

    @OnClick(R.id.btnGoToGankModule)
    public void goToGankModule() {
        ARouter.getInstance().build("/gank/gankMainActivity").navigation(activity);
    }
}

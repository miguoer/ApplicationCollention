package hl.applicationcollection.main.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import butterknife.BindView;
import hl.applicationcollection.R;
import hl.applicationcollection.base.BaseActivity;
import hl.applicationcollection.main.presenter.MainPresenterImpl;
import hl.applicationcollection.main.view.contract.IMainView;
import hl.applicationcollection.main.view.adapter.ViewPagerAdapter;
import hl.applicationcollection.main.view.fragment.FriendFragment;
import hl.applicationcollection.main.view.fragment.HomePageFragment;
import hl.applicationcollection.main.view.fragment.MyFragment;
import hl.applicationcollection.main.view.fragment.PublicPraiseFragment;
import hl.applicationcollection.utils.BottomNavigationViewHelper;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements IMainView{

    @BindView(R.id.bottomNavigationView)
    public BottomNavigationView bottomNavigationView;

    @BindView(R.id.vpMainActivity)
    public ViewPager vpMainActivity;

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void initData() {
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case  R.id.itemHomePage:
                        vpMainActivity.setCurrentItem(0);
                        break;
                    case R.id.itemPublicPraise:
                        vpMainActivity.setCurrentItem(1);
                        break;
                    case R.id.itemFriend:
                        vpMainActivity.setCurrentItem(2);
                        break;
                    case R.id.itemMy:
                        vpMainActivity.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        vpMainActivity.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initAdapter();

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HomePageFragment.newInstance());
        adapter.addFragment(PublicPraiseFragment.newInstance());
        adapter.addFragment(FriendFragment.newInstance());
        adapter.addFragment(MyFragment.newInstance());
        vpMainActivity.setAdapter(adapter);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenterImpl bindPresenter() {
        return new MainPresenterImpl(this);
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

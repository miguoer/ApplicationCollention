package hl.applicationcollection.main.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

import hl.applicationcollection.base.BaseFragment;
import hl.applicationcollection.base.BasePresenterImpl;


/**
 * Created by huanglin on 2017/2/25.
 * 邮箱：1871767675@qq.com
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<BaseFragment<BasePresenterImpl>> mFragmentList = new ArrayList<BaseFragment<BasePresenterImpl>>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(BaseFragment fragment) {
        mFragmentList.add(fragment);
    }
}

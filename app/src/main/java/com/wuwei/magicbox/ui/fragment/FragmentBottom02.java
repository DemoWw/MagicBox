package com.wuwei.magicbox.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.MainActivity;
import com.wuwei.magicbox.util.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2017/9/13.
 */

public class FragmentBottom02 extends Fragment {

    @BindView(R.id.vp_bottom02)
    ViewPager mViewPager;

    private MainActivity mActivity;

    private TabLayout mTabLayout;

    private String[] tabNames = new String[]{"云计算", "大数据"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottom02, container, false);

        ButterKnife.bind(this, view);

        mActivity = (MainActivity) getActivity();
        mTabLayout = mActivity.getTabLayout();

        mViewPager.setAdapter(new InnerFragmentPagerAdapter(mActivity.getSupportFragmentManager()));

        AppUtils.bindTabLayout(mViewPager, mTabLayout, tabNames, TabLayout.MODE_SCROLLABLE);

        return view;
    }

    private class InnerFragmentPagerAdapter extends FragmentPagerAdapter {

        public InnerFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = new Fragment04();
                    break;
                case 1:
                    fragment = new Fragment05();
                    break;
                default:
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public String[] getTabNames() {
        return tabNames;
    }

    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);

        TabLayout.Tab tab0 = mTabLayout.getTabAt(0);
        TabLayout.Tab tab1 = mTabLayout.getTabAt(1);
        TabLayout.Tab tab2 = mTabLayout.getTabAt(2);

        if (tab0 != null && tab1 != null) {
            tab0.setText("Java");
            tab1.setText("云计算");
        }
        if (tab2 != null) {
            mTabLayout.removeTab(tab2);
        }

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}

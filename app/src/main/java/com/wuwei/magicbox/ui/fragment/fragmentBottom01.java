package com.wuwei.magicbox.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tarena on 2017/9/13.
 */

public class fragmentBottom01 extends Fragment {

    @BindView(R.id.vp_bottom01)
    ViewPager viewPager;

    private MainActivity mActivity;

    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottom01, container, false);

        ButterKnife.bind(this, view);

        mActivity = (MainActivity) getActivity();
        mTabLayout = mActivity.getTabLayout();

        viewPager.setAdapter(new InnerFragmentPagerAdapter(getActivity().getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tab0 = mTabLayout.getTabAt(0);
        TabLayout.Tab tab1 = mTabLayout.getTabAt(1);
        TabLayout.Tab tab2 = mTabLayout.getTabAt(2);

        if (tab0 != null && tab1 != null && tab2 != null) {
            tab0.setText("首页");
            tab1.setText("Android");
            tab2.setText("IOS");
        }


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
                    fragment = new Fragment01();
                    break;
                case 1:
                    fragment = new Fragment02();
                    break;
                case 2:
                    fragment = new Fragment03();
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}

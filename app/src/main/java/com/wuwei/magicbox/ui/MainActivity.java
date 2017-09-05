package com.wuwei.magicbox.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.fragment.Fragment01;
import com.wuwei.magicbox.ui.fragment.Fragment02;
import com.wuwei.magicbox.ui.fragment.Fragment03;
import com.wuwei.magicbox.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    @BindView(R.id.layout_root)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_main)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ff00")));

        tabLayout.addTab(tabLayout.newTab().setText("首页"));
        tabLayout.addTab(tabLayout.newTab().setText("Android"));
        tabLayout.addTab(tabLayout.newTab().setText("IOS"));

        toolbar.setOnMenuItemClickListener(this);

        viewPager.setAdapter(new InnerFragmentPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("首页");
        tabLayout.getTabAt(1).setText("Android");
        tabLayout.getTabAt(2).setText("IOS");

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

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                Snackbar.make(coordinatorLayout, "its a snack bar!", Snackbar.LENGTH_SHORT).setAction("action",null).show();
                break;
            default:
                break;
        }

        return false;
    }

    /** 创建菜单 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

}

package com.wuwei.magicbox.ui;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.fragment.FragmentBottom01;
import com.wuwei.magicbox.ui.fragment.FragmentBottom02;
import com.wuwei.magicbox.ui.fragment.FragmentBottom03;
import com.wuwei.magicbox.ui.fragment.FragmentBottom04;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener,
        NavigationView.OnNavigationItemSelectedListener, BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.layout_root)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.bottom_navigation)
    BottomNavigationBar bottomNavigationView;

//    @BindView(R.id.fl_main_container)
//    FrameLayout mFlContainer;

//    @BindView(R.id.linear_bottom)
//    LinearLayout linearBottom;

//    private Animation animationIn;
//
//    private Animation animationOut;

    private FragmentBottom01 mFragmentBottom01;
    private FragmentBottom02 mFragmentBottom02;
    private FragmentBottom03 mFragmentBottom03;
    private FragmentBottom04 mFragmentBottom04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setBottomFragment(0);

    }

    private void initView() {
        // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ff00")));

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        toolbar.setOnMenuItemClickListener(this);

        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "资讯")/*.setActiveColorResource(R.color.colorAccent)*/)
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "音乐")/*.setActiveColorResource(R.color.colorPrimary)*/)
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "我")/*.setActiveColorResource(R.color.yellow)*/)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();
        bottomNavigationView.setTabSelectedListener(this);

        //animationIn = AnimationUtils.loadAnimation(this, R.anim.in_from_down);
        //animationOut = AnimationUtils.loadAnimation(this, R.anim.out_to_down);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.wallet:

                break;
        }

        return true;
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

    public void btnClick(View view) {
        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_main_container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }


    private void setBottomFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        hideAllBottomFragment(transaction);

        switch (index) {
            case 0:
                if (mFragmentBottom01 == null) {
                    mFragmentBottom01 = new FragmentBottom01();
                    transaction.add(R.id.fl_main_container, mFragmentBottom01);
                    transaction.addToBackStack(null);
                } else {
                    transaction.show(mFragmentBottom01);
                }
                break;
            case 1:
                if (mFragmentBottom02 == null) {
                    mFragmentBottom02 = new FragmentBottom02();
                    transaction.add(R.id.fl_main_container, mFragmentBottom02);
                    transaction.addToBackStack(null);
                } else {
                    transaction.show(mFragmentBottom02);
                }
                break;
            case 2:
                if (mFragmentBottom03 == null) {
                    mFragmentBottom03 = new FragmentBottom03();
                    transaction.add(R.id.fl_main_container, mFragmentBottom03);
                    transaction.addToBackStack(null);
                } else {
                    transaction.show(mFragmentBottom03);
                }
                break;
            case 3:
                if (mFragmentBottom04 == null) {
                    mFragmentBottom04 = new FragmentBottom04();
                    transaction.add(R.id.fl_main_container, mFragmentBottom04);
                    transaction.addToBackStack(null);
                } else {
                    transaction.show(mFragmentBottom04);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideAllBottomFragment(FragmentTransaction transaction) {

        if (mFragmentBottom01 != null) {
            transaction.hide(mFragmentBottom01);
        }
        if (mFragmentBottom02 != null) {
            transaction.hide(mFragmentBottom02);
        }
        if (mFragmentBottom03 != null) {
            transaction.hide(mFragmentBottom03);
        }
        if (mFragmentBottom04 != null) {
            transaction.hide(mFragmentBottom04);
        }

    }

    @Override
    public void onTabSelected(int position) {
        setBottomFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    //    public void setBottomVisibility(boolean isShow) {
//
//        if (isShow) {
//
//            if (linearBottom.getVisibility() != View.VISIBLE) {
//
//                linearBottom.startAnimation(animationIn);
//                linearBottom.setVisibility(View.VISIBLE);
//            }
//        } else {
//            linearBottom.setAnimation(animationOut);
//            animationOut.start();
//            if (linearBottom.getVisibility() == View.VISIBLE) {
//                linearBottom.startAnimation(animationOut);
//                linearBottom.setVisibility(View.GONE);
//            }
//        }
//    }



}

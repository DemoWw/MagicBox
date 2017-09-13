package com.wuwei.magicbox.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.fragment.Fragment01;
import com.wuwei.magicbox.ui.fragment.Fragment02;
import com.wuwei.magicbox.ui.fragment.Fragment03;
import com.wuwei.magicbox.ui.fragment.fragmentBottom01;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener,
        NavigationView.OnNavigationItemSelectedListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        replaceFragment(new fragmentBottom01());

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

        //animationIn = AnimationUtils.loadAnimation(this, R.anim.in_from_down);
        //animationOut = AnimationUtils.loadAnimation(this, R.anim.out_to_down);

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_main_container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
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

    public void btnClick(View view) {
        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

}

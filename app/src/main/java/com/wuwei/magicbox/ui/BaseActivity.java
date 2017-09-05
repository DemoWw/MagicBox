package com.wuwei.magicbox.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.util.LogUtils;

/**
 * Created by wuwei on 2017/9/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.tb_include)
    Toolbar toolbar;

    ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.add(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.bind(this);

        LogUtils.w(toolbar.toString());

        setSupportActionBar(toolbar);
        if (toolbar != null) {
            actionBar = getSupportActionBar();
        }
    }

    @Override
    protected void onDestroy() {
        ActivityManager.remove(this);
        super.onDestroy();
    }

}

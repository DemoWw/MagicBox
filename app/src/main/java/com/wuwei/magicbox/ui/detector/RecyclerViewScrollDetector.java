package com.wuwei.magicbox.ui.detector;

import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.wuwei.magicbox.util.LogUtils;

/**
 * Created by wuwei on 2017/9/8.
 */

public abstract class RecyclerViewScrollDetector extends RecyclerView.OnScrollListener {

    public abstract void onScrollUp();
    public abstract void onScrollDown();

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        boolean isVertical = Math.abs(dy) > 4;

        if (isVertical) {
            if (dy > 0) {
                //LogUtils.e("向上滑动！！");
                onScrollUp();
            } else {
                //LogUtils.e("向下滑动！！");
                onScrollDown();
            }

        }

    }
}

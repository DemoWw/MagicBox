package com.wuwei.magicbox.ui.detector;

import android.view.MotionEvent;
import android.view.View;

import com.wuwei.magicbox.util.LogUtils;

/**
 * Created by wuwei on 2017/9/8.
 */

public abstract class ViewScrollDetector implements View.OnTouchListener {

    private float startX;

    private float startY;

    private float movedY;

    private float movedX;

    private float offsetY;

    private float offsetX;

    public abstract void onScrollingUp();

    public abstract void onScrollingDown();

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = event.getRawY();
                //startX = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                //movedX = event.getRawX();
                movedY = event.getRawY();
                offsetY = movedY - startY;
                //offsetX = movedX - startX;

                if (Math.abs(offsetY) > 2) {
                    if (offsetY > 0) {
                        onScrollingDown();
                    } else {
                        onScrollingUp();
                    }
                }

                startY = movedY;
                break;
            case MotionEvent.ACTION_UP:
                //offsetY = 0;
                movedY = 0;
                //offsetX = 0;
                movedY = 0;
                break;
        }

        return false;
    }
}

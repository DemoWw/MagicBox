package com.wuwei.magicbox.ui;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuwei on 2017/9/4.
 */

public class ActivityManager {

    private ActivityManager() {}

    private static List<Activity> activities = new ArrayList<>();

    public static boolean add(Activity activity) {
        return activities.add(activity);
    }

    public static boolean remove(Activity activity) {
        return activities.remove(activity);
    }

    /**
     * 退出程序，结束所有activity
     */
    public static void exit() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }

}

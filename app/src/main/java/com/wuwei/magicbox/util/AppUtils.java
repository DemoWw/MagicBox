package com.wuwei.magicbox.util;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

/**
 * Created by wuwei on 2017/9/19.
 */

public class AppUtils {

    public static void bindTabLayout(ViewPager viewPager, TabLayout tabLayout, String[] tag, @TabLayout.Mode int mode) {

        if (tabLayout == null || viewPager == null || tag.length == 0) {
            return;
        }

        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tab;
        int len = tabLayout.getTabCount() > tag.length ? tabLayout.getTabCount() : tag.length;
        for (int i = 0; i < len; i++) {
            tab = tabLayout.getTabAt(i);
            if (i < tag.length) {
                if (tab == null) {
                    tabLayout.addTab(tabLayout.newTab(), i);
                    tab = tabLayout.getTabAt(i);
                }
                if (tab != null) {
                    tab.setText(tag[i]);
                }
            } else {
                if (tab != null) {
                    tabLayout.removeTab(tab);
                }
            }
        }

        tabLayout.setTabMode(mode);
    }

    /**
     * 获得当前主题的相关颜色
     * @param context
     * @param resid 要获取的颜色资源id，例如：R.attr.colorPrimary
     * @return 返回颜色值
     */
    public static int getThemeColor(Context context, int resid) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(resid, typedValue, true);
        return typedValue.data;
    }

}

package com.wuwei.magicbox.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.wuwei.magicbox.util.LogUtils;

/**
 * Created by tarena on 2017/9/11.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.e("123456798789");
    }
}

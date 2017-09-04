package com.wuwei.magicbox.util;

import android.util.Log;

/**
 * Created by tarena on 2017/9/4.
 *
 * 日志工具类
 */
public class LogUtils {

    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARN = 3;
    public static final int LEVEL_ERROR = 4;

    /**
     * 当前允许输出的日志级别
     */
    private static int currentLogLevel = LEVEL_VERBOSE;

    private static final String TAG = "MAGIC_BOX";

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int v(String tag, String msg) {
        if (currentLogLevel <= LEVEL_VERBOSE) {
            return Log.v(tag, msg);
        }
        return -1;
    }

    public static int v(String msg) {
        return v(TAG, msg);
    }

    public static int d(String tag, String msg) {
        if (currentLogLevel <= LEVEL_DEBUG) {
            return Log.d(tag, msg);
        }
        return -1;
    }

    public static int d(String msg) {
        return d(TAG, msg);
    }

    public static int i(String tag, String msg) {
        if (currentLogLevel <= LEVEL_INFO) {
            return Log.i(tag, msg);
        }
        return -1;
    }

    public static int i(String msg) {
        return i(TAG, msg);
    }

    public static int w(String tag, String msg) {
        if (currentLogLevel <= LEVEL_WARN) {
            return Log.w(tag, msg);
        }
        return -1;
    }

    public static int w(String msg) {
        return w(TAG, msg);
    }

    public static int e(String tag, String msg) {
        if (currentLogLevel <= LEVEL_ERROR) {
            return Log.e(tag, msg);
        }
        return -1;
    }

    public static int e(String msg) {
        return e(TAG, msg);
    }

}


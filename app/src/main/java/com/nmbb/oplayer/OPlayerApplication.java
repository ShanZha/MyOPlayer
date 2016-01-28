package com.nmbb.oplayer;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nmbb.oplayer.util.FileUtils;

public class OPlayerApplication extends Application {

    private static OPlayerApplication mApplication;

    public static final String OPLAYER_CACHE_BASE = Environment.getExternalStorageDirectory() + "/oplayer";
    public static final String OPLAYER_VIDEO_THUMB = OPLAYER_CACHE_BASE + "/thumb/";
    public static final String PREF_KEY_FIRST = "application_first";

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        init();
    }

    private void init() {
        FileUtils.createIfNoExists(OPLAYER_CACHE_BASE);
        FileUtils.createIfNoExists(OPLAYER_VIDEO_THUMB);
    }

    public static OPlayerApplication getApplication() {
        return mApplication;
    }

    public static Context getContext() {
        return mApplication;
    }

    public void destory() {
        mApplication = null;
    }
}
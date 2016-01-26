package com.nmbb.oplayer;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nmbb.oplayer.util.FileUtils;

/**
 * Created by xuebp on 2016/1/26.
 */
public class OPlayerApplication extends Application {
    private static OPlayerApplication mApplication;
    /** OPlayer SD������·�� */
    public static final String OPLAYER_CACHE_BASE= Environment.getExternalStorageDirectory()+"/oplayer";
    /** ��Ƶ��ͼ����·�� */
    public static final String OPLAYER_VIDEO_THUME=OPLAYER_CACHE_BASE+"/thumb/";
    /** �״�ɨ�� */
    public static final String PREF_KEY_FIRST="application_first";

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;

        init();
    }
    private void init(){
        //��������Ŀ¼
        FileUtils.createIfNoExists(OPLAYER_CACHE_BASE);
        FileUtils.createIfNoExists(OPLAYER_VIDEO_THUME);
    }
    public static OPlayerApplication getApplication(){
        return mApplication;
    }

    public static Context getContext(){
        return mApplication;
    }
    /** ���� */
    public void destory() {
        mApplication = null;
    }

}

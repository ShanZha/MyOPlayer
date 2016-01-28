package com.nmbb.oplayer.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.nmbb.oplayer.OPlayerApplication;
import com.nmbb.oplayer.OPreference;
import com.nmbb.oplayer.R;
import com.nmbb.oplayer.service.MediaScannerService;
import com.nmbb.oplayer.ui.helper.FileDownloadHelper;
import com.nmbb.oplayer.ui.vitamio.LibsChecker;

public class MainActivity extends FragmentActivity implements OnClickListener {


    private ViewPager mPager;
    private RadioButton mRadioFile;
    private RadioButton mRadioOnline;
    public FileDownloadHelper mFileDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//		LibsChecker.checkVitamioLibs(ctx)
        if (!LibsChecker.checkVitamioLibs(this, R.string.init_decoders))
            return;

        OPreference pref = new OPreference(this);
        //	�״����У�ɨ��SD��
        if (pref.getBoolean(OPlayerApplication.PREF_KEY_FIRST, true)) {
            getApplicationContext().startService(new Intent(getApplicationContext(), MediaScannerService.class).putExtra(MediaScannerService.EXTRA_DIRECTORY, Environment.getExternalStorageDirectory().getAbsolutePath()));
        }

        setContentView(R.layout.fragment_pager);

        // ~~~~~~ �󶨿ؼ�
        mPager = (ViewPager) findViewById(R.id.pager);
        mRadioFile = (RadioButton) findViewById(R.id.radio_file);
        mRadioOnline = (RadioButton) findViewById(R.id.radio_online);

        // ~~~~~~ ���¼�
        mRadioFile.setOnClickListener(this);
        mRadioOnline.setOnClickListener(this);
        mPager.setOnPageChangeListener(mPagerListener);

        // ~~~~~~ ������
        mPager.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentByPosition(mPager.getCurrentItem()).onBackPressed())
            return;
        else
            super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mFileDownload != null)
            mFileDownload.stopALl();
    }

    /** ����Fragment */
    private FragmentBase getFragmentByPosition(int position) {
        return (FragmentBase) getSupportFragmentManager().findFragmentByTag("android:switcher:" + mPager.getId() + ":" + position);
    }

    private FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        /** ��ִ��һ�� */
        @Override
        public Fragment getItem(int position) {
            Fragment result = null;
            switch (position) {
                case 1:
                    result = new FragmentOnline();// ������Ƶ
                    break;
                case 0:
                default:
                    result = new FragmentFileOld();// ������Ƶ
                    mFileDownload = new FileDownloadHelper(((FragmentFileOld) result).mDownloadHandler);
                    break;
            }
            return result;
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    private ViewPager.SimpleOnPageChangeListener mPagerListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:// ������Ƶ
                    mRadioFile.setChecked(true);
                    break;
                case 1:// ������Ƶ
                    mRadioOnline.setChecked(true);
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radio_file:
                mPager.setCurrentItem(0);
                break;
            case R.id.radio_online:
                mPager.setCurrentItem(1);
                break;
        }
    }
}

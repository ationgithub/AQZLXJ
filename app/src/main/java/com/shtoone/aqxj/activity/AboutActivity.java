package com.shtoone.aqxj.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.adapter.AboutActivityViewPagerAdapter;

/**
 * Created by leguang on 2016/6/11.
 */

public class AboutActivity extends BaseActivity {
    private static final String TAG = AboutActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initView();
        initDate();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar_tablayout);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_toolbar_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.vp_about_activity);
    }

    private void initDate() {
        mToolbar.setTitle("关于");
        initToolbarBackNavigation(mToolbar);
        mViewPager.setAdapter(new AboutActivityViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}

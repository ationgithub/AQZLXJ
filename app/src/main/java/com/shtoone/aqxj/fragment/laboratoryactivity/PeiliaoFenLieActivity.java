package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.adapter.PeiliaoFenLieAdapter;
import com.shtoone.aqxj.bean.PeiliaoTongzhidanFragmentListData;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by Administrator on 2017/9/12.
 */

public class PeiliaoFenLieActivity extends BaseActivity {

    private Toolbar mToolbar;
    private AHBottomNavigation bottomNavigation;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private AppBarLayout mAppBarLayout;
    private PeiliaoFenLieAdapter mAdapter;
    private PeiliaoTongzhidanFragmentListData.DataBean mDataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_yclquery);
        initView();
        initData();
    }

    private void initView() {
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar_toolbar_tablayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar_tablayout);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_toolbar_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.vp_jinchu_fragment);
    }

    private void initData() {
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        mDataBean = (PeiliaoTongzhidanFragmentListData.DataBean) getIntent().getSerializableExtra("PeiliaoTongzhidanDetail");
        setAdapter();
    }

    private void setAdapter() {
        mViewPager.setAdapter(mAdapter = new PeiliaoFenLieAdapter(getSupportFragmentManager(), mDataBean));
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append("配比通知单详情");
            mToolbar.setTitle(sb.toString());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }


}

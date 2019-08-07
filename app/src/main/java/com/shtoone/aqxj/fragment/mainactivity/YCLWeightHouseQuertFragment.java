package com.shtoone.aqxj.fragment.mainactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.adapter.YCLWeightHousePagerAdapter;
import com.shtoone.aqxj.fragment.base.BaseLazyFragment;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by Administrator on 2017/8/18.
 */

public class YCLWeightHouseQuertFragment extends BaseLazyFragment {

    private Toolbar mToolbar;
    private AHBottomNavigation bottomNavigation;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private AppBarLayout mAppBarLayout;
    private YCLWeightHousePagerAdapter mAdapter;

    public static YCLWeightHouseQuertFragment newInstance() {
        return new YCLWeightHouseQuertFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BaseApplication.bus.register(this);
        View view = inflater.inflate(R.layout.fragment_yclquery, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.appbar_toolbar_tablayout);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_toolbar_tablayout);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout_toolbar_tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_jinchu_fragment);
    }


    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);

        setAdapter();
    }

    private void setAdapter() {
        mViewPager.setAdapter(mAdapter = new YCLWeightHousePagerAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append("进出厂台账");
            mToolbar.setTitle(sb.toString());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //返回到看见此fragment时，fab显示
    }

    @Override
    public void onPause() {
        super.onPause();
        //防止屏幕旋转后重画时fab显示
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }

}

package com.shtoone.aqxj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.fragment.weighthouseactivity.EnterPoundsQuery;
import com.shtoone.aqxj.fragment.weighthouseactivity.PlayPoundsQuery;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.squareup.otto.Subscribe;

public class WeightHouseViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = WeightHouseViewPagerAdapter.class.getSimpleName();
    private String[] titleType = {"进场过磅", "出场过磅"};
    private ParametersData mParametersData;
    private boolean isRegistered = false;

    public WeightHouseViewPagerAdapter(FragmentManager fm, ParametersData mParametersData) {
        super(fm);
        this.mParametersData = mParametersData;
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
    }

    @Override
    public Fragment getItem(int position) {
        ParametersData mParametersData = (ParametersData) this.mParametersData.clone();
        Fragment fragment=null;
        switch (position){
            case  0:
                fragment= EnterPoundsQuery.newInstance(mParametersData);
                break;
            case 1:
                fragment= PlayPoundsQuery.newInstance(mParametersData);
                break;
        }
        return  fragment;
    }

    @Override
    public int getCount() {
        if (null != titleType) {
            return titleType.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != titleType) {
            return titleType[position];
        }
        return null;
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == ConstantsUtils.WEIGHTHOUSEFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.userGroupID = mParametersData.userGroupID;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.cailiaono = mParametersData.cailiaono;
                Log.e("mParametersData:6666", mParametersData.userGroupID);
            }
        }
    }

    public void unRegister() {
        BaseApplication.bus.unregister(this);
    }
}

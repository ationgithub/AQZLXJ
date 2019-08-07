package com.shtoone.aqxj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.fragment.engineeringactivity.JobOrderUnFinishFragment;
import com.shtoone.aqxj.fragment.engineeringactivity.JobOrderFinishFragment;

/**
 * Created by Administrator on 2017/8/18.
 */

public class JobOrderPagerAdapter extends FragmentPagerAdapter {


    private String[] titleType = {"未生产", "已生产"};
    private boolean isRegistered = false;


    public JobOrderPagerAdapter(FragmentManager fm) {
        super(fm);
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case  0:
                fragment= JobOrderUnFinishFragment.newInstance();
                break;
            case 1:
                fragment= JobOrderFinishFragment.newInstance();
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

    public void unRegister() {
        BaseApplication.bus.unregister(this);
    }
}

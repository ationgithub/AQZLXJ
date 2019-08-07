package com.shtoone.aqxj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.aqxj.bean.PeiliaoTongzhidanFragmentListData;
import com.shtoone.aqxj.fragment.laboratoryactivity.LilunPeihebiDetailFragment;
import com.shtoone.aqxj.fragment.laboratoryactivity.PeiliaoTongzhidanDetailFragment;
import com.shtoone.aqxj.fragment.laboratoryactivity.TaskListDetailFragment;

/**
 * Created by Administrator on 2017/9/12.
 */

public class PeiliaoFenLieAdapter extends FragmentPagerAdapter {

    private String[] titleType = {"配料通知单", "理论配合比","任务单"};
    private boolean isRegistered = false;
    PeiliaoTongzhidanFragmentListData.DataBean itemsData;

    public PeiliaoFenLieAdapter(FragmentManager fm,PeiliaoTongzhidanFragmentListData.DataBean itemsData) {
        super(fm);
        this.itemsData = itemsData;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case  0:
                fragment= PeiliaoTongzhidanDetailFragment.newInstance(itemsData);
                break;
            case 1:
                fragment= LilunPeihebiDetailFragment.newInstance(itemsData);
                break;

            case 2:
                fragment= TaskListDetailFragment.newInstance(itemsData.getRenwuNo(),"1");
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
}

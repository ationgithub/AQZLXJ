package com.shtoone.aqxj.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.fragment.EngineeringDepartment.YCLChuChangWeightFragment;

/**
 * Created by Administrator on 2017/10/8.
 */

public class YCLChuChangWeightActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joborderuncompounding);
        FrameLayout container = (FrameLayout) findViewById(R.id.root_layout_joborderuncompounding);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        YCLChuChangWeightFragment yclChuChangWeightFragment =  YCLChuChangWeightFragment.newInstance();
        transaction.add(R.id.root_layout_joborderuncompounding, yclChuChangWeightFragment);
        transaction.commit();
    }

}
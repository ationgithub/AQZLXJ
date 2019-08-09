package com.shtoone.aqxj.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/8.
 */

public class JobOrderUnSubmitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joborderunsubmit);
        FrameLayout container = (FrameLayout) findViewById(R.id.root_layout_joborderunsubmit);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        JobOrderUnSubmitFragment jobOrderUnSubmitFragment =  JobOrderUnSubmitFragment.newInstance();
//        transaction.add(R.id.root_layout_joborderunsubmit, jobOrderUnSubmitFragment);
        transaction.commit();
    }
}

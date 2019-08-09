package com.shtoone.aqxj.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;

/**
 * Created by liangfeng on 2017/9/30.
 */

public class AllPowerTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_power_test);
        FrameLayout container = (FrameLayout) findViewById(R.id.root_layout_all_power_test);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        QuyangFragment wannengjiFragment = QuyangFragment.newInstance();
//        transaction.add(R.id.root_layout_all_power_test, wannengjiFragment);
        transaction.commit();
    }

}

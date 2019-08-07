package com.shtoone.aqxj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.widget.FrameLayout;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.fragment.engineeringactivity.JobOrderUnVerifyFragment;

/**
 * Created by Administrator on 2017/10/8.
 */

public class JobOrderUnVerifyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joborderunsubmit);
        FrameLayout container = (FrameLayout) findViewById(R.id.root_layout_joborderunsubmit);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        JobOrderUnVerifyFragment jobOrderUnSubmitFragment =  JobOrderUnVerifyFragment.newInstance();
        transaction.add(R.id.root_layout_joborderunsubmit, jobOrderUnSubmitFragment);
        transaction.commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        String extra = intent.getStringExtra("flag");
        if (!TextUtils.isEmpty(extra)){
            if (extra.equals("home")){
                //接收到值的具体操作

            }
        }
    }
}

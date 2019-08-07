package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.QuyangFragmentListData;

/**
 * Created by Administrator on 2017/10/8.
 */

public class YangbenListActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent ii = getIntent();
        QuyangFragmentListData.DataBean db = (QuyangFragmentListData.DataBean)ii.getSerializableExtra("quyangDetail");
        setContentView(R.layout.activity_joborderuncompounding);
        FrameLayout container = (FrameLayout) findViewById(R.id.root_layout_joborderuncompounding);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        YangbenListFragment yclJinChangWeightFragment =  YangbenListFragment.newInstance(db);
        transaction.add(R.id.root_layout_joborderuncompounding, yclJinChangWeightFragment);
        transaction.commit();
    }

}

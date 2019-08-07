package com.shtoone.aqxj.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.adapter.StorageDetailActivityRecyclerViewAdapter;
import com.shtoone.aqxj.bean.StorageFragmentListData;
import com.shtoone.aqxj.bean.StorageQueryDetailActivityData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

/**
 * Created by Administrator on 2017/8/7.
 */
public class StroageDetailActivity extends BaseActivity {

    private static final String TAG = StroageDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private StorageQueryDetailActivityData data;
    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private RecyclerView mRecyclerView;
    private StorageDetailActivityRecyclerViewAdapter mAdapter;
    private StorageFragmentListData.DataBean mDataBean;
    private Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_detail);
        initView();
        initDate();
    }

    private void initView() {
        mDataBean = (StorageFragmentListData.DataBean) getIntent().getSerializableExtra("producequerydetail");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_produce_query_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_produce_query_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_produce_query_detail_activity);
        tv0 = (TextView) findViewById(R.id.tv0_storage_detail_activity);
        tv1 = (TextView) findViewById(R.id.tv1_storage_detail_activity);
        tv2 = (TextView) findViewById(R.id.tv2_storage_detail_activity);
        tv3 = (TextView) findViewById(R.id.tv3_storage_detail_activity);
        tv4 = (TextView) findViewById(R.id.tv4_storage_detail_activity);
        tv5 = (TextView) findViewById(R.id.tv5_storage_detail_activity);
        tv6 = (TextView) findViewById(R.id.tv6_storage_detail_activity);
        tv7 = (TextView) findViewById(R.id.tv7_storage_detail_activity);
        tv8 = (TextView) findViewById(R.id.tv8_storage_detail_activity);
        tv9 = (TextView) findViewById(R.id.tv9_storage_detail_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_storage_query_detail_activity);
    }

    private void initDate() {
        mGson = new Gson();
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        setSupportActionBar(mToolbar);
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mNestedScrollView.getScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String createRefreshULR() {
        mPageStateLayout.showLoading();
        String produceDetailData = URL.getStorageDetailData(mDataBean.getDepartId(),mDataBean.getId(),mDataBean.getCailiaoguid());
        Log.e(TAG,"url=:"+produceDetailData);
        return URL.getStorageDetailData(mDataBean.getDepartId(),mDataBean.getId(),mDataBean.getCailiaoguid());
    }

    @Override
    public void onRefreshSuccess(String response) {
        if (!TextUtils.isEmpty(response)) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
                mPageStateLayout.showError();
                return;
            }
            if (jsonObject.optBoolean("success")) {
                data = mGson.fromJson(response, StorageQueryDetailActivityData.class);
                if (null != data) {
                    if (data.isSuccess()) {
                        mPageStateLayout.showContent();
                        setAdapter();
                    } else {
                        //提示数据为空，展示空状态
                        mPageStateLayout.showEmpty();
                    }
                } else {
                    //提示数据解析异常，展示错误页面
                    mPageStateLayout.showError();
                }
            } else {
                //提示数据为空，展示空状态
                mPageStateLayout.showEmpty();
            }
        } else {
            //提示返回数据异常，展示错误页面
            mPageStateLayout.showError();
        }
    }

    @Override
    public void onRefreshFailed(VolleyError error) {
        //提示网络数据异常，展示网络错误页面。此时：1.可能是本机网络有问题，2.可能是服务器问题
        if (!NetworkUtils.isConnected(this)) {
            //提示网络异常,让用户点击设置网络
            mPageStateLayout.showNetError();
        } else {
            //服务器异常，展示错误页面，点击刷新
            mPageStateLayout.showError();
        }
    }

    //还是不能这样搞，可能会内存泄漏，重复创建Adapyer对象。后面解决
    private void setAdapter() {
        // 设置显示数据
        StorageQueryDetailActivityData.DeatilDataBean deatilDataBean = data.getDeatilData().get(0);
        tv0.setText(deatilDataBean.getDepartname());//所属机构
        tv1.setText(deatilDataBean.getCailiaoname());//材料名称
        tv2.setText(deatilDataBean.getJinliang());//材料进量
        tv3.setText(deatilDataBean.getLilun());//理论出量
        tv4.setText(deatilDataBean.getShiji());//实际出量
        tv5.setText(deatilDataBean.getResult());//库存
        tv6.setText(deatilDataBean.getXiuzheng());//修正量
        tv7.setText(deatilDataBean.getChushi());//初始量
        tv8.setText((deatilDataBean.getBaojing() == "1"?"报警":"不报警"));//是否报警
        tv9.setText(deatilDataBean.getJingjiezhi()+"");//警戒值

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置动画与适配器
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new StorageDetailActivityRecyclerViewAdapter(this, data.getXiuZhengMsg()));
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.storage) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}

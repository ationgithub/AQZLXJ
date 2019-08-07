package com.shtoone.aqxj.fragment.engineeringactivity;

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
import com.shtoone.aqxj.adapter.TaskListDetailActivityRecylerView;
import com.shtoone.aqxj.adapter.TaskListDetailReportRecylerView;
import com.shtoone.aqxj.bean.TaskListDetailActivityData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TaskListDetailActivity extends BaseActivity {

    private static final String TAG = TaskListDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private String id;
    private String biaoshi;
    private Gson mGson;

    private TextView tv_renwuno;
    private TextView tv_time;
    private TextView tv_gcmc;
    private TextView tv_jzfs;
    private TextView tv_fangliang;
    private TextView tv_jzbw;
    private TextView tv_depart;
    private TextView tv_sjqd;
    private TextView tv_jhfl;
    private TextView tv_wcfl;
    private TextView tv_pan_count;
    private TextView tv_zxjd;
    private TextView tv_jiechao;

    private TaskListDetailActivityData data;
    private RecyclerView mRecyclerView;
    private RecyclerView rv_report;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayoutManager mLinearLayoutManager1;
    private TaskListDetailActivityRecylerView mAdapter;
    private TaskListDetailReportRecylerView mReportAdapter;
    private List<TaskListDetailActivityData.XGJLDataBean> listData;
    private List<TaskListDetailActivityData.ZYJLDataBean> ZYlistData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_detail);
        initView();
        initData();
    }

    private void initView() {
        id = getIntent().getStringExtra("idNumber");
        biaoshi = getIntent().getStringExtra("biaoshi");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_task_list_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_task_list_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_task_list_detail_activity);
        mRecyclerView = (RecyclerView)findViewById(R.id.rv_task_list_fragment);
        rv_report = (RecyclerView)findViewById(R.id.rv_report_task_list_fragment);

        //基础信息
        tv_depart = (TextView) findViewById(R.id.tv_depart_task_list_detail);
        tv_fangliang = (TextView) findViewById(R.id.tv_jhfl_task_list_detail);
        tv_time = (TextView) findViewById(R.id.tv_time_task_list_detail);
        tv_renwuno = (TextView) findViewById(R.id.tv_renwuno_task_list_detail);
        tv_jzbw = (TextView) findViewById(R.id.tv_jzbw_task_list_detail);
        tv_sjqd = (TextView) findViewById(R.id.tv_sjqd_task_list_detail);
        tv_gcmc = (TextView) findViewById(R.id.tv_gcmc_task_list_detail);
        tv_jzfs = (TextView) findViewById(R.id.tv_jzfs_task_list_detail);

        //执行情况
        tv_jhfl = (TextView) findViewById(R.id.tv_fangliang_task_list_detail);
        tv_wcfl = (TextView) findViewById(R.id.tv_wancheng_task_list_detail);
        tv_pan_count = (TextView) findViewById(R.id.tv_pan_task_list_detail);
        tv_zxjd = (TextView) findViewById(R.id.tv_zxjd_task_list_detail);
        tv_jiechao = (TextView) findViewById(R.id.tv_jiechao_task_list_detail);
    }

    private void initData() {
        listData = new ArrayList<>();
        ZYlistData = new ArrayList<>();
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
        String taskListDetailData = null;
        taskListDetailData = URL.getRenwudanDetailData(id, biaoshi);
        Log.e(TAG,"url=:"+taskListDetailData);
        return taskListDetailData.replace("+", "%2B");
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
                data = mGson.fromJson(response, TaskListDetailActivityData.class);
                if (null != data) {
                    if (data.isSuccess()) {
                        mPageStateLayout.showContent();
                        listData.addAll(data.getXGJLData());
                        ZYlistData.addAll(data.getZYJLData());
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
        //基础信息
        TaskListDetailActivityData.JCXXDataBean JCXXDataBean = data.getJCXXData();
        tv_depart.setText(JCXXDataBean.getDepartName());//组织机构
        tv_fangliang.setText(JCXXDataBean.getJihuafangliang());//计划方量
        tv_time.setText(JCXXDataBean.getKaipanriqi());//开盘日期
        tv_renwuno.setText(JCXXDataBean.getRenwuno());//任务单编号
        tv_jzbw.setText(JCXXDataBean.getJzbw());//浇筑部位
        tv_sjqd.setText(JCXXDataBean.getShuinibiaohao());//设计强度
        tv_gcmc.setText(JCXXDataBean.getGcmc());//工程名称
        tv_jzfs.setText(JCXXDataBean.getJiaozhufangshi());//浇筑方式

        //执行情况
        TaskListDetailActivityData.ZXQKDataBean zxqkData = data.getZXQKData();
        tv_jhfl.setText(zxqkData.getJihuafangliang());
        tv_wcfl.setText(zxqkData.getShijifangliang());
        tv_pan_count.setText(zxqkData.getShijipanshu());
        tv_zxjd.setText(zxqkData.getBaifenbi());
        tv_jiechao.setText(zxqkData.getJiechao());

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        //设置动画与适配器
        mAdapter = new TaskListDetailActivityRecylerView(this, listData);
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter);
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);

        mLinearLayoutManager1 = new LinearLayoutManager(this);
        rv_report.setLayoutManager(mLinearLayoutManager1);
        rv_report.setNestedScrollingEnabled(false);
        //设置动画与适配器
        mReportAdapter = new TaskListDetailReportRecylerView(this, ZYlistData);
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter1 = new SlideInLeftAnimationAdapter(mReportAdapter);
        mSlideInLeftAnimationAdapter1.setFirstOnly(true);
        mSlideInLeftAnimationAdapter1.setDuration(500);
        mSlideInLeftAnimationAdapter1.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter1 = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter1);
        mScaleInAnimationAdapter1.setFirstOnly(true);
        rv_report.setAdapter(mScaleInAnimationAdapter1);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.engineering_department) + " > ");
            sb.append(getString(R.string.renwudan_zx) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}

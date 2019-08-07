package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.adapter.TaskListDetailActivityRecylerView;
import com.shtoone.aqxj.adapter.TaskListDetailReportRecylerView;
import com.shtoone.aqxj.bean.TaskListDetailActivityData;
import com.shtoone.aqxj.fragment.base.BaseLazyFragment;
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
 * Created by Administrator on 2017/9/12.
 */

public class TaskListDetailFragment extends BaseLazyFragment {

    private static final String TAG = TaskListDetailFragment.class.getSimpleName();
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

    public static TaskListDetailFragment newInstance(String idNumber, String biaoshi) {
        Bundle args = new Bundle();
        args.putString("idNumber", idNumber);
        args.putString("biaoshi", biaoshi);
        TaskListDetailFragment fragment = new TaskListDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        initData();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_list_detail, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mNestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_task_list_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptr_task_list_detail_activity);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.psl_task_list_detail_activity);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_task_list_fragment);
        rv_report = (RecyclerView) view.findViewById(R.id.rv_report_task_list_fragment);

        //基础信息
        tv_depart = (TextView) view.findViewById(R.id.tv_depart_task_list_detail);
        tv_fangliang = (TextView) view.findViewById(R.id.tv_jhfl_task_list_detail);
        tv_time = (TextView) view.findViewById(R.id.tv_time_task_list_detail);
        tv_renwuno = (TextView) view.findViewById(R.id.tv_renwuno_task_list_detail);
        tv_jzbw = (TextView) view.findViewById(R.id.tv_jzbw_task_list_detail);
        tv_sjqd = (TextView) view.findViewById(R.id.tv_sjqd_task_list_detail);
        tv_gcmc = (TextView) view.findViewById(R.id.tv_gcmc_task_list_detail);
        tv_jzfs = (TextView) view.findViewById(R.id.tv_jzfs_task_list_detail);

        //执行情况
        tv_jhfl = (TextView) view.findViewById(R.id.tv_fangliang_task_list_detail);
        tv_wcfl = (TextView) view.findViewById(R.id.tv_wancheng_task_list_detail);
        tv_pan_count = (TextView) view.findViewById(R.id.tv_pan_task_list_detail);
        tv_zxjd = (TextView) view.findViewById(R.id.tv_zxjd_task_list_detail);
        tv_jiechao = (TextView) view.findViewById(R.id.tv_jiechao_task_list_detail);

    }

    private void initData() {

        Bundle args = getArguments();
        if (args != null) {
            id = args.getString("idNumber");
            biaoshi = args.getString("biaoshi");
        }
        mGson = new Gson();
        listData = new ArrayList<>();
        ZYlistData = new ArrayList<>();
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
        String taskListDetailData = URL.getRenwudanDetailData(id, biaoshi);
        Log.e(TAG, "url=:" + taskListDetailData);
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
        if (!NetworkUtils.isConnected(getContext())) {
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

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        //设置动画与适配器
        mAdapter = new TaskListDetailActivityRecylerView(getContext(), listData);
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter);
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);

        mLinearLayoutManager1 = new LinearLayoutManager(getContext());
        rv_report.setLayoutManager(mLinearLayoutManager1);
        rv_report.setNestedScrollingEnabled(false);
        //设置动画与适配器
        mReportAdapter = new TaskListDetailReportRecylerView(getContext(), ZYlistData);
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter1 = new SlideInLeftAnimationAdapter(mReportAdapter);
        mSlideInLeftAnimationAdapter1.setFirstOnly(true);
        mSlideInLeftAnimationAdapter1.setDuration(500);
        mSlideInLeftAnimationAdapter1.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter1 = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter1);
        mScaleInAnimationAdapter1.setFirstOnly(true);
        rv_report.setAdapter(mScaleInAnimationAdapter1);
    }
}

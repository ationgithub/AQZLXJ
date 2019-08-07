package com.shtoone.aqxj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.google.gson.Gson;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.adapter.OnItemClickListener;
import com.shtoone.aqxj.bean.WorkingTeamData;
import com.shtoone.aqxj.ui.DividerItemDecoration;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by Administrator on 2017/8/22.
 */
public class WorkingTeamActivity extends BaseActivity{

    private static final String TAG = WorkingTeamActivity.class.getSimpleName();
    private Toolbar                           mToolbar;
    private PtrFrameLayout                    mPtrFrameLayout;
    private RecyclerView                      mRecyclerView;
    private PageStateLayout                   mPageStateLayout;
    private Gson                              mGson;
    private WorkingTeamData                data;
    private List<WorkingTeamData.DataEntity>    listData;
    private LinearLayoutManager               mLinearLayoutManager;
    private WorkingTeamActivityRecylerView mAdapter;
    private String departId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_strength);
        initView();
        initData();
    }

    public void initView(){
        mToolbar = (Toolbar)findViewById(R.id.toolbar_toolbar);
        mPtrFrameLayout = (PtrFrameLayout)findViewById(R.id.ptrframelayout);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mPageStateLayout = (PageStateLayout)findViewById(R.id.pagestatelayout);
    }

    public void initData(){
        listData = new ArrayList<>();
        mGson = new Gson();
        departId = getIntent().getStringExtra("departId");
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }

    @Override
    public String createRefreshULR() {

        return URL.getDataWORKTEAM(departId);
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
                data = mGson.fromJson(response, WorkingTeamData.class);
                if (null != data) {
                    if (data.getSuccess()) {
                        mPageStateLayout.showContent();
                        listData.addAll(data.getData());
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

    public void setAdapter(){

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        //设置动画与适配器
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new WorkingTeamActivityRecylerView(this, listData));
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("workteamid",listData.get(position).getId());
                intent.putExtra("workteam",listData.get(position).getName());
                setResult(66, intent);
                onBackPressed();
            }
        });
    }

    @Override
    public boolean isCanDoRefresh() {
        Log.e(TAG,"--------isCanDoRefresh----------");
        //判断是哪种状态的页面，都让其可下拉
        if (mPageStateLayout.isShowContent) {
            //判断RecyclerView是否在在顶部，在顶部则允许滑动下拉刷新
            if (null != mRecyclerView) {
                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager lm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    int position = lm.findFirstVisibleItemPosition();
                    if (position >= 0) {
                        if (lm.findViewByPosition(position).getTop() > 0 && position == 0) {
                            return true;
                        }
                    }
                }
            } else {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(getString(R.string.engineering_department)+ " > ");
            sb.append("施工队");
            mToolbar.setTitle(sb.toString());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // 添加返回过渡动画.
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}

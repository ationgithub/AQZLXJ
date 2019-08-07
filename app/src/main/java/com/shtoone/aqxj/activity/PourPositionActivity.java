package com.shtoone.aqxj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.google.gson.Gson;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.adapter.OnItemClickListener;
import com.shtoone.aqxj.adapter.PourPositionActivityRecylerView;
import com.shtoone.aqxj.bean.DepartmentData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.bean.PourPositionData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.URL;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

/**
 * Created by Administrator on 2017/8/22.
 */
public class PourPositionActivity extends BaseActivity{

    private static final String TAG = PourPositionActivity.class.getSimpleName();
    private boolean isRegistered = false;
    private Toolbar                         mToolbar;
    private FloatingActionButton    fab;
    private PtrFrameLayout                  mPtrFrameLayout;
    private RecyclerView                    mRecyclerView;
    private PageStateLayout                 mPageStateLayout;
    private Gson                            mGson;
    private PourPositionData                data;
    private boolean                         isLoading;
    private List<PourPositionData.DataBean> listData;
    private LinearLayoutManager             mLinearLayoutManager;
    private ScaleInAnimationAdapter         mScaleInAnimationAdapter;
    private PourPositionActivityRecylerView mAdapter;
    private ParametersData                  mParametersData;
    private int                             lastVisibleItemPosition;
    private DepartmentData                  mDepartmentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        setContentView(R.layout.activity_pour_position);
        initView();
        initData();
    }

    public void initView(){
        mToolbar = (Toolbar)findViewById(R.id.toolbar_toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        mPtrFrameLayout = (PtrFrameLayout)findViewById(R.id.ptrframelayout);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mPageStateLayout = (PageStateLayout)findViewById(R.id.pagestatelayout);
    }

    public void initData(){

        if (null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            mDepartmentData = new DepartmentData(BaseApplication.mUserInfoData.getDepartId(), BaseApplication.mUserInfoData.getDepartName(), ConstantsUtils.POURPOSITION);
            mParametersData = (ParametersData) BaseApplication.parametersData.clone();
            mParametersData.userGroupID = BaseApplication.mDepartmentData.departmentID;
        }
        mParametersData.fromTo = ConstantsUtils.POURPOSITION;
        mGson = new Gson();
        listData = new ArrayList<>();
        initToolbarBackNavigation(mToolbar);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        //设置动画与适配器
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new PourPositionActivityRecylerView(this, listData));
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("pourposition",listData.get(position).getProjectname());
                intent.putExtra("projectname",listData.get(position).getZjiedian());
                intent.putExtra("sjqd",listData.get(position).getShejiqiangdu());
                intent.putExtra("sjfl",listData.get(position).getShejifangliang());
                intent.putExtra("treeguid",listData.get(position).getTreeguid());
                setResult(22, intent);
                onBackPressed();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PourPositionActivity.this, DialogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ConstantsUtils.PARAMETERS, mParametersData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //还有一个不完美的地方就是当规定的item个数时，最后一个item在屏幕外滑到可见时，其底部没有footview，这点以后再解决。
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == mAdapter.getItemCount() && listData.size() >= 4) {
                    if (!isLoading) {
                        isLoading = true;
                        mRecyclerView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                KLog.e("第" + mParametersData.currentPage + "页");
                                loadMore();
                                KLog.e("上拉加载更多下一页=" + mParametersData.currentPage);
                                isLoading = false;
                            }
                        }, 500);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();

                if (dy > 5) {
                    fab.hide();
                } else if (dy < -5) {
                    fab.show();
                }
            }
        });


        setToolbarTitle();
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }

    @Override
    public String createRefreshULR() {
        mParametersData.currentPage = "1";//默认都是第一页
        String currentPage = "";
        currentPage = mParametersData.currentPage = "1";
        String keyword= mParametersData.keyword;
        try {
            if (null != listData) {
                listData.clear();
            }
            return URL.getPourPosData(getIntent().getStringExtra("departId"),currentPage, URLEncoder.encode(keyword,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public String createLoadMoreULR() {
        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) + 1) + "";//默认都是第一页
        String currentPage = "";
        String keyword= mParametersData.keyword;
        currentPage = mParametersData.currentPage;
        try {
            return URL.getPourPosData(getIntent().getStringExtra("departId"),currentPage, URLEncoder.encode(keyword,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
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
                data = mGson.fromJson(response, PourPositionData.class);
                if (null != data) {
                    if (data.isSuccess()) {
                        listData.addAll(data.getData());
                        mPageStateLayout.showContent();
                        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
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
    public void loadMoreSuccess(String response) {
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
                data = mGson.fromJson(response, PourPositionData.class);
                if (null != data) {
                    if (data.getData().size() > 0) {
                        if (null != listData) {
                            listData.addAll(data.getData());
                            if (listData.size() > 0) {
                                mPageStateLayout.showContent();
                                mAdapter.notifyDataSetChanged();
                            } else {
                                TastyToast.makeText(getApplicationContext(), "无更多数据!", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                                mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                                mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                            }
                        } else {
                            TastyToast.makeText(getApplicationContext(), "数据异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                            mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                            mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                        }
                    } else {
                        TastyToast.makeText(getApplicationContext(), "无更多数据!", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                    }
                } else {
                    TastyToast.makeText(getApplicationContext(), "解析异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                    mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                }
            } else {
                TastyToast.makeText(getApplicationContext(), "无更多数据!", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                mAdapter.notifyItemRemoved(mAdapter.getItemCount());
            }
        } else {
            //提示返回数据异常，展示错误页面
            TastyToast.makeText(getApplicationContext(), "数据异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
            mAdapter.notifyItemRemoved(mAdapter.getItemCount());
        }


    }

    public void setAdapter(){


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

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == ConstantsUtils.POURPOSITION) {

                this.mParametersData.keyword = mParametersData.keyword;
                KLog.e("mParametersData:" + mParametersData.keyword);
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(getString(R.string.engineering_department)+ " > ");
            sb.append(getString(R.string.pour_position)).trimToSize();
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

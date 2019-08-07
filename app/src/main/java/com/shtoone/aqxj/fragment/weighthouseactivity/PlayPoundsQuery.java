package com.shtoone.aqxj.fragment.weighthouseactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.PlayPoundsQueryDetailActivity;
import com.shtoone.aqxj.adapter.OnItemClickListener;
import com.shtoone.aqxj.adapter.PlayPoundsRecycleViewAdapter;
import com.shtoone.aqxj.adapter.factory.ScaleInAnimationAdapterFactory;
import com.shtoone.aqxj.bean.DepartmentData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.bean.PlayPoundsListData;
import com.shtoone.aqxj.event.EventData;
import com.shtoone.aqxj.fragment.base.BaseLazyFragment;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.URL;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

import static com.shtoone.aqxj.BaseApplication.mUserInfoData;

public class PlayPoundsQuery extends BaseLazyFragment {
    private ParametersData mParametersData;
    private DepartmentData mDepartmentData;
    private boolean isRegistered = false;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private RecyclerView mRecyclerView;
    private Gson mGson;
    private LinearLayoutManager mLinearLayoutManager;
    private ScaleInAnimationAdapter mScaleInAnimationAdapter;
    private SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter;
    private List<PlayPoundsListData.DataEntity> listDatas;
    private PlayPoundsRecycleViewAdapter mAdapter;
    private PlayPoundsListData enterPoundsListData;
    private int lastVisibleItemPosition;
    private boolean isLoading;

    public static PlayPoundsQuery newInstance(ParametersData mParametersData) {
        Bundle args = new Bundle();
        args.putSerializable(ConstantsUtils.PARAMETERS, mParametersData);
        PlayPoundsQuery fragment = new PlayPoundsQuery();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mParametersData = (ParametersData) args.getSerializable(ConstantsUtils.PARAMETERS);//得到参数bean
        }
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptrframelayout);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.pagestatelayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    private void initData() {
        if (null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            mDepartmentData = new DepartmentData(mUserInfoData.getDepartId(), mUserInfoData.getDepartName(), ConstantsUtils.WEIGHTHOUSEFRAGMENT);
        }

        mGson = new Gson();
        listDatas = new ArrayList<>();
        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //还有一个不完美的地方就是当规定的item个数时，最后一个item在屏幕外滑到可见时，其底部没有footview，这点以后再解决。
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == mAdapter.getItemCount() && listDatas.size() >= 4) {

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
                    BaseApplication.bus.post(new EventData(ConstantsUtils.YALIJIFABHIDE));
                } else if (dy < -5) {
                    BaseApplication.bus.post(new EventData(ConstantsUtils.YALIJIFABSHOW));
                }
            }
        });

        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }

    private void jumpToPlayPoundsDetailActivity(int position) {
        Intent intent = new Intent(_mActivity, PlayPoundsQueryDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("playdetail", listDatas.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mPageStateLayout.isShowContent) {
            //判断RecyclerView是否在在顶部，在顶部则允许滑动下拉刷新
            if (null != mRecyclerView) {
                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager lm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    int position = lm.findFirstVisibleItemPosition();
                    if (position >= 0) {
                        if (lm.findViewByPosition(position).getTop() > 0 && position == 0 && BaseApplication.isExpand) {
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

    @Override
    public String createRefreshULR() {
        mPageStateLayout.showLoading();
        mParametersData.currentPage = "1";//默认都是第一页
        String userGroupID = "";//组织机构id
        String startDateTime = "";
        String endDateTime = "";
        String currentPage = "";
        String equipmentID = "";//设备id
        String pici = "";
        String cheliangbianhao = "";
        String cailiaono = "";
        String states = "";
        if (null != mParametersData) {
            userGroupID = mParametersData.userGroupID;
            startDateTime = mParametersData.startDateTime;
            endDateTime = mParametersData.endDateTime;
            currentPage = mParametersData.currentPage;
            equipmentID = mParametersData.equipmentID;
            pici = mParametersData.pici;
            cheliangbianhao = mParametersData.cheliangbianhao;
            cailiaono = mParametersData.cailiaono;
            states = mParametersData.states;
            Log.e("mParametersData.states直", "createRefreshULR: " + mParametersData.states);
        }
        if (null != listDatas) {
            listDatas.clear();
        }
        return URL.getPlayPoundsListData(startDateTime, endDateTime, userGroupID, currentPage, 10 + "", pici, cheliangbianhao, equipmentID, cailiaono, states);
    }

    @Override
    public String createLoadMoreULR() {
        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) + 1) + "";//默认都是第一页
        String userGroupID = "";
        String startDateTime = "";
        String endDateTime = "";
        String currentPage = "";
        String equipmentID = "";
        String pici = "";
        String cheliangbianhao = "";
        String cailiaono = "";
        String states = "";
        if (null != mParametersData) {
            userGroupID = mParametersData.userGroupID;
            startDateTime = mParametersData.startDateTime;
            endDateTime = mParametersData.endDateTime;
            currentPage = mParametersData.currentPage;
            equipmentID = mParametersData.equipmentID;
            pici = mParametersData.pici;
            cheliangbianhao = mParametersData.cheliangbianhao;
            cailiaono = mParametersData.cailiaono;
            states = mParametersData.states;
        }

        return URL.getPlayPoundsListData(startDateTime, endDateTime, userGroupID, currentPage, 10 + "", pici, cheliangbianhao, equipmentID, cailiaono, states);


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
                enterPoundsListData = mGson.fromJson(response, PlayPoundsListData.class);
                if (null != enterPoundsListData) {
                    if (enterPoundsListData.getSuccess() && enterPoundsListData.getData().size() > 0) {
                        listDatas.addAll(enterPoundsListData.getData());
                        if (null != listDatas) {
                            if (listDatas.size() > 0) {
                                mPageStateLayout.showContent();
                                mScaleInAnimationAdapter = new ScaleInAnimationAdapterFactory().getAdapter(mAdapter = new PlayPoundsRecycleViewAdapter(_mActivity, listDatas));
                                if (mUserInfoData.getQuanxian().isWZGCB()) {
                                    mAdapter.setOnItemClickListener(new OnItemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int position) {
                                            // 实现局部界面刷新, 这个view就是被点击的item布局对象
                                            jumpToPlayPoundsDetailActivity(position);

                                        }
                                    });
                                }
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
    public void onLoadMoreSuccess(String response) {
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
                enterPoundsListData = mGson.fromJson(response, PlayPoundsListData.class);
                if (null != enterPoundsListData) {
                    if (enterPoundsListData.getSuccess() && enterPoundsListData.getData().size() > 0) {
                        if (null != listDatas) {
                            listDatas.addAll(enterPoundsListData.getData());
                            if (listDatas.size() > 0) {
                                mPageStateLayout.showContent();
                                mAdapter.notifyDataSetChanged();
                            } else {
                                TastyToast.makeText(_mActivity.getApplicationContext(), "无更多数据!", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                                mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                                mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                            }
                        } else {
                            TastyToast.makeText(_mActivity.getApplicationContext(), "数据异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                            mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                            mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                        }
                    } else {
                        TastyToast.makeText(_mActivity.getApplicationContext(), "无更多数据!", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                    }
                } else {
                    TastyToast.makeText(_mActivity.getApplicationContext(), "解析异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                    mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                }
            } else {
                TastyToast.makeText(_mActivity.getApplicationContext(), "无更多数据!", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
                mAdapter.notifyItemRemoved(mAdapter.getItemCount());
            }
        } else {
            //提示返回数据异常，展示错误页面
            TastyToast.makeText(_mActivity.getApplicationContext(), "数据异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
            mAdapter.notifyItemRemoved(mAdapter.getItemCount());
        }
    }

    @Override
    public void onLoadMoreFailed(VolleyError error) {
        super.onLoadMoreFailed(error);
        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
    }

    @Subscribe
    public void updateSearch(DepartmentData mDepartmentData) {
        if (null != mDepartmentData && null != mParametersData && null != this.mDepartmentData) {
            if (mDepartmentData.fromto == ConstantsUtils.WEIGHTHOUSEFRAGMENT) {
                this.mParametersData.userGroupID = mDepartmentData.departmentID;
                this.mDepartmentData.departmentID = mDepartmentData.departmentID;
                this.mDepartmentData.departmentName = mDepartmentData.departmentName;
                this.mParametersData.userGroupID = mDepartmentData.departmentID;
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == ConstantsUtils.WEIGHTHOUSEFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.cailiaono = mParametersData.cailiaono;
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    @Subscribe
    public void go2TopOrRefresh(EventData event) {
        if (event.position == 0) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Subscribe
    public void handleRefresh(EventData event) {
        if (event.position == ConstantsUtils.REFRESH) {
            mPtrFrameLayout.autoRefresh(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        BaseApplication.bus.post(new EventData(ConstantsUtils.YALIJIFABSHOW));
    }

    @Override
    public void onPause() {
        super.onPause();
        BaseApplication.bus.post(new EventData(ConstantsUtils.YALIJIFABSHOW));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }
}

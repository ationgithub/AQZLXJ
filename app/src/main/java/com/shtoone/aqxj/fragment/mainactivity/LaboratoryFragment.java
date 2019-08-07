package com.shtoone.aqxj.fragment.mainactivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.AllPowerTestActivity;
import com.shtoone.aqxj.activity.LaboratoryActivity;
import com.shtoone.aqxj.activity.MainActivity;
import com.shtoone.aqxj.activity.MatchNoticeActivity;
import com.shtoone.aqxj.activity.MatchNoticeVerifyActivity;
import com.shtoone.aqxj.activity.SJPeiHebiActivity;
import com.shtoone.aqxj.adapter.LaboratoryFragmentRecyclerViewAdapter;
import com.shtoone.aqxj.adapter.OnItemClickListener;
import com.shtoone.aqxj.bean.DepartmentData;
import com.shtoone.aqxj.bean.LaboratoryFragmentRecyclerViewItemData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.event.EventData;
import com.shtoone.aqxj.fragment.base.BaseLazyFragment;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;
import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

import static com.shtoone.aqxj.BaseApplication.mUserInfoData;


/**
 * Created by leguang on 2016/5/31 0031.
 */
public class LaboratoryFragment extends BaseLazyFragment implements View.OnClickListener {
    private static final String TAG = LaboratoryFragment.class.getSimpleName();
    private Toolbar mToolbar;
    private PtrFrameLayout mPtrFrameLayout;
    //    private RecyclerView mRecyclerView;
    private LaboratoryFragmentRecyclerViewAdapter mAdapter;
    private LaboratoryFragmentRecyclerViewItemData itemsData;
    private FloatingActionButton fab;
    private PageStateLayout mPageStateLayout;
    private ParametersData mParametersData;
    private Gson mGson;
    private DepartmentData mDepartmentData;
    private LinearLayout item1;
    private LinearLayout item2;
    private LinearLayout item3;
    private LinearLayout item4;
    private LinearLayout item5;
    private TextView tv;
    private boolean isRegistered;

    public static LaboratoryFragment newInstance() {
        return new LaboratoryFragment();
    }

    @Subscribe
    public void peibiRefresh(EventData event) {
        if (event.position == ConstantsUtils.PEICHANGERED) {
//            mPtrFrameLayout.autoRefresh(true);
            if(BaseApplication.peibiRed){
                Drawable drawable = this.getResources().getDrawable(R.drawable.layer_list_red_dot,null);
                drawable.setBounds(10,1,40,60);//40 60
                tv.setCompoundDrawables(null,null,drawable,null);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        View view = inflater.inflate(R.layout.fragment_laboratory, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //返回到看见此fragment时，fab显示

    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_toolbar);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptrframelayout);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.pagestatelayout);
        /****************************************************************/
        //item1 = (LinearLayout) view.findViewById(R.id.cl_laboratory_item1);
        item2 = (LinearLayout) view.findViewById(R.id.cl_laboratory_item2);
        item3 = (LinearLayout) view.findViewById(R.id.cl_laboratory_item3);
        item4 = (LinearLayout) view.findViewById(R.id.cl_laboratory_item4);
        item5 = (LinearLayout) view.findViewById(R.id.cl_laboratory_item5);
        tv = (TextView) view.findViewById(R.id.tv_peibitongzhidanshenhe);
        //item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);

        /****************************************************************/
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        if (null != BaseApplication.parametersData) {
            mParametersData = (ParametersData) BaseApplication.parametersData.clone();
            mParametersData.fromTo = ConstantsUtils.LABORATORYFRAGMENT;
        }
        if (null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            mDepartmentData = new DepartmentData(mUserInfoData.getDepartId(), mUserInfoData.getDepartName(), ConstantsUtils.LABORATORYFRAGMENT);
        }
        mGson = new Gson();
        setToolbarTitle();
        ((MainActivity) _mActivity).initToolBar(mToolbar);

//        mToolbar.inflateMenu(R.menu.menu_hierarchy);
//        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_hierarchy:
//                        Intent intent = new Intent(_mActivity, OrganizationActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable(ConstantsUtils.DEPARTMENT, mDepartmentData);
//                        intent.putExtras(bundle);
//                        intent.putExtra("type", "3");
//                        AnimationUtils.startActivity(_mActivity, intent, mToolbar.findViewById(R.id.action_hierarchy), R.color.base_color);
//                        break;
//                }
//                return true;
//            }
//        });
//        mPageStateLayout.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 56));
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);

        if(BaseApplication.peibiRed){
            Drawable drawable = this.getResources().getDrawable(R.drawable.layer_list_red_dot,null);
            drawable.setBounds(10,1,40,60);//40 60
            tv.setCompoundDrawables(null,null,drawable,null);
        }
//        BaseApplication.peibiRed = true;
//        BaseApplication.bus.post(new EventData(ConstantsUtils.PEICHANGERED));
    }

    @Override
    public boolean isCanDoRefresh() {
       /* //判断是哪种状态的页面，都让其可下拉
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
        }*/
        return true;
    }

    @Override
    public String createRefreshULR() {
        mPageStateLayout.showLoading();
        String userGroupID = "";
        String startDateTime = "";
        String endDateTime = "";
        if (null != mParametersData) {
            userGroupID = mParametersData.userGroupID;
            startDateTime = mParametersData.startDateTime;
            endDateTime = mParametersData.endDateTime;
        }
        String sysLingdaoUrl = URL.getSYSLingdaoData(userGroupID, startDateTime, endDateTime);
        Log.e("111111", "url=:" + sysLingdaoUrl);
        return URL.getSYSLingdaoData(userGroupID, startDateTime, endDateTime);
    }

    @Override
    public void onRefreshSuccess(String response) {
        Log.e(TAG, "response=:" + response.toString());
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
                itemsData = mGson.fromJson(response, LaboratoryFragmentRecyclerViewItemData.class);
                if (null != itemsData) {
                    if (itemsData.isSuccess() && itemsData.getData().size() > 0) {
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
        if (!NetworkUtils.isConnected(_mActivity)) {
            //提示网络异常,让用户点击设置网络
            mPageStateLayout.showNetError();
        } else {
            //服务器异常，展示错误页面，点击刷新
            mPageStateLayout.showError();
        }
    }


    /*@Subscribe
    public void updateDepartment(DepartmentData mDepartmentData) {
        if (null != mDepartmentData && null != mParametersData && null != this.mDepartmentData) {
            if (mDepartmentData.fromto == ConstantsUtils.LABORATORYFRAGMENT) {
                this.mParametersData.userGroupID = mDepartmentData.departmentID;
                this.mDepartmentData.departmentID = mDepartmentData.departmentID;
                this.mDepartmentData.departmentName = mDepartmentData.departmentName;
                setToolbarTitle();
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }*/

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.laboratory)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //防止屏幕旋转后重画时fab显示

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }

    private void setAdapter() {
        // 设置显示形式
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        //设置动画
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new LaboratoryFragmentRecyclerViewAdapter(_mActivity, itemsData));
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
//        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                // 实现局部界面刷新, 这个view就是被点击的item布局对象
                changeReadedState(view);
                // 跳转到详情页
                jumpToLaboratoryActivity(position);
            }
        });
    }

    private void changeReadedState(View view) {
        //此处可以做一些修改点击过的item的样式，方便用户看出哪些已经点击查看过
    }

    private void jumpToLaboratoryActivity(int position) {
        Intent intent = new Intent(_mActivity, LaboratoryActivity.class);
        //这里不需要做健壮性判断，因为能走到这一步，itemsData必然有数据
        BaseApplication.mDepartmentData.departmentID = itemsData.getData().get(position).get(0).getUserGroupId();
        BaseApplication.mDepartmentData.departmentName = itemsData.getData().get(position).get(0).getDepartName();
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
            switch (v.getId()){
//                case R.id.cl_laboratory_item1://压力
//                    intent = new Intent(getContext(), PressureTestActivity.class);
//                    startActivity(intent);
//                    break;
                 case R.id.cl_laboratory_item2://取样
                     intent = new Intent(getContext(), AllPowerTestActivity.class);
                     startActivity(intent);
                    break;
                 case R.id.cl_laboratory_item3://配比通知单
                     intent = new Intent(getContext(), MatchNoticeActivity.class);
                     startActivity(intent);
                    break;
                 case R.id.cl_laboratory_item4://设计配合比
                     intent = new Intent(getContext(), SJPeiHebiActivity.class);
                     startActivity(intent);
                    break;
                 case R.id.cl_laboratory_item5://统计分析
                     BaseApplication.peibiRed = false;
                     tv.setCompoundDrawables(null,null,null,null);
                     intent = new Intent(getContext(), MatchNoticeVerifyActivity.class);
                     startActivity(intent);
                    break;
            }
    }
}

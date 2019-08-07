package com.shtoone.aqxj.fragment.EngineeringDepartment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.DialogActivity;
import com.shtoone.aqxj.activity.EngineerDepartmentActivity;
import com.shtoone.aqxj.activity.JobOrderCompoundingActivity;
import com.shtoone.aqxj.activity.JobOrderInProductionActvity;
import com.shtoone.aqxj.activity.JobOrderProductionActvity;
import com.shtoone.aqxj.activity.JobOrderUnCompoundingActivity;
import com.shtoone.aqxj.activity.JobOrderUnSubmitActivity;
import com.shtoone.aqxj.activity.JobOrderUnVerifyActivity;
import com.shtoone.aqxj.activity.MainActivity;
import com.shtoone.aqxj.activity.MaterialConsumeActivity;
import com.shtoone.aqxj.activity.OrganizationActivity;
import com.shtoone.aqxj.activity.TaskListImpQueryActivity;
import com.shtoone.aqxj.activity.YCLChuChangWeightActivity;
import com.shtoone.aqxj.activity.YCLJinChangWeightActivity;
import com.shtoone.aqxj.adapter.GridViewAdapter1;
import com.shtoone.aqxj.adapter.GridViewAdapter2;
import com.shtoone.aqxj.adapter.WZProjectProgressQueryAdapter;
import com.shtoone.aqxj.bean.DepartmentData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.bean.TJFXData;
import com.shtoone.aqxj.bean.WZProjectProgressQueryData;
import com.shtoone.aqxj.event.EventData;
import com.shtoone.aqxj.fragment.base.BaseLazyFragment;
import com.shtoone.aqxj.fragment.engineeringactivity.TaskListNewEditActivity;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.AnimationUtils;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;
import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by Administrator on 2017/8/7.
 */

public class EngineeringDepartmentFragment extends BaseLazyFragment {
    private static final String TAG = "EngineeringDepartmentFragment";
    private Toolbar mToolbar;
    private PtrFrameLayout mPtrFrameLayout;
    private WZProjectProgressQueryAdapter mAdapter;
    private TJFXData itemsData;
    private PageStateLayout mPageStateLayout;
    private Gson mGson;
    private List<WZProjectProgressQueryData.DataEntity> listData;

    private ParametersData mParametersData;
    private LinearLayoutManager mLinearLayoutManager;
    private ScaleInAnimationAdapter mScaleInAnimationAdapter;
    private GridView gridView1;
    private String[] titles1 = {"新增", "未提交", "未配料",
            "已配料", "生产中", "已完工"};
//    private String[] titles2 = {"未审核","任务单查询",
//            "进耗分析", "进场台账", "出场台账", "进度查询"};
    private String[] titles2 = {"未审核","任务单查询",
            "进耗分析", "进场台账", "出场台账"};
//    ,"新消息"
    private boolean isRegistered;

    private String[] nums1 = new String[6];
    private String[] nums2 = new String[6];
    private GridView gridView2;
    private GridViewAdapter1 adapter1;
    private FloatingActionButton fab;
    private List mList1;
    private String noshenhe;
    private DepartmentData mDepartmentData;


    public static EngineeringDepartmentFragment newInstance() {
        return new EngineeringDepartmentFragment();
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        if (null != BaseApplication.parametersData) {
            mParametersData = (ParametersData) BaseApplication.parametersData.clone();
            mParametersData.fromTo = ConstantsUtils.ENGINEERINGHOME;
        }
        if (null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            mDepartmentData = new DepartmentData(BaseApplication.mUserInfoData.getDepartId(), BaseApplication.mUserInfoData.getDepartName(), ConstantsUtils.ENGINEERINGHOME);
        }
        BaseApplication.mDepartmentData.departmentID = BaseApplication.mUserInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentName = BaseApplication.mUserInfoData.getDepartName();
        mGson = new Gson();
        setToolbarTitle();
        ((MainActivity) _mActivity).initToolBar(mToolbar);
        mToolbar.inflateMenu(R.menu.menu_hierarchy);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
                        Intent intent = new Intent(getActivity(), OrganizationActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(ConstantsUtils.DEPARTMENT, mDepartmentData);
                        intent.putExtras(bundle);
                        intent.putExtra("type", "2");
                        AnimationUtils.startActivity(_mActivity, intent, mToolbar.findViewById(R.id.action_hierarchy), R.color.base_color, 500);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        listData = new ArrayList<>();
        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }

    @Override
    public boolean isCanDoRefresh() {
        return true;
    }

    @Override
    public String createRefreshULR() {
        mPageStateLayout.showLoading();
        mParametersData.currentPage = "1";//默认都是第一页
        String userGroupID = "";
        String startDateTime = "";
        String endDateTime = "";

        if (null != mParametersData) {
            userGroupID = mParametersData.userGroupID;
            startDateTime = mParametersData.startDateTime;
            //endDateTime = mParametersData.endDateTime;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Calendar rld = Calendar.getInstance();
            endDateTime = sdf.format(rld.getTime());

        }
        if (null != listData) {
            listData.clear();
        }
        return URL.getTJFXUrl(userGroupID,startDateTime,endDateTime);
    }

    @Override
    public String createLoadMoreULR() {
        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) + 1) + "";//默认都是第一页
        String userGroupID = "";
        String startDateTime = "";
        String endDateTime = "";
        if (null != mParametersData) {
            userGroupID = mParametersData.userGroupID;
            startDateTime = mParametersData.startDateTime;
            endDateTime = mParametersData.endDateTime;
        }
        return URL.getTJFXUrl(userGroupID,startDateTime,endDateTime);
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
                itemsData = mGson.fromJson(response, TJFXData.class);
                if (null != itemsData) {
                    if (itemsData.isSuccess() && itemsData.getData().size() > 0) {
                        if (null != listData) {
                            if (itemsData.getData().size() > 0) {
                                mPageStateLayout.showContent();
                                nums1[1] = itemsData.getData().get(0).getNotijiaoCount();
                                nums1[2] = itemsData.getData().get(0).getNsrCount();
                                nums1[3] = itemsData.getData().get(0).getIsrCount();
                                nums1[4] = itemsData.getData().get(0).getShengchaningCount();
                                nums1[5] = itemsData.getData().get(0).getIsshengchancount();
                                noshenhe = itemsData.getData().get(0).getNoshenhe();
                                //1. 准备数据源
                                if (mList1==null){
                                    mList1 = new ArrayList<Map<String, String>>();
                                }else {
                                    mList1.clear();
                                }
                                for (int i = 0; i < titles1.length; i++) {
                                    Map<String, String> map = new HashMap<String, String>();
                                    map.put("itemTitle", titles1[i]);
                                    if (nums1.length > i) {
                                        map.put("itemNum", nums1[i]);
                                    }
                                    mList1.add(map);
                                }
                                //      2.为数据源设置适配器
                                if (adapter1 == null) {
                                    adapter1 = new GridViewAdapter1(getContext(), mList1);
                                    gridView1.setAdapter(adapter1);


                                    List list2 = new ArrayList<Map<String, String>>();
                                    for (int i = 0; i < titles2.length; i++) {
                                        Map<String, String> map = new HashMap<String, String>();
                                        map.put("itemTitle", titles2[i]);
                                        list2.add(map);
                                    }
                                     adapter2 = new GridViewAdapter2(getContext(), list2,noshenhe);
                                    //      3.将适配过后点数据显示在GridView 上
                                    gridView2.setAdapter(adapter2);

                                } else {
                                    adapter1.notifyDataSetChanged();
                                }
                            } else {
                                //提示数据为空，展示空状态
//                                mPageStateLayout.showEmpty();
                            }
                        } else {
                            //提示数据解析异常，展示错误页面
                            mPageStateLayout.showError();
                        }
                    } else {
                        //提示数据为空，展示空状态
//                        mPageStateLayout.showEmpty();
                    }
                } else {
                    //提示数据解析异常，展示错误页面
                    mPageStateLayout.showError();
                }
            } else {
                //提示数据为空，展示空状态
//                mPageStateLayout.showEmpty();
            }
        } else {
            //提示返回数据异常，展示错误页面
            mPageStateLayout.showError();
        }

//        BaseApplication.bus.post(new EventData(ConstantsUtils.RENCHANGERED));
//        BaseApplication.renwuRed = true;
    }
    GridViewAdapter2 adapter2;
    @Subscribe
    public void refreshRed(EventData event) {
        if (event.position == ConstantsUtils.RENCHANGERED) {
//            mPtrFrameLayout.autoRefresh(true);
            //adapter会重新调用一次adapter的getView方法,来重新绘制列表
            adapter2.notifyDataSetChanged();
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
//            mPageStateLayout.showError();
        }
    }

    @Override
    public void onLoadMoreSuccess(String response) {
    }

    @Override
    public void onLoadMoreFailed(VolleyError error) {
        super.onLoadMoreFailed(error);
        mParametersData.currentPage = (Integer.parseInt(mParametersData.currentPage) - 1) + "";
        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
    }

    @Subscribe
    public void updateDepartment(DepartmentData mDepartmentData) {
        if (null != mDepartmentData && null != mParametersData ) {
            if (mDepartmentData.fromto == ConstantsUtils.ENGINEERINGHOME) {
                this.mParametersData.userGroupID = mDepartmentData.departmentID;
                this.mDepartmentData.departmentName = mDepartmentData.departmentName;
                setToolbarTitle();
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == ConstantsUtils.ENGINEERINGHOME) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                mPtrFrameLayout.autoRefresh(true);
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
        View view = inflater.inflate(R.layout.fragment_engineering_department, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //返回到看见此fragment时，fab显示
        //返回到看见此fragment时，fab显示
        fab.show();
        Log.e("onResume", "WZProjectProgress");
    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_toolbar);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptrframelayout);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.pagestatelayout);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_engineering_department);
        /************************************************/
        gridView1 = (GridView) view.findViewById(R.id.gv_wzprogress);
        gridView2 = (GridView) view.findViewById(R.id.gv_tjfx);


        // item点击事件处理
        initListener();
    }

    private void initListener() {
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                //"新增","未提交","未配料","已配料","生产中", "已完工"
                switch (position) {
                    case 0:
                        if (BaseApplication.mUserInfoData.getQuanxian().isWZGCB()) {
                            intent = new Intent(_mActivity, TaskListNewEditActivity.class);
                            intent.putExtra("username", mParametersData.username);
                            intent.putExtra("departmentID",mDepartmentData.departmentID);
                            startActivity(intent);
                        }
                        break;
                    case 1:
                        intent = new Intent(getActivity(), JobOrderUnSubmitActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), JobOrderUnCompoundingActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), JobOrderCompoundingActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getActivity(), JobOrderInProductionActvity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getActivity(), JobOrderProductionActvity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getActivity(), JobOrderUnVerifyActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(getActivity(), TaskListImpQueryActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), MaterialConsumeActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), YCLJinChangWeightActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getActivity(), YCLChuChangWeightActivity.class);
                        startActivity(intent);
                        break;
//                    case 5:
////                        intent = new Intent(getActivity(), WZProjectProgressQueryActivity.class);
//                        intent = new Intent(getActivity(), GetuiSdkDemoActivity.class);
//                        startActivity(intent);
//                        break;
                    default:
                        break;
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_mActivity, DialogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ConstantsUtils.PARAMETERS, mParametersData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();
        //防止屏幕旋转后重画时fab显示
        Log.e("onPause", "WZProjectProgress");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }


    private void changeReadedState(View view) {
        //此处可以做一些修改点击过的item的样式，方便用户看出哪些已经点击查看过
    }

    //进入EngineerActivity
    private void jump2EngineerDepartmentDetailActivity(int position) {
        Intent intent = new Intent(_mActivity, EngineerDepartmentActivity.class);
        startActivity(intent);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append("工程进度查询").trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }


}

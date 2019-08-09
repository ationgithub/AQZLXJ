package com.shtoone.aqxj.activity.base;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.adapter.FBProjectTreeListViewAdapter;
import com.shtoone.aqxj.bean.FBDataBean;
import com.shtoone.aqxj.bean.FENBUProjectData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.ui.treeview.Node;
import com.shtoone.aqxj.ui.treeview.TreeListViewAdapter;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2017/8/10.
 */

public class FBProjectListActivity extends BaseActivity {

    private static final String TAG = "FBProjectListActivity";
    private Toolbar mToolbar;
    private ListView treeListView;
    private LinearLayout ll_container;
    private PageStateLayout mPageStateLayout;
    private FENBUProjectData data;
    //    private List<FBProjectData> treeNodes;
    private List<FBDataBean> treeNodes;
    private String type;
    //    private FBProjectTreeListViewAdapter<FBProjectData> mAdapter;
    private FBProjectTreeListViewAdapter<FBDataBean> mAdapter;
    private PtrFrameLayout mPtrFrameLayout;
    private ParametersData mParametersData;


    private android.os.Handler handler = new android.os.Handler(new android.os.Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.e(TAG, "treeNodes.size:" + treeNodes.size());
            try {
//                Log.e(TAG, "treeNodes:" + treeNodes.toString());
                mAdapter = new FBProjectTreeListViewAdapter<>(treeListView, FBProjectListActivity.this, treeNodes, 1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            treeListView.setAdapter(mAdapter);
            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    Log.e(TAG,"posion:"+position);
                    mParametersData.projectno = node.getId();

//                    BaseApplication.bus.post(mParametersData);
                }
            });
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
        Log.e(TAG, "onCreate");
        Log.e(TAG, "onCreate>>>account:" + DataSupport.count(FBDataBean.class));
        initView();
        initData();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_organization_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_organization_activity);
        treeListView = (ListView) findViewById(R.id.lv_tree_organization_activity);
        ll_container = (LinearLayout) findViewById(R.id.ll_container_organization_activity);
    }

    private void initData() {
        Log.e(TAG, "initData>>>account:" + DataSupport.count(FBDataBean.class));

        mParametersData = (ParametersData) getIntent().getSerializableExtra(ConstantsUtils.PARAMETERS);

        mToolbar.setTitle("分部分项");
        initToolbarBackNavigation(mToolbar);
//        treeNodes = new ArrayList<FBProjectData>();
        treeNodes = new ArrayList<FBDataBean>();

        //        ll_container.post(new Runnable() {
        //            @Override
        //            public void run() {
        //                revealView();
        //            }
        //        });

        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
        /*****************/
        setViewData();
        /*****************/
    }

    @Override
    public String createRefreshULR() {
        return URL.FB_PROJECT;
    }

    @Override
    public boolean isCanDoRefresh() {
        return false;
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
                data = new Gson().fromJson(response, FENBUProjectData.class);
                if (null != data) {
                    if (data.getSuccess()) {
                        mPageStateLayout.showContent();
//                        setViewData();
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

    private void setViewData() {
        Log.e(TAG, "setViewData>>>account:" + DataSupport.count(FBDataBean.class));
       /* if (null == data || !(data.getData().size() > 0)) {
            return;
        }*/

        String projectNo = null;
        String projectName = null;
        String parentNo = null;

        treeNodes.clear();

      /*  for (FENBUProjectData.DataEntity mDataBean : data.getData()) {
            if (TextUtils.isEmpty(mDataBean.getProjectNo())) {
                mPageStateLayout.showError();
                return;
            } else {
                projectNo = mDataBean.getProjectNo();
            }

            parentNo = mDataBean.getParentNo();
            projectName = mDataBean.getProjectName();
            treeNodes.add(new FBProjectData(projectNo, parentNo, projectName));
        }*/
        /********************************************************************/
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<FBDataBean> all = DataSupport.findAll(FBDataBean.class);
                Log.e(TAG, "account:" + DataSupport.count(FBDataBean.class));
                for (FBDataBean fbProjectData : all) {
//                    Log.e(TAG, "fbProjectData====>>>>>" + fbProjectData);
                    FBDataBean fbDataBean = new FBDataBean();
                    fbDataBean.setParentNo(fbProjectData.getParentNo());
                    fbDataBean.setProjectNo(fbProjectData.getProjectNo());
                    fbDataBean.setProjectName(fbProjectData.getProjectName());
                    treeNodes.add(fbDataBean);
                }
                handler.sendMessage(new Message());
            }
        }).start();

        /********************************************************************/
    /*    try {
//            mAdapter = new FBProjectTreeListViewAdapter<>(treeListView, this, treeNodes, 1);
            Log.e(TAG, "treeNodes:" + treeNodes.toString());
            mAdapter = new FBProjectTreeListViewAdapter<>(treeListView, this, treeNodes, 1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
      /*  treeListView.setAdapter(mAdapter);
        mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                mParametersData.projectno = node.getId();
                BaseApplication.bus.post(mParametersData);
            }
        });*/
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // 添加返回过渡动画.
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }

}

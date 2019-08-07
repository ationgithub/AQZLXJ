package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.PeiliaoTongzhidanDetailActivityData;
import com.shtoone.aqxj.bean.PeiliaoTongzhidanFragmentListData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2017/8/10.
 */
public class PeiliaoTongzhidanDetailActivity extends BaseActivity {

    private static final String TAG = PeiliaoTongzhidanDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private PeiliaoTongzhidanFragmentListData.DataBean mDataBean;
    private Gson mGson;

    private TextView tv_renwuno;
    private TextView tv_time;
    private TextView tv_gcmc;
    private TextView tv_jzfs;
    private TextView tv_fangliang;
    private TextView tv_jzbw;
    private TextView tv_bianhao;
    private TextView tv_tongzhidanno;
    private TextView tv_depart;
    private TextView tv_sjqd;
    private TextView tv_taluodu;
    private TextView tv_kangshen_level;
    private TextView tv_kangzhedu;
    private TextView tv1_material;
    private TextView tv2_material;
    private TextView tv3_material;
    private TextView tv4_material;
    private TextView tv5_material;
    private TextView tv6_material;
    private TextView tv7_material;
    private TextView tv8_material;
    private TextView tv9_material;
    private TextView tv1_peibizhi;
    private TextView tv2_peibizhi;
    private TextView tv3_peibizhi;
    private TextView tv4_peibizhi;
    private TextView tv5_peibizhi;
    private TextView tv6_peibizhi;
    private TextView tv7_peibizhi;
    private TextView tv8_peibizhi;
    private TextView tv9_peibizhi;
    private TextView tv1_hsl;
    private TextView tv2_hsl;
    private TextView tv3_hsl;
    private TextView tv4_hsl;
    private TextView tv5_hsl;
    private TextView tv6_hsl;
    private TextView tv7_hsl;
    private TextView tv8_hsl;
    private TextView tv9_hsl;
    private TextView tv1_sgyl;
    private TextView tv2_sgyl;
    private TextView tv3_sgyl;
    private TextView tv4_sgyl;
    private TextView tv5_sgyl;
    private TextView tv6_sgyl;
    private TextView tv7_sgyl;
    private TextView tv8_sgyl;
    private TextView tv9_sgyl;
    private TextView tv1_chanliang;
    private TextView tv2_chanliang;
    private TextView tv3_chanliang;
    private TextView tv4_chanliang;
    private TextView tv5_chanliang;
    private TextView tv6_chanliang;
    private TextView tv7_chanliang;
    private TextView tv8_chanliang;
    private TextView tv_remark;
    private PeiliaoTongzhidanDetailActivityData data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peibi_tongzhian_detail);
        initView();
        initData();
    }

    private void initView() {
        mDataBean = (PeiliaoTongzhidanFragmentListData.DataBean) getIntent().getSerializableExtra("PeiliaoTongzhidanDetail");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_tongzhidan_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_tongzhidan_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_tongzhidan_detail_activity);
        //任务单信息
        tv_renwuno = (TextView) findViewById(R.id.tv_renwuno_tongzhidan_detail);
        tv_time = (TextView) findViewById(R.id.tv_time_tongzhidan_detail);
        tv_gcmc = (TextView) findViewById(R.id.tv_gcmc_tongzhidan_detail);
        tv_jzfs = (TextView) findViewById(R.id.tv_jzfs_tongzhidan_detail);
        tv_fangliang = (TextView) findViewById(R.id.tv_jhfl_tongzhidan_detail);
        tv_jzbw = (TextView) findViewById(R.id.tv_jzbw_tongzhidan_detail);

        //基础信息
        tv_bianhao = (TextView) findViewById(R.id.tv_bianhao_tongzhidan_detail);
        tv_tongzhidanno = (TextView) findViewById(R.id.tv_tongzhidanno_tongzhidan_detail);
        tv_depart = (TextView) findViewById(R.id.tv_depart_tongzhidan_detail);
        tv_sjqd = (TextView) findViewById(R.id.tv_sjqd_tongzhidan_detail);
        tv_taluodu = (TextView) findViewById(R.id.tv_taluodu_tongzhidan_detail);
        tv_kangshen_level = (TextView) findViewById(R.id.tv_kangshen_tongzhidan_detail);
        tv_kangzhedu = (TextView) findViewById(R.id.tv_kangzhedu_tongzhidan_detail);
        //原材设置
        tv1_material = (TextView) findViewById(R.id.tv1_material_tongzhidan_detail);
        tv2_material = (TextView) findViewById(R.id.tv2_material_tongzhidan_detail);
        tv3_material = (TextView) findViewById(R.id.tv3_material_tongzhidan_detail);
        tv4_material = (TextView) findViewById(R.id.tv4_material_tongzhidan_detail);
        tv5_material = (TextView) findViewById(R.id.tv5_material_tongzhidan_detail);
        tv6_material = (TextView) findViewById(R.id.tv6_material_tongzhidan_detail);
        tv7_material = (TextView) findViewById(R.id.tv7_material_tongzhidan_detail);
        tv8_material = (TextView) findViewById(R.id.tv8_material_tongzhidan_detail);
        tv9_material = (TextView) findViewById(R.id.tv9_material_tongzhidan_detail);
        tv1_peibizhi = (TextView) findViewById(R.id.tv1_peibi_tongzhidan_detail);
        tv2_peibizhi = (TextView) findViewById(R.id.tv2_peibi_tongzhidan_detail);
        tv3_peibizhi = (TextView) findViewById(R.id.tv3_peibi_tongzhidan_detail);
        tv4_peibizhi = (TextView) findViewById(R.id.tv4_peibi_tongzhidan_detail);
        tv5_peibizhi = (TextView) findViewById(R.id.tv5_peibi_tongzhidan_detail);
        tv6_peibizhi = (TextView) findViewById(R.id.tv6_peibi_tongzhidan_detail);
        tv7_peibizhi = (TextView) findViewById(R.id.tv7_peibi_tongzhidan_detail);
        tv8_peibizhi = (TextView) findViewById(R.id.tv8_peibi_tongzhidan_detail);
        tv9_peibizhi = (TextView) findViewById(R.id.tv9_peibi_tongzhidan_detail);

        tv1_hsl = (TextView) findViewById(R.id.tv1_hsl_tongzhidan_detail);
        tv2_hsl = (TextView) findViewById(R.id.tv2_hsl_tongzhidan_detail);
        tv3_hsl = (TextView) findViewById(R.id.tv3_hsl_tongzhidan_detail);
        tv4_hsl = (TextView) findViewById(R.id.tv4_hsl_tongzhidan_detail);
        tv5_hsl = (TextView) findViewById(R.id.tv5_hsl_tongzhidan_detail);
        tv6_hsl = (TextView) findViewById(R.id.tv6_hsl_tongzhidan_detail);
        tv7_hsl = (TextView) findViewById(R.id.tv7_hsl_tongzhidan_detail);
        tv8_hsl = (TextView) findViewById(R.id.tv8_hsl_tongzhidan_detail);
        tv9_hsl = (TextView) findViewById(R.id.tv9_hsl_tongzhidan_detail);

        tv1_sgyl = (TextView) findViewById(R.id.tv1_sgyl_tongzhidan_detail);
        tv2_sgyl = (TextView) findViewById(R.id.tv2_sgyl_tongzhidan_detail);
        tv3_sgyl = (TextView) findViewById(R.id.tv3_sgyl_tongzhidan_detail);
        tv4_sgyl = (TextView) findViewById(R.id.tv4_sgyl_tongzhidan_detail);
        tv5_sgyl = (TextView) findViewById(R.id.tv5_sgyl_tongzhidan_detail);
        tv6_sgyl = (TextView) findViewById(R.id.tv6_sgyl_tongzhidan_detail);
        tv7_sgyl = (TextView) findViewById(R.id.tv7_sgyl_tongzhidan_detail);
        tv8_sgyl = (TextView) findViewById(R.id.tv8_sgyl_tongzhidan_detail);
        tv9_sgyl = (TextView) findViewById(R.id.tv9_sgyl_tongzhidan_detail);
        //掺量信息
        tv1_chanliang = (TextView) findViewById(R.id.tv1_chanliang_tongzhidan_detail);//细石掺量
        tv2_chanliang = (TextView) findViewById(R.id.tv2_chanliang_tongzhidan_detail);
        tv3_chanliang = (TextView) findViewById(R.id.tv3_chanliang_tongzhidan_detail);
        tv4_chanliang = (TextView) findViewById(R.id.tv4_chanliang_tongzhidan_detail);
        tv5_chanliang = (TextView) findViewById(R.id.tv5_chanliang_tongzhidan_detail);
        tv6_chanliang = (TextView) findViewById(R.id.tv6_chanliang_tongzhidan_detail);
        tv7_chanliang = (TextView) findViewById(R.id.tv7_chanliang_tongzhidan_detail);
        tv8_chanliang = (TextView) findViewById(R.id.tv8_chanliang_tongzhidan_detail);
        tv_remark = (TextView) findViewById(R.id.tv9_chanliang_tongzhidan_detail);  //备注


    }

    private void initData() {
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
        String produceDetailData = URL.getPeibiTongzhidanDetailData(mDataBean.getSgphbNo());
        Log.e(TAG,"url=:"+produceDetailData);
        return URL.getPeibiTongzhidanDetailData(mDataBean.getSgphbNo());
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
                data = mGson.fromJson(response, PeiliaoTongzhidanDetailActivityData.class);
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
        PeiliaoTongzhidanDetailActivityData.DataBean dataBean = data.getData();
        //任务单信息
        tv_renwuno.setText(dataBean.getRenwuNo());//任务单编号
        tv_time.setText(dataBean.getKaipanriqi());//开盘日期
        tv_gcmc.setText(dataBean.getGcmc());//工程名称
        tv_jzfs.setText(dataBean.getJiaozhufangshi());//浇筑方式
        tv_fangliang.setText(dataBean.getJihuafangliang());//计划方量
        tv_jzbw.setText(dataBean.getJzbw());//浇筑部位

        //基础信息
        tv_depart.setText(dataBean.getDepartname());//组织机构
        tv_tongzhidanno.setText(dataBean.getSgphbno());//配比通知单
        tv_bianhao.setText(dataBean.getLlphbno());   //设计配合比编号
        tv_sjqd.setText(dataBean.getSjqd());//设计强度
        tv_taluodu.setText(dataBean.getTanluodu());//塌落度
        tv_kangshen_level.setText(dataBean.getKangshendengji());//抗渗等级
        tv_kangzhedu.setText(dataBean.getKangzhedu());//抗折度
        //材料名称
        tv1_material.setText(dataBean.getFenliao1mingzi());//
        tv2_material.setText(dataBean.getFenliao2mingzi());//
        tv3_material.setText(dataBean.getGuliao1mingzi());//
        tv4_material.setText(dataBean.getGuliao2mingzi());//
        tv5_material.setText(dataBean.getGuliao3mingzi());//
        tv6_material.setText(dataBean.getGuliao4mingzi());//
        tv7_material.setText(dataBean.getFenliao3mingzi());//
        tv8_material.setText(dataBean.getWaijiaji1mingzi());//
        tv9_material.setText(dataBean.getShuimingzi());//
        //配比值
        tv1_peibizhi.setText(dataBean.getFenliao1phb());//
        tv2_peibizhi.setText(dataBean.getFenliao2phb());//
        tv3_peibizhi.setText(dataBean.getGuliao1phb());//
        tv4_peibizhi.setText(dataBean.getGuliao2phb());//
        tv5_peibizhi.setText(dataBean.getGuliao3phb());//
        tv6_peibizhi.setText(dataBean.getGuliao4phb());//
        tv7_peibizhi.setText(dataBean.getFenliao3phb());//
        tv8_peibizhi.setText(dataBean.getWaijiaji1phb());//
        tv9_peibizhi.setText(dataBean.getShuiphb());//

        tv1_hsl.setText("/");
        tv2_hsl.setText("/");
        tv3_hsl.setText(dataBean.getGuliao1hsl());
        tv4_hsl.setText(dataBean.getGuliao2hsl());
        tv5_hsl.setText(dataBean.getGuliao3hsl());
        tv6_hsl.setText(dataBean.getGuliao4hsl());
        tv7_hsl.setText("/");
        tv8_hsl.setText(dataBean.getWaijiaji1hsl());
        tv9_hsl.setText("/");
        tv1_sgyl.setText(dataBean.getFenliao1tzl());
        tv2_sgyl.setText(dataBean.getFenliao2tzl());
        tv3_sgyl.setText(dataBean.getGuliao1tzl());
        tv4_sgyl.setText(dataBean.getGuliao2tzl());
        tv5_sgyl.setText(dataBean.getGuliao3tzl());
        tv6_sgyl.setText(dataBean.getGuliao4tzl());
        tv7_sgyl.setText(dataBean.getFenliao3tzl());
        tv8_sgyl.setText(dataBean.getWaijiaji1tzl());
        tv9_sgyl.setText(dataBean.getShuitzl());

        //掺量信息
        tv1_chanliang.setText(dataBean.getXishichanliang());//
        tv2_chanliang.setText(dataBean.getJg3chanliang());//
        tv3_chanliang.setText(dataBean.getJusuosuanchanliang());//
        tv4_chanliang.setText(dataBean.getHeshachanliang());//
        tv5_chanliang.setText(dataBean.getBiaoguanmidu());//
        tv6_chanliang.setText(dataBean.getShalv());//
        tv7_chanliang.setText(dataBean.getShuijiaobi());//
        tv8_chanliang.setText(dataBean.getFangliang());//
        tv_remark.setText(dataBean.getRemark());//

    }


    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.laboratory) + " > ");
            sb.append(getString(R.string.peibi_tongzhin_cx) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}

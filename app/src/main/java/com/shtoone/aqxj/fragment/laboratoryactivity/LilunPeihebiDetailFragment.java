package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.LilunPeihebiDetailActivityData;
import com.shtoone.aqxj.bean.PeiliaoTongzhidanFragmentListData;
import com.shtoone.aqxj.fragment.base.BaseLazyFragment;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2017/9/12.
 */

public class LilunPeihebiDetailFragment extends BaseLazyFragment {

    private static final String TAG = LilunPeihebiDetailFragment.class.getSimpleName();
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private PeiliaoTongzhidanFragmentListData.DataBean mDataBean;
    private TextView tv_bianhao;
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
    private TextView tv1_chanliang;
    private TextView tv2_chanliang;
    private TextView tv3_chanliang;
    private TextView tv4_chanliang;
    private TextView tv5_chanliang;
    private TextView tv6_chanliang;
    private TextView tv7_chanliang;
    private TextView tv8_chanliang;
    private TextView tv9_material_yinqiji_detail;
    private TextView tv9_peibi_yinqiji_detail;
    private TextView tv9_hsl_yinqiji_detail;
    private TextView tv9_sgyl_yinqiji_detail;
    private TextView tv9_material_pengzhang_detail;
    private TextView tv9_peibi_pengzhang_detail;
    private TextView tv9_hsl_pengzhang_detail;
    private TextView tv9_sgyl_pengzhang_detail;
    private TextView tv_remark;
    private Gson mGson;
    private LilunPeihebiDetailActivityData data;

    public static LilunPeihebiDetailFragment newInstance(PeiliaoTongzhidanFragmentListData.DataBean mDataBean) {
        Bundle args = new Bundle();
        args.putSerializable("LilunPeihebiDetail", mDataBean);
        LilunPeihebiDetailFragment fragment = new LilunPeihebiDetailFragment();
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

        View view = inflater.inflate(R.layout.fragment_ilun_peihebi_detail, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mNestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_lilun_peihebi_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptr_lilun_peihebi_detail_activity);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.psl_lilun_peihebi_detail_activity);
        tv_bianhao = (TextView) view.findViewById(R.id.tv_bianhao_lilun_detail);
        tv_depart = (TextView) view.findViewById(R.id.tv_depart_lilun_detail);
        tv_sjqd = (TextView) view.findViewById(R.id.tv_sjqd_lilun_detail);
        tv_taluodu = (TextView) view.findViewById(R.id.tv_taluodu_lilun_detail);
        tv_kangshen_level = (TextView) view.findViewById(R.id.tv_kangshen_lilun_detail);
        tv_kangzhedu = (TextView) view.findViewById(R.id.tv_kangzhedu_lilun_detail);
        tv1_material = (TextView) view.findViewById(R.id.tv1_material_lilun_detail);
        tv2_material = (TextView) view.findViewById(R.id.tv2_material_lilun_detail);
        tv3_material = (TextView) view.findViewById(R.id.tv3_material_lilun_detail);
        tv4_material = (TextView) view.findViewById(R.id.tv4_material_lilun_detail);
        tv5_material = (TextView) view.findViewById(R.id.tv5_material_lilun_detail);
        tv6_material = (TextView) view.findViewById(R.id.tv6_material_lilun_detail);
        tv7_material = (TextView) view.findViewById(R.id.tv7_material_lilun_detail);
        tv8_material = (TextView) view.findViewById(R.id.tv8_material_lilun_detail);
        tv9_material = (TextView) view.findViewById(R.id.tv9_material_lilun_detail);
        tv1_peibizhi = (TextView) view.findViewById(R.id.tv1_peibi_lilun_detail);
        tv2_peibizhi = (TextView) view.findViewById(R.id.tv2_peibi_lilun_detail);
        tv3_peibizhi = (TextView) view.findViewById(R.id.tv3_peibi_lilun_detail);
        tv4_peibizhi = (TextView) view.findViewById(R.id.tv4_peibi_lilun_detail);
        tv5_peibizhi = (TextView) view.findViewById(R.id.tv5_peibi_lilun_detail);
        tv6_peibizhi = (TextView) view.findViewById(R.id.tv6_peibi_lilun_detail);
        tv7_peibizhi = (TextView) view.findViewById(R.id.tv7_peibi_lilun_detail);
        tv8_peibizhi = (TextView) view.findViewById(R.id.tv8_peibi_lilun_detail);
        tv9_peibizhi = (TextView) view.findViewById(R.id.tv9_peibi_lilun_detail);
        tv1_chanliang = (TextView) view.findViewById(R.id.tv1_chanliang_lilun_detail);//细石掺量
        tv2_chanliang = (TextView) view.findViewById(R.id.tv2_chanliang_lilun_detail);
        tv3_chanliang = (TextView) view.findViewById(R.id.tv3_chanliang_lilun_detail);
        tv4_chanliang = (TextView) view.findViewById(R.id.tv4_chanliang_lilun_detail);
        tv5_chanliang = (TextView) view.findViewById(R.id.tv5_chanliang_lilun_detail);
        tv6_chanliang = (TextView) view.findViewById(R.id.tv6_chanliang_lilun_detail);
        tv7_chanliang = (TextView) view.findViewById(R.id.tv7_chanliang_lilun_detail);
        tv8_chanliang = (TextView) view.findViewById(R.id.tv8_chanliang_lilun_detail);
        tv_remark = (TextView) view.findViewById(R.id.tv9_chanliang_lilun_detail);  //备注

        tv9_material_yinqiji_detail = (TextView) view.findViewById(R.id.tv9_material_yinqiji_detail);
        tv9_peibi_yinqiji_detail = (TextView) view.findViewById(R.id.tv9_peibi_yinqiji_detail);


        tv9_material_pengzhang_detail = (TextView) view.findViewById(R.id.tv9_material_pengzhang_detail);
        tv9_peibi_pengzhang_detail = (TextView) view.findViewById(R.id.tv9_peibi_pengzhang_detail);

        tv_remark = (TextView) view.findViewById(R.id.tv9_chanliang_lilun_detail);  //备注


    }

    private void initData() {
        Bundle args = getArguments();
        if (args != null) {
            mDataBean = (PeiliaoTongzhidanFragmentListData.DataBean) args.getSerializable("LilunPeihebiDetail");
        }
        mGson = new Gson();
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
        String produceDetailData = URL.getLilunPeihebiDetailData(mDataBean.getLlphbNo());
        Log.e(TAG, "url=:" + produceDetailData);
        return URL.getLilunPeihebiDetailData(mDataBean.getLlphbNo());
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
                data = mGson.fromJson(response, LilunPeihebiDetailActivityData.class);
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
        // 设置显示数据
        LilunPeihebiDetailActivityData.DataEntity dataBean = data.getData();
        //基础信息
        tv_bianhao.setText(dataBean.getLlphbno());   //设计配合比编号
        tv_depart.setText(dataBean.getDepartname());//组织机构
        tv_sjqd.setText(dataBean.getSjqd());//设计强度
        tv_taluodu.setText(dataBean.getTanluodu());//塌落度
        tv_kangshen_level.setText(dataBean.getKangshendengji());//抗渗等级
        tv_kangzhedu.setText(dataBean.getKangzhedu());//抗折度
        //材料名称
        tv1_material.setText(dataBean.getFenliao1mingzi()+"("+dataBean.getFenliao1guigexinghao()+")");//
        tv2_material.setText(dataBean.getFenliao2mingzi()+"("+dataBean.getFenliao2guigexinghao()+")");//
        tv3_material.setText(dataBean.getGuliao1mingzi()+"("+dataBean.getGuliao1guigexinghao()+")");//
        tv4_material.setText(dataBean.getGuliao2mingzi()+"("+dataBean.getGuliao2guigexinghao()+")");//
        tv5_material.setText(dataBean.getGuliao3mingzi()+"("+dataBean.getGuliao3guigexinghao()+")");//
        tv6_material.setText(dataBean.getGuliao4mingzi()+"("+dataBean.getGuliao4guigexinghao()+")");//
        tv7_material.setText(dataBean.getFenliao3mingzi()+"("+dataBean.getFenliao3guigexinghao()+")");//
        tv8_material.setText(dataBean.getWaijiaji1mingzi()+"("+dataBean.getWaijiaji1guigexinghao()+")");//
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

        tv9_material_yinqiji_detail.setText(dataBean.getWaijiaji2mingzi()+"("+dataBean.getWaijiaji2guigexinghao()+")");
        tv9_peibi_yinqiji_detail.setText(dataBean.getWaijiaji2phb());


        tv9_material_pengzhang_detail.setText(dataBean.getWaijiaji3mingzi()+"("+dataBean.getWaijiaji3guigexinghao()+")");
        tv9_peibi_pengzhang_detail.setText(dataBean.getWaijiaji3phb());


    }

}

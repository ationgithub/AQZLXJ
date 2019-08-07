package com.shtoone.aqxj.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bm.library.Info;
import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.PlayPoundsDetailData;

import com.shtoone.aqxj.bean.PlayPoundsListData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrFrameLayout;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

public class PlayPoundsQueryDetailActivity extends BaseActivity {
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private PlayPoundsDetailData playPoundsDetailData;
    private TextView tvProvider, tvWaag, tvWeighman, tvEnterTime, tvPlayTime, tvSilo, tvPici, tvOrderNo, tvPlate, tvRemark;//基本信息
    private TextView tvMaterial, tvRoughWeight, tvPiZhong, tvKouZhong, tvKouLv, tvNetWeight,tvDeviation;//材料明细
    private ImageView ivJCGKPicname,ivJCCPPicname,ivJCHCPPicname,ivJCBFPicname;//进场情况
    private PhotoView img2;
    private ImageView ivCCGKPicname,ivCCCPPicname,ivCCHCPPicname,ivCCBFPicname;//出场情况
    private TextView tvName;
    private Gson mGson;
    private PlayPoundsListData.DataEntity mDataBean;
    private int identificationId;
    Info mRectF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpounds_detail);
        initView();
        initDate();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_produce_query_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_produce_query_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_produce_query_detail_activity);
        tvName = (TextView)findViewById(R.id.tvName);
        tvName.setText("过磅类别：");

        //基本信息
        tvProvider = (TextView) findViewById(R.id.tvProvider);//供应商
        tvWaag = (TextView) findViewById(R.id.tvWaag);//地磅名称
        tvWeighman = (TextView) findViewById(R.id.tvWeighman);//司磅员
        tvEnterTime = (TextView) findViewById(R.id.tvEnterTime);//进场时间
        tvPlayTime = (TextView) findViewById(R.id.tvPlayTime);//出场时间
        tvSilo = (TextView) findViewById(R.id.tvSilo);//料仓
        tvPici = (TextView) findViewById(R.id.tvPici);//批次
        tvOrderNo = (TextView) findViewById(R.id.tvOrderNo);//过磅类别
        tvPlate = (TextView) findViewById(R.id.tvPlate);//车牌号
        tvRemark = (TextView) findViewById(R.id.tvRemark);//备注

        //材料明细
        tvMaterial = (TextView) findViewById(R.id.tvMaterial);//材料名称
        tvRoughWeight = (TextView) findViewById(R.id.tvRoughWeight);//毛重
        tvPiZhong = (TextView) findViewById(R.id.tvPiZhong);//皮重
        tvKouZhong = (TextView) findViewById(R.id.tvKouZhong);//扣重
        tvKouLv = (TextView) findViewById(R.id.tvKouLv);//扣率
        tvNetWeight = (TextView) findViewById(R.id.tvNetWeight);//净重
        tvDeviation = (TextView) findViewById(R.id.tvDeviation);//称重偏差

        //进场情况
        ivJCGKPicname = (ImageView)findViewById(R.id.ivJCGKPicname);
        img2 = (PhotoView) findViewById(R.id.img2);
        ivJCCPPicname = (ImageView)findViewById(R.id.ivJCCPPicname);
        ivJCHCPPicname = (ImageView)findViewById(R.id.ivJCHCPPicname);
        ivJCBFPicname = (ImageView)findViewById(R.id.ivJCBFPicname);
        //出场情况
        ivCCGKPicname = (ImageView)findViewById(R.id.ivCCGKPicname);
        ivCCCPPicname = (ImageView)findViewById(R.id.ivCCCPPicname);
        ivCCHCPPicname = (ImageView)findViewById(R.id.ivCCHCPPicname);
        ivCCBFPicname = (ImageView)findViewById(R.id.ivCCBFPicname);
    }

    private void initDate() {
        mGson = new Gson();
        mDataBean = (PlayPoundsListData.DataEntity) getIntent().getSerializableExtra("playdetail");
        identificationId = Integer.parseInt(mDataBean.getId());
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
        return URL.getPlayPoundsDetail(String.valueOf(identificationId));
    }

    private void setViewData(){
        //基本信息
        final PlayPoundsDetailData.DataBean data = playPoundsDetailData.getData();
        tvProvider.setText(data.getGongyingshangname());
        tvWaag.setText(data.getBanhezhanminchen());//地磅名称
        tvWeighman.setText(data.getSibangyuan());//司磅员
        tvEnterTime.setText(data.getJinchangshijian());//进场时间
        tvPlayTime.setText(data.getChuchangshijian());//出场时间
        tvSilo.setText(data.getLiaocang());//料仓
        tvPici.setText(data.getPici());//批次
        if (data.getGuobangleibie().trim().equals("1")){
            tvOrderNo.setText("调拨");//过磅类别
        }else {
            tvOrderNo.setText("废料");
        }
        tvPlate.setText(data.getQianchepai());//车牌号
        tvRemark.setText(data.getRemark());//备注

        //材料明细
        tvMaterial.setText(data.getCailiaoname());//材料名称
        tvRoughWeight.setText(data.getMaozhong());//毛重
        tvPiZhong.setText(data.getPizhong());//皮重
        tvKouZhong.setText(data.getKouzhong());//扣重
        tvKouLv.setText(data.getKoulv());//扣率
        tvNetWeight.setText(data.getJingzhong());//净重
        tvDeviation.setText(data.getChengzhongpiancha());//称重偏差


        //进场情况
        if (!TextUtils.isEmpty(data.getJCGKPic().trim()) ){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCGKPic()).crossFade().into(ivJCGKPicname);
            //设置不可以双指缩放移动放大等操作，跟普通的image一模一样,默认情况下就是disenable()状态

            ivJCGKPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivJCGKPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCGKPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivJCGKPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });


        }
        if (!TextUtils.isEmpty(data.getJCCPPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCCPPic()).crossFade().into(ivJCCPPicname);
            ivJCCPPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivJCCPPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCCPPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivJCCPPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });


        }
        if (!TextUtils.isEmpty(data.getJCHCPPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCHCPPic()).crossFade().into(ivJCHCPPicname);
            ivJCHCPPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivJCHCPPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCHCPPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivJCHCPPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });

        }
        if (!TextUtils.isEmpty(data.getJCBFPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCBFPic()).crossFade().into(ivJCBFPicname);
            ivJCBFPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivJCBFPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getJCBFPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivJCBFPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });

        }

        //出场情况
        if (!TextUtils.isEmpty(data.getCCGKPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCGKPic()).crossFade().into(ivCCGKPicname);
            ivCCGKPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivCCGKPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCGKPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivCCGKPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });

        }
        if (!TextUtils.isEmpty(data.getCCCPPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCCPPic()).crossFade().into(ivCCCPPicname);
            ivCCCPPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivCCCPPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCCPPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivCCCPPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });

        }
        if (!TextUtils.isEmpty(data.getCCHCPPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCHCPPic()).crossFade().into(ivCCHCPPicname);
            ivCCHCPPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivCCHCPPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCHCPPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivCCHCPPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });

        }
        if (!TextUtils.isEmpty(data.getCCBFPic().trim())){
            Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCBFPic()).crossFade().into(ivCCBFPicname);
            ivCCBFPicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.VISIBLE);

                    //获取img1的信息
                    //                   mRectF = ivJCGKPicname.getInfo();
                    mRectF = PhotoView.getImageViewInfo(ivCCBFPicname);
                    //让img2从img1的位置变换到他本身的位置
                    Glide.with(getApplicationContext()).load(URL.BaseURL + data.getCCBFPic()).crossFade().into(img2);
                    img2.animaFrom(mRectF);
                }
            });

            // 需要启动缩放需要手动开启
            img2.enable();
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 让img2从自身位置变换到原来img1图片的位置大小
                    img2.animaTo(mRectF, new Runnable() {
                        @Override
                        public void run() {
                            img2.setVisibility(View.GONE);
                            ivCCBFPicname.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });

        }
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
                playPoundsDetailData = mGson.fromJson(response, PlayPoundsDetailData.class);
                if (null != playPoundsDetailData) {
                    if (playPoundsDetailData.isSuccess()) {
                        mPageStateLayout.showContent();
                        setViewData();
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

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.enter_pounds) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}

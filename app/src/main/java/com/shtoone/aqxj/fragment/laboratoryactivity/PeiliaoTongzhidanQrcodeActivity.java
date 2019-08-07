package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by Administrator on 2017/9/13.
 */

public class PeiliaoTongzhidanQrcodeActivity extends BaseActivity {

    private Toolbar   mToolbar;
    private String    peibi;
    private ImageView mEnglishIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);
        initView();
        initData();
    }

    private void initData() {
         peibi = getIntent().getStringExtra("peibi");
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        createQRCode();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar_tablayout);
        mEnglishIv = (ImageView) findViewById(R.id.iv_english);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append("配比通知单二维码");
            mToolbar.setTitle(sb.toString());
        }
    }

    private void createQRCode() {

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

    }

    class MyAsyncTask extends AsyncTask<Void, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(Void... params) {
            return QRCodeEncoder.syncEncodeQRCode(peibi, BGAQRCodeUtil.dp2px(getApplication(), 150), Color.parseColor("#ff0000"));

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                mEnglishIv.setImageBitmap(bitmap);
            } else {
                Toast.makeText(getApplication(), "生成二维码失败", Toast.LENGTH_SHORT).show();
            }
        }
    }


}

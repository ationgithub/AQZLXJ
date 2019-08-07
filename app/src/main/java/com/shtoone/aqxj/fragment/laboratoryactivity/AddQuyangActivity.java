package com.shtoone.aqxj.fragment.laboratoryactivity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import com.lling.photopicker.Application;
import com.lling.photopicker.PhotoPickerActivity;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.QuyangFragmentListData;
import com.shtoone.aqxj.bean.YangpinDemoData;
import com.shtoone.aqxj.common.HttpHelper;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.PicUtils;
import com.socks.library.KLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by Administrator on 2017/9/13.
 */

public class AddQuyangActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    String TAG = "AddQuyangActivity";
    private Toolbar   mToolbar;
    private String    peibi;
    private ImageView mEnglishIv;
    private ImageView iv_chepai,iv_chepai2,iv_chepai3,iv_chepai4;
    private TextView tv_depart_cailiaomingchen,tv_depart_jingchangshijian,tv_depart_picihao;
    private Button button,cancel;
    private String  chepainame;
    private Uri     chepaiUri;
    private List<File> sImgPath;
    private  int whichPic= 0;
    private  QuyangFragmentListData.DataBean data;
    MaterialDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestCodeQRCodePermissions();
         data = (QuyangFragmentListData.DataBean)getIntent().getSerializableExtra("yangbenData");
        setContentView(R.layout.activity_quyang_yangben);
        initView();
        initData();
    }

    private void initData() {
        Application.context = BaseApplication.context;
        sImgPath = new ArrayList<>();
//         peibi = getIntent().getStringExtra("peibi");
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        tv_depart_cailiaomingchen.setText(data.getCailiaoName());
        tv_depart_jingchangshijian.setText(data.getJinchangshijian());
        tv_depart_picihao.setText(data.getPici());

        iv_chepai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichPic = 51;
                if (ContextCompat.checkSelfPermission(AddQuyangActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AddQuyangActivity.this,new String[]{Manifest.permission.CAMERA},2);
                }else {
                        int selectedMode= PhotoPickerActivity.MODE_SINGLE;
                        boolean showCamera = true;
//                    int maxNum = PhotoPickerActivity.MODE_SINGLE;
                        Intent intent = new Intent(AddQuyangActivity.this, PhotoPickerActivity.class);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, showCamera);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, selectedMode);
//                    intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, maxNum);
                        startActivityForResult(intent, 55);
//                    }else {
//                        toMedeiaStore();
//                    }
                }
            }
        });
        iv_chepai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichPic = 52;
                if (ContextCompat.checkSelfPermission(AddQuyangActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AddQuyangActivity.this,new String[]{Manifest.permission.CAMERA},2);
                }else {
//                    if(data.getCailiaoName().equals("水泥")||data.getCailiaoName().equals("粉煤灰")){
                        int selectedMode= PhotoPickerActivity.MODE_SINGLE;
                        boolean showCamera = true;
//                    int maxNum = PhotoPickerActivity.MODE_SINGLE;
                        Intent intent = new Intent(AddQuyangActivity.this, PhotoPickerActivity.class);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, showCamera);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, selectedMode);
//                    intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, maxNum);
                        startActivityForResult(intent, 55);
//                    }else {
//                        toMedeiaStore();
//                    }
                }
            }
        });
        iv_chepai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichPic = 53;
                if (ContextCompat.checkSelfPermission(AddQuyangActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AddQuyangActivity.this,new String[]{Manifest.permission.CAMERA},2);
                }else {
//                    if(data.getCailiaoName().equals("水泥")||data.getCailiaoName().equals("粉煤灰")){
                        int selectedMode= PhotoPickerActivity.MODE_SINGLE;
                        boolean showCamera = true;
//                    int maxNum = PhotoPickerActivity.MODE_SINGLE;
                        Intent intent = new Intent(AddQuyangActivity.this, PhotoPickerActivity.class);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, showCamera);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, selectedMode);
//                    intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, maxNum);
                        startActivityForResult(intent, 55);
//                    }else {
//                        toMedeiaStore();
//                    }
                }
            }
        });
        iv_chepai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichPic = 54;
                if (ContextCompat.checkSelfPermission(AddQuyangActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AddQuyangActivity.this,new String[]{Manifest.permission.CAMERA},2);
                }else {
//                    if(data.getCailiaoName().equals("水泥")||data.getCailiaoName().equals("粉煤灰")){
                        int selectedMode= PhotoPickerActivity.MODE_SINGLE;
                        boolean showCamera = true;
//                    int maxNum = PhotoPickerActivity.MODE_SINGLE;
                        Intent intent = new Intent(AddQuyangActivity.this, PhotoPickerActivity.class);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, showCamera);
                        intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, selectedMode);
//                    intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, maxNum);
                        startActivityForResult(intent, 55);
//                    }else {
//                        toMedeiaStore();
//                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YangpinDemoData ydd = new YangpinDemoData();
                ydd.setTaizhangid(data.getId());
                ydd.setJinchangshijian(data.getJinchangshijian());
                ydd.setQuyangshijian(String.valueOf(new DateFormat().format("yyyy-MM-dd_hh:mm:ss", Calendar.getInstance(Locale.CHINA))));
                List<MultipartBody.Part> parts = new ArrayList<>();
                for (int i = 0; i < sImgPath.size(); i++) {
                    File file = sImgPath.get(i);
                    //这里采用的Compressor图片压缩
                    File file1 = new Compressor.Builder(AddQuyangActivity.this)
                            .setMaxWidth(720)
                            .setMaxHeight(1080)
                            .setQuality(80)
                            .setCompressFormat(Bitmap.CompressFormat.JPEG)
                            .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_PICTURES).getAbsolutePath())
                            .build()
                            .compressToFile(file);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                    MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
                    parts.add(part);
                }
                progressDialog = new MaterialDialog.Builder(AddQuyangActivity.this)
                        .title("上传")
                        .content("上传中，请稍等……")
                        .progress(true, 0)
                        .progressIndeterminateStyle(true)
                        .cancelable(false)
                        .show();
                HttpHelper.getInstance().initService().feedBack(ydd,parts).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        progressDialog.dismiss();
                        Log.e(TAG,"sucess");
                        finish();
                        //okhttp3.ResponseBody$1@91fba00
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        showText("服务器异常");
                        Log.e(TAG,t.toString());
                    }
                });
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        tv_depart_cailiaomingchen =  (TextView) findViewById(R.id.tv_depart_cailiaomingchen);
        tv_depart_jingchangshijian =  (TextView) findViewById(R.id.tv_depart_jingchangshijian);
        tv_depart_picihao =  (TextView) findViewById(R.id.tv_depart_picihao);

        iv_chepai = (ImageView) findViewById(R.id.iv_chepai);
        iv_chepai2 = (ImageView) findViewById(R.id.iv_fachedan);
        iv_chepai3 = (ImageView) findViewById(R.id.iv_fachedan3);
        iv_chepai4 = (ImageView) findViewById(R.id.iv_fachedan4);
        button = (Button) findViewById(R.id.btn_sign);
        cancel = (Button) findViewById(R.id.btn_notsign);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != mDepartmentData && !TextUtils.isEmpty(mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(mDepartmentData.departmentName + " > ");
            sb.append("新增取样单");
            mToolbar.setTitle(sb.toString());
        }
    }

    private void  getPicName(){
        switch (whichPic){
            case 51:
                chepainame = "qypic"+new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                break;
            case 52:
                chepainame = "gzpic"+new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                break;
            case 53:
                chepainame = "jlpic"+new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                break;
            case 54:
                chepainame = "pzpic"+new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                break;
        }
    }

    private void toMedeiaStore(){
        getPicName();
        Log.e("createfileName:" ,chepainame);
        //创建图片文件的uri
        File file = new File(getExternalCacheDir(), chepainame);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            Log.e("创建fileName:" ,chepainame);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            chepaiUri = FileProvider.getUriForFile(AddQuyangActivity.this, getPackageName() + ".fileprovider", file);
        } else {
            chepaiUri = Uri.fromFile(file);
        }
        Log.e("file:",file.getAbsolutePath());
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, chepaiUri);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivityForResult(intent, whichPic);
        sImgPath.add( new File(getExternalCacheDir(), chepainame));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == ConstantsUtils.SHUINI) { // 调用模块类
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            ArrayList<String> result = data.getStringArrayListExtra(PhotoPickerActivity.KEY_RESULT);
            switch (whichPic){
                case 51:
                    Bitmap bitmap = BitmapFactory.decodeFile(result.get(0));
                    String randomString = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                    String newPath = getExternalCacheDir()+ "/qypic"+randomString;
                    PicUtils.convertToJpg(result.get(0),newPath);
//                    sImgPath.add(new File(newPath));
                    sImgPath.add(new File(getExternalCacheDir(), "qypic"+randomString));
                    iv_chepai.setImageBitmap(bitmap);
                    iv_chepai.setClickable(false);
                    break;
                case 52:
                    Bitmap bitmap2 = BitmapFactory.decodeFile(result.get(0));
                    String randomString2 = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                    String newPath2 = getExternalCacheDir()+ "/gzpic"+randomString2;
                    PicUtils.convertToJpg(result.get(0),newPath2);
                    sImgPath.add(new File(newPath2));
                    iv_chepai2.setImageBitmap(bitmap2);
                    iv_chepai2.setClickable(false);
                    break;
                case 53:
                    Bitmap bitmap3 = BitmapFactory.decodeFile(result.get(0));
                    String randomString3 = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                    String newPath3 = getExternalCacheDir()+ "/jlpic"+randomString3;
                    PicUtils.convertToJpg(result.get(0),newPath3);
                    sImgPath.add(new File(newPath3));
                    iv_chepai3.setImageBitmap(bitmap3);
                    iv_chepai3.setClickable(false);
                    break;
                case 54:
                    Bitmap bitmap4 = BitmapFactory.decodeFile(result.get(0));
                    String randomString4 = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                    String newPath4 = getExternalCacheDir()+ "/pzpic"+randomString4;
                    PicUtils.convertToJpg(result.get(0),newPath4);
                    sImgPath.add(new File(newPath4));
                    iv_chepai4.setImageBitmap(bitmap4);
                    iv_chepai4.setClickable(false);
                    break;
            }
        }
        if (requestCode == ConstantsUtils.PIC1) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(chepaiUri));
                iv_chepai.setImageBitmap(bitmap);
                iv_chepai.setClickable(false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == ConstantsUtils.PIC2) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(chepaiUri));
                iv_chepai2.setImageBitmap(bitmap);
                iv_chepai2.setClickable(false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == ConstantsUtils.PIC3) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(chepaiUri));
                iv_chepai3.setImageBitmap(bitmap);
                iv_chepai3.setClickable(false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == ConstantsUtils.PIC4) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(chepaiUri));
                iv_chepai4.setImageBitmap(bitmap);
                iv_chepai4.setClickable(false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
//                if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
//                    takefachedan();
//                }else {
//                    Toast.makeText(this,"您拒绝权限",Toast.LENGTH_SHORT).show();
//                }
                break;

            case 2:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    toMedeiaStore();
                }else {
                    Toast.makeText(this,"您拒绝权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }
    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;
}

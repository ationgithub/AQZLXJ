package com.shtoone.aqxj.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.igexin.sdk.PushManager;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.UserInfoData;
import com.shtoone.aqxj.getui.DemoPushService;
import com.shtoone.aqxj.getui.GetuiIntentService;
import com.shtoone.aqxj.utils.AESCryptUtils;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.HttpUtils;
import com.shtoone.aqxj.utils.SharedPreferencesUtils;
import com.shtoone.aqxj.utils.URL;
import com.socks.library.KLog;


import java.security.GeneralSecurityException;

public class SplashActivity extends BaseActivity {
    //从这个界面选择是直接进入还是还是进入登录
    private static final String TAG = SplashActivity.class.getSimpleName();
    private UserInfoData userInfoData;
    private boolean isBackPressed;

    // DemoPushService.class 自定义服务名称, 核心服务
    private Class userPushService = DemoPushService.class;
    private static final int REQUEST_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        XGPushConfig.enableDebug(this, true);
//        Context context = getApplicationContext();
//        XGPushManager.registerPush(context);
        // 2.36（不包括）之前的版本需要调用以下2行代码
//        Intent service = new Intent(context, XGPushService.class);
//        context.startService(service);
        PackageManager pkgManager = getPackageManager();
        // 读写 sd card 权限非常重要, android6.0默认禁止的, 建议初始化之前就弹窗让用户赋予该权限
        boolean sdCardWritePermission = pkgManager.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, getPackageName()) == PackageManager.PERMISSION_GRANTED;
        // read phone state用于获取 imei 设备信息
        boolean phoneSatePermission = pkgManager.checkPermission(Manifest.permission.READ_PHONE_STATE, getPackageName()) == PackageManager.PERMISSION_GRANTED;
        if (Build.VERSION.SDK_INT >= 23 && !sdCardWritePermission || !phoneSatePermission) {
            requestPermission();
        } else {
            PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
        }
        // 注册 intentService 后 PushDemoReceiver 无效, sdk 会使用 DemoIntentService 传递数据,
        // AndroidManifest 对应保留一个即可(如果注册 DemoIntentService, 可以去掉 PushDemoReceiver, 如果注册了
        // IntentService, 必须在 AndroidManifest 中声明)
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), GetuiIntentService.class);
        // 应用未启动, 个推 service已经被唤醒,显示该时间段内离线消息
//        if (BaseApplication.payloadData != null) {
//            tLogView.append(BaseApplication.payloadData);
//        }
        String cid = PushManager.getInstance().getClientid(this);
        BaseApplication.gloCid = cid;

        //延迟执行，尽量看到闪屏页
        new Handler().postDelayed(new Runnable() {
            public void run() {
                initView();
                initData();
            }
        }, 2500);
    }

    private void initView() {
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE},
                REQUEST_PERMISSION);
    }
    private void initData() {
        String usernameEncrypted = (String) SharedPreferencesUtils.get(this, ConstantsUtils.USERNAME, "");
        String passwordEncrypted = (String) SharedPreferencesUtils.get(this, ConstantsUtils.PASSWORD, "");
//        String loginCheck = (String) SharedPreferencesUtils.get(this, ConstantsUtils.LOGINCHECK, "");
        KLog.e("username加密从sp中:" + usernameEncrypted);
        KLog.e("password加密从sp中:" + passwordEncrypted);
        //进行解密
        String username = null;
        String password = null;
        if (!(TextUtils.isEmpty(usernameEncrypted) && TextUtils.isEmpty(passwordEncrypted))) {
            try {
                username = AESCryptUtils.decrypt("leguang", usernameEncrypted);
                password = AESCryptUtils.decrypt("leguang", passwordEncrypted);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }

        KLog.e("username解密:" + username);
        KLog.e("password解密:" + password);

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            //联网校对密码正确后保存，第一次登录肯定是要进入login
            HttpUtils.getRequest(URL.loginCheck(username, password), new HttpUtils.HttpListener() {
                @Override
                public void onSuccess(String response) {
                    KLog.json(response);
                    if (!TextUtils.isEmpty(response)) {
                        userInfoData = new Gson().fromJson(response, UserInfoData.class);
                        if (null != userInfoData) {
                            if (userInfoData.isSuccess()) {
                                BaseApplication.mUserInfoData = userInfoData;
                                initParametersData();
                                //在跳转之前判断是否按了返回键返回桌面了，这代表用户不想进应用了
                                jumpToMain();

                            } else {
                                //提示用户名或密码错误,有可能用户在Web端改了密码
                                jumpToLogin();

                            }
                        } else {
                            //提示数据解析异常，与硬件和系统有关的问题，几乎不可能出现
                            jumpToLogin();
                        }
                    } else {
                        //提示返回数据异常，丢包的情况，几乎不会出现
                        jumpToLogin();
                    }
                }

                @Override
                public void onFailed(VolleyError error) {
                    //提示网络数据异常，无网络
                    jumpToLogin();
                }
            });

        } else {
            jumpToLogin();
        }


    }

    //进入LoginActivity
    private void jumpToLogin() {
        if (isBackPressed) {
            return;
        }
        Boolean isFirstentry = (Boolean) SharedPreferencesUtils.get(this, ConstantsUtils.ISFIRSTENTRY, true);
        Intent intent;
        if (isFirstentry) {
            intent = new Intent(this, GuideActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }

    //进入MainActivity
    private void jumpToMain() {
        if (isBackPressed) {
            return;
        }
        Intent intent = null;
        if ("GL".equals(userInfoData.getType())) {
            intent = new Intent(this, MainActivity.class);

        } else if ("SG".equals(userInfoData.getType())) {

            switch (userInfoData.getUserRole()) {
                case "1":
                    intent = new Intent(this, ConcreteMainActivity.class);
                    break;
                case "3":
                    intent = new Intent(this, LaboratoryMainActivity.class);
                    break;
                default:
                    intent = new Intent(this, MainActivity.class);
                    break;

            }
        }
        startActivity(intent);
        finish();
    }

    private void initParametersData() {
        BaseApplication.parametersData.userGroupID = userInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentID = userInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentName = userInfoData.getDepartName();
        BaseApplication.parametersData.username = userInfoData.getUserFullName();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isBackPressed = true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);// 必须要调用这句，信鸽推送中的要求
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}

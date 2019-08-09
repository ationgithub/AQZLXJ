package com.shtoone.aqxj;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.pgyersdk.PgyerActivityManager;
import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.crash.PgyerCrashObservable;
import com.pgyersdk.crash.PgyerObserver;
import com.shtoone.aqxj.bean.DepartmentData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.bean.UserInfoData;
import com.shtoone.aqxj.getui.GetuiSdkDemoActivity;
import com.socks.library.KLog;

import org.litepal.LitePalApplication;

/**
 * Created by leguang on 2016/5/20 0031.
 */
public class BaseApplication extends LitePalApplication {
    private static final String TAG = BaseApplication.class.getSimpleName();
    public static BaseApplication application;
    public static Context context;
//    public static final Bus bus = new Bus();
    public static ParametersData parametersData = new ParametersData();
    public static RequestQueue mRequestQueue;
    public static UserInfoData mUserInfoData;
    public static DepartmentData mDepartmentData = new DepartmentData();
    public static boolean isExpand;
    //    public RefWatcher mRefWatcher;

//    private static DemoHandler handler;
//    public static GetuiSdkDemoActivity demoActivity;
    /**
     * 应用未启动, 个推 service已经被唤醒,保存在该时间段内离线消息(此时 GetuiSdkDemoActivity.tLogView == null)
     */
//    public static StringBuilder payloadData = new StringBuilder();
    public static String gloCid;
    public static boolean peibiRed = false;
    public static boolean renwuRed = false;


    @Override
    public void onCreate() {
        super.onCreate();
        //日志的开关和全局标签初始化
        KLog.init(false, "SHTW混凝土");
        //        初始化蒲公英
        PgyCrashManager.register(); //推荐使用
        PgyerCrashObservable.get().attach(new PgyerObserver() {
            @Override
            public void receivedCrash(Thread thread, Throwable throwable) {
                // 禁止做耗时操作
                // 添加自定义操作，例如重启
            }
        });
        PgyerActivityManager.set(this);

        application = this;
        context = getApplicationContext();
        // 程序异常交由AppExceptionHandler来处理
//        Thread.setDefaultUncaughtExceptionHandler(AppExceptionHandler.getInstance(this));
        //创建Volley的请求队列
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        //创建LeakCanary对象，观察内存泄漏
//        mRefWatcher = LeakCanary.install(this);
        InitializeService.start(this);

//        if (handler == null) {
//            handler = new DemoHandler();
//        }
    }

//    public static void sendMessage(Message msg) {
//        handler.sendMessage(msg);
//    }
//    public static class DemoHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//                    if (demoActivity != null) {
//                        payloadData.append((String) msg.obj);
//                        payloadData.append("\n");
//                        if (GetuiSdkDemoActivity.tLogView != null) {
//                            GetuiSdkDemoActivity.tLogView.append(msg.obj + "\n");
//                        }
//                    }
//                    break;
//
//                case 1:
//                    //区分发的消息是cid
//                    if (demoActivity != null) {
//                        if (GetuiSdkDemoActivity.tLogView != null) {
//                            GetuiSdkDemoActivity.tView.setText((String) msg.obj);
//                        }
//                    }
//                    break;
//            }
//        }
//    }

}

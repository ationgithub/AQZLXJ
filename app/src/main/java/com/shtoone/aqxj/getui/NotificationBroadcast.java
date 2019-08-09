package com.shtoone.aqxj.getui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.shtoone.aqxj.activity.JobOrderUnVerifyActivity;
import com.shtoone.aqxj.activity.MainActivity;
import com.shtoone.aqxj.activity.MatchNoticeVerifyActivity;

import java.lang.reflect.Method;

public class NotificationBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();//动作
        String actionStr = intent.getStringExtra("data");
        collapseStatusBar(context);//收起通知栏
        if (action.equals("action.view")) {
            if(actionStr.equals("任务单")){
                Intent dialogIntent = new Intent(context, JobOrderUnVerifyActivity.class);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(dialogIntent);
            }else if(actionStr.equals("配比通知单")){
                Intent dialogIntent = new Intent(context, MatchNoticeVerifyActivity.class);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(dialogIntent);
            }
//            Intent i = new Intent(context, MainActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//必须添加，避免重复打开
//            i.putExtra("flag", "home");//传值
//            context.startActivity(i);
        }
    }

    public void collapseStatusBar(Context context){
            try {
                Object statusBarManager = context.getSystemService( "statusbar");
                Method collapse;
                if (Build.VERSION.SDK_INT <= 16) {
                    collapse = statusBarManager.getClass().getMethod("collapse");
                } else {
                    collapse = statusBarManager.getClass().getMethod("collapsePanels");
                }
                collapse.invoke(statusBarManager);
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
    }

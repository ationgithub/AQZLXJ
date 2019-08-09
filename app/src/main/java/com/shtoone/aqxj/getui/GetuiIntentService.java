package com.shtoone.aqxj.getui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import com.google.gson.Gson;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.MessageData;
import com.shtoone.aqxj.event.EventData;
import com.shtoone.aqxj.utils.ConstantsUtils;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class GetuiIntentService extends GTIntentService {

    private static final String TAG = "GetuiSdkDemo";

    private static final String MASTERSECRET = "K7LVen6H5Y5pSvqHSm83T5";
    private String appkey = "gxAXs8Yq0V7Y02bJdcn5S3";
    private String appsecret = "8pC0316Ckp5STym52kDfz7";
    private String appid = "34G10agJv785HbiiPPDii9";
    /**
     * 为了观察透传数据变化.
     */
    private static int cnt;
    private Gson mGson = new Gson();
    public GetuiIntentService() {}
    private Context ctx;

    @Override
    public void onReceiveServicePid(Context context, int pid) {
        Log.d(TAG, "onReceiveServicePid -> " + pid);
        ctx = context;
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();

        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        Log.d(TAG, "call sendFeedbackMessage = " + (result ? "success" : "failed"));

        Log.d(TAG, "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null");
        } else {
            String data = new String(payload);
            Log.d(TAG, "receiver payload = " + data);
            MessageData md  =  mGson.fromJson(data,MessageData.class);
            if(md.getType().equals("0")){
                    BaseApplication.renwuRed = true;
                showNotification("任务单");
//                BaseApplication.bus.post(new EventData(ConstantsUtils.RENCHANGERED));
            }else if(md.getType().equals("1")){
                    BaseApplication.peibiRed = true;
                showNotification("配比通知单");
//                BaseApplication.bus.post(new EventData(ConstantsUtils.PEICHANGERED));
            }
            // 测试消息为了观察数据变化
//            if (data.equals(getResources().getString(R.string.push_transmission_data))) {
//                data = data + "-" + cnt;
//                cnt++;
//            }
//            sendMessage(data, 0);
        }
        Log.d(TAG, "----------------------------------------------------------------------------------------------");
    }

    public static int idNO = 100;
    private void showNotification(String data){
//        int icon = R.drawable.shtoone; //通知图标
//        CharSequence tickerText = data; //状态栏(Status Bar)显示的通知文本提示
//        long when = System.currentTimeMillis(); //通知产生的时间，会在通知信息里显示
//        Notification notification = new Notification();
//        notification.flags = Notification.FLAG_AUTO_CANCEL;
//        notification.icon = icon;
//        notification.tickerText = tickerText;
//        notification.when = when;
//        Intent appIntent = new Intent(Intent.ACTION_MAIN);
//        //appIntent.setAction(Intent.ACTION_MAIN);
//        appIntent.addCategory(Intent.CATEGORY_LAUNCHER);
////        appIntent.setComponent(new ComponentName(this.getPackageName(), this.getPackageName() + "." + this.getLocalClassName()));
//        appIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//关键的一步，设置启动模式
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, appIntent, 0);
////        notification.setLatestEventInfo(this, "标题", "内容"), pendingIntent);
//        notificationManager.notify(1, notification);

//        RemoteViews views = new RemoteViews(getPackageName(), R.layout.layout_nitification);//自定义的布局视图
////按钮点击事件：
//        PendingIntent homeIntent = PendingIntent.getBroadcast(this, 1, new Intent("action"), PendingIntent.FLAG_UPDATE_CURRENT);
//        views.setOnClickPendingIntent(R.id.btn, homeIntent);//点击的id，点击事件
//创建通知：
        Intent ii = new Intent("action.view");
        ii.putExtra("data",data);
        ii.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//关键的一步，设置启动模式
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
        Bitmap bitmap2= BitmapFactory.decodeResource(getResources(), R.drawable.shtoone);
        mBuilder
//                .setContent(views)//设置布局
//                .setOngoing(true)//设置是否常驻,true为常驻
                .setSmallIcon(R.drawable.shtoone)//设置小图标
                .setLargeIcon(bitmap2)
                .setAutoCancel(true)
                .setTicker(data)//设置提示
                .setContentText(data+"审核")
                .setPriority(Notification.PRIORITY_MAX)//设置优先级
                .setWhen(System.currentTimeMillis())//设置展示时间
                .setContentIntent(PendingIntent.getBroadcast(this, 2, ii, PendingIntent.FLAG_UPDATE_CURRENT));//设置视图点击事件  FLAG_UPDATE_CURRENT

        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(++idNO, mBuilder.build());//显示通知： 当前notificationid，当前notification
    }

//    private void showNotification(String data) {
//        if(BaseApplication.gloCid==null){
//            Toast.makeText(this, getResources().getString(R.string.show_cid) + "为空", Toast.LENGTH_LONG).show();
//        }
//        if (isNetworkConnected()) {
//            // 客户端服务端用的同一套接口，需要联网
//            // !!!!!!注意：以下为个推服务端API1.0接口，仅供测试。不推荐在现网系统使用1.0版服务端接口，请参考最新的个推服务端API接口文档，使用最新的2.0版接口
//            Map<String, Object> param = new HashMap<String, Object>();
//            param.put("action", "pushSpecifyMessage"); // pushSpecifyMessage为接口名，注意大小写
//            /*---以下代码用于设定接口相应参数---*/
//            param.put("appkey", appkey);
//            param.put("type", 2); // 推送类型： 2为消息
//            param.put("pushTitle", getResources().getString(R.string.push_notification_title)); // pushTitle请填写您的应用名称
//            // 推送消息类型，有TransmissionMsg、LinkMsg、NotifyMsg三种，此处以LinkMsg举例
////            param.put("pushType", "LinkMsg");
//            param.put("pushType", "NotifyMsg");
//            param.put("offline", true); // 是否进入离线消息
//            param.put("offlineTime", 72); // 消息离线保留时间
//            param.put("priority", 1); // 推送任务优先级
//            List<String> cidList = new ArrayList<String>();
//            cidList.add(BaseApplication.gloCid); // 您获取的ClientID
//            param.put("tokenMD5List", cidList);
//            param.put("sign", GetuiSdkHttpPost.makeSign(MASTERSECRET, param));// 生成Sign值，用于鉴权，需要MasterSecret，请务必填写
//            // LinkMsg消息实体
//            Map<String, Object> linkMsg = new HashMap<String, Object>();
//            linkMsg.put("linkMsgIcon", "push.png"); // 消息在通知栏的图标
////            linkMsg.put("linkMsgTitle", getResources().getString(R.string.push_notification_msg_title)); // 推送消息的标题
//            linkMsg.put("linkMsgTitle", data); // 推送消息的标题
////            linkMsg.put("linkMsgContent", getResources().getString(R.string.push_notification_msg_content)); // 推送消息的内容
//            linkMsg.put("linkMsgContent", "您收到1条"+data+"审核消息"); // 推送消息的内容
//            linkMsg.put("linkMsgUrl", "http://www.igetui.com/"); // 点击通知跳转的目标网页
//            param.put("msg", linkMsg);
//            GetuiSdkHttpPost.httpPost(param);
//        } else {
//            Toast.makeText(this, R.string.network_invalid, Toast.LENGTH_SHORT).show();
//        }
//    }
    /**
     * 判断网络是否连接.
     */
    private boolean isNetworkConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (NetworkInfo ni : info) {
                    if (ni.getState() == NetworkInfo.State.CONNECTED) {
                        Log.d(TAG, "type = " + (ni.getType() == 0 ? "mobile" : ((ni.getType() == 1) ? "wifi" : "none")));
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);

//        sendMessage(clientid, 1);
        BaseApplication.gloCid = clientid;
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
        Log.d(TAG, "onReceiveOnlineState -> " + (online ? "online" : "offline"));
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
        Log.d(TAG, "onReceiveCommandResult -> " + cmdMessage);

        int action = cmdMessage.getAction();

        if (action == PushConsts.SET_TAG_RESULT) {
            setTagResult((SetTagCmdMessage) cmdMessage);
        } else if(action == PushConsts.BIND_ALIAS_RESULT) {
            bindAliasResult((BindAliasCmdMessage) cmdMessage);
        } else if (action == PushConsts.UNBIND_ALIAS_RESULT) {
            unbindAliasResult((UnBindAliasCmdMessage) cmdMessage);
        } else if ((action == PushConsts.THIRDPART_FEEDBACK)) {
            feedbackResult((FeedbackCmdMessage) cmdMessage);
        }
    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage message) {
        Log.d(TAG, "onNotificationMessageArrived -> " + "appid = " + message.getAppid() + "\ntaskid = " + message.getTaskId() + "\nmessageid = "
                        + message.getMessageId() + "\npkg = " + message.getPkgName() + "\ncid = " + message.getClientId() + "\ntitle = "
                        + message.getTitle() + "\ncontent = " + message.getContent());
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage message) {
        //点击处理
        Log.e(TAG, "onNotificationMessageClicked -> " + "appid = " + message.getAppid() + "\ntaskid = " + message.getTaskId() + "\nmessageid = "
                + message.getMessageId() + "\npkg = " + message.getPkgName() + "\ncid = " + message.getClientId() + "\ntitle = "+ message.getTitle() + "\ncontent = " + message.getContent());
//        {"type":"0", "text":"这是一条审核消息" } 0 浇筑令 1 配合比
//        MessageData md = mGson.fromJson(message.getContent(),MessageData.class);
//        if(md.getType().equals("0")){
//            Intent dialogIntent = new Intent(getBaseContext(), JobOrderUnVerifyActivity.class);
//            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            getApplication().startActivity(dialogIntent);
//        }else if(md.getType().equals("1")){
//            Intent dialogIntent = new Intent(getBaseContext(), MatchNoticeVerifyActivity.class);
//            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            getApplication().startActivity(dialogIntent);
//        }
    }

    private void setTagResult(SetTagCmdMessage setTagCmdMsg) {
        String sn = setTagCmdMsg.getSn();
        String code = setTagCmdMsg.getCode();

        int text = R.string.add_tag_unknown_exception;
        switch (Integer.valueOf(code)) {
            case PushConsts.SETTAG_SUCCESS:
                text = R.string.add_tag_success;
                break;

            case PushConsts.SETTAG_ERROR_COUNT:
                text = R.string.add_tag_error_count;
                break;

            case PushConsts.SETTAG_ERROR_FREQUENCY:
                text = R.string.add_tag_error_frequency;
                break;

            case PushConsts.SETTAG_ERROR_REPEAT:
                text = R.string.add_tag_error_repeat;
                break;

            case PushConsts.SETTAG_ERROR_UNBIND:
                text = R.string.add_tag_error_unbind;
                break;

            case PushConsts.SETTAG_ERROR_EXCEPTION:
                text = R.string.add_tag_unknown_exception;
                break;

            case PushConsts.SETTAG_ERROR_NULL:
                text = R.string.add_tag_error_null;
                break;

            case PushConsts.SETTAG_NOTONLINE:
                text = R.string.add_tag_error_not_online;
                break;

            case PushConsts.SETTAG_IN_BLACKLIST:
                text = R.string.add_tag_error_black_list;
                break;

            case PushConsts.SETTAG_NUM_EXCEED:
                text = R.string.add_tag_error_exceed;
                break;

            default:
                break;
        }

        Log.d(TAG, "settag result sn = " + sn + ", code = " + code + ", text = " + getResources().getString(text));
    }

    private void bindAliasResult(BindAliasCmdMessage bindAliasCmdMessage) {
        String sn = bindAliasCmdMessage.getSn();
        String code = bindAliasCmdMessage.getCode();

        int text = R.string.bind_alias_unknown_exception;
        switch (Integer.valueOf(code)) {
            case PushConsts.BIND_ALIAS_SUCCESS:
                text = R.string.bind_alias_success;
                break;
            case PushConsts.ALIAS_ERROR_FREQUENCY:
                text = R.string.bind_alias_error_frequency;
                break;
            case PushConsts.ALIAS_OPERATE_PARAM_ERROR:
                text = R.string.bind_alias_error_param_error;
                break;
            case PushConsts.ALIAS_REQUEST_FILTER:
                text = R.string.bind_alias_error_request_filter;
                break;
            case PushConsts.ALIAS_OPERATE_ALIAS_FAILED:
                text = R.string.bind_alias_unknown_exception;
                break;
            case PushConsts.ALIAS_CID_LOST:
                text = R.string.bind_alias_error_cid_lost;
                break;
            case PushConsts.ALIAS_CONNECT_LOST:
                text = R.string.bind_alias_error_connect_lost;
                break;
            case PushConsts.ALIAS_INVALID:
                text = R.string.bind_alias_error_alias_invalid;
                break;
            case PushConsts.ALIAS_SN_INVALID:
                text = R.string.bind_alias_error_sn_invalid;
                break;
            default:
                break;

        }
        Log.d(TAG, "bindAlias result sn = " + sn + ", code = " + code + ", text = " + getResources().getString(text));
    }

    private void unbindAliasResult(UnBindAliasCmdMessage unBindAliasCmdMessage) {
        String sn = unBindAliasCmdMessage.getSn();
        String code = unBindAliasCmdMessage.getCode();

        int text = R.string.unbind_alias_unknown_exception;
        switch (Integer.valueOf(code)) {
            case PushConsts.UNBIND_ALIAS_SUCCESS:
                text = R.string.unbind_alias_success;
                break;
            case PushConsts.ALIAS_ERROR_FREQUENCY:
                text = R.string.unbind_alias_error_frequency;
                break;
            case PushConsts.ALIAS_OPERATE_PARAM_ERROR:
                text = R.string.unbind_alias_error_param_error;
                break;
            case PushConsts.ALIAS_REQUEST_FILTER:
                text = R.string.unbind_alias_error_request_filter;
                break;
            case PushConsts.ALIAS_OPERATE_ALIAS_FAILED:
                text = R.string.unbind_alias_unknown_exception;
                break;
            case PushConsts.ALIAS_CID_LOST:
                text = R.string.unbind_alias_error_cid_lost;
                break;
            case PushConsts.ALIAS_CONNECT_LOST:
                text = R.string.unbind_alias_error_connect_lost;
                break;
            case PushConsts.ALIAS_INVALID:
                text = R.string.unbind_alias_error_alias_invalid;
                break;
            case PushConsts.ALIAS_SN_INVALID:
                text = R.string.unbind_alias_error_sn_invalid;
                break;
            default:
                break;
        }
        Log.d(TAG, "unbindAlias result sn = " + sn + ", code = " + code + ", text = " + getResources().getString(text));
    }


    private void feedbackResult(FeedbackCmdMessage feedbackCmdMsg) {
        String appid = feedbackCmdMsg.getAppid();
        String taskid = feedbackCmdMsg.getTaskId();
        String actionid = feedbackCmdMsg.getActionId();
        String result = feedbackCmdMsg.getResult();
        long timestamp = feedbackCmdMsg.getTimeStamp();
        String cid = feedbackCmdMsg.getClientId();

        Log.d(TAG, "onReceiveCommandResult -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nactionid = " + actionid + "\nresult = " + result
                + "\ncid = " + cid + "\ntimestamp = " + timestamp);
    }

    private void sendMessage(String data, int what) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = data;
//        BaseApplication.sendMessage(msg);
    }
}

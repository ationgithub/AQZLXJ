package com.shtoone.aqxj.fragment.engineeringactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.DesignStrengthActivity;
import com.shtoone.aqxj.activity.OrganizationActivity;
import com.shtoone.aqxj.activity.PourPositionActivity;
import com.shtoone.aqxj.activity.PourWayActivity;
import com.shtoone.aqxj.activity.SlumpActivity;
import com.shtoone.aqxj.activity.WorkingTeamActivity;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.TaskListEditActivityData;
import com.shtoone.aqxj.bean.TaskListImpQueryFragmenData;
import com.shtoone.aqxj.event.EventData;
import com.shtoone.aqxj.ui.PageStateLayout;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.HttpUtils;
import com.shtoone.aqxj.utils.NetworkUtils;
import com.shtoone.aqxj.utils.URL;
import com.socks.library.KLog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import in.srain.cube.views.ptr.PtrFrameLayout;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by Administrator on 2017/8/17.
 */

public class TaskListNewEditActivity extends BaseActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private static final String TAG = TaskListNewEditActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private TaskListImpQueryFragmenData.DataBean mDataBean;
    private boolean isStartDateTime;
    private String startDateTime;
    private String kaipanDataTime;
    private String shigongteamid;
    private Gson mGson;
    private EditText tv_renwuno;
    private EditText tv_jhfl;
    private EditText tv_kaipan_time;
    private EditText tv_gcmc;
    private EditText tv_kddj;
    private EditText tv_ksdj;
    private TextView tv_person;
    private TextView tv_create_time;
    private EditText tv_remrak;
    private TextView tv_depart;
    private TextView tv_jzbw;
    private TextView tv_sjqd;
    private TextView tv_taluodu;
    private TextView tv_jzfs;
    private TextView tv_sgd;
    private String workteamid;
    private TaskListEditActivityData data;
    private List<TaskListEditActivityData.DataBean> listData;
    private String url;
    private Button btn_save;
    private String id;

    private String renwuno;
    private String jihuafangliang;
    private String kaipan_time;
    private String department;
    private String jzbw;
    private String sjqd;
    private String gcmc;
    private String taluodu;
    private String kangdongdengji;
    private String kangshendengji;
    private String jzfs;
    private String createperson;
    private String createTime;
    private String remark;
    private String tasklistdetail;
    private String username;
    private String departmentId;
    private String departId;
    private String treeguid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_edit);
        initView();
        initData();
    }

    private void initView() {
        tasklistdetail = getIntent().getStringExtra("tasklistdetail");
         username = getIntent().getStringExtra("username");
        departId = getIntent().getStringExtra("departmentID");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_task_list_edit_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_task_list_edit_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_task_list_edit_activity);
        btn_save = (Button) findViewById(R.id.btn_save);
        //基础信息
        tv_renwuno = (EditText) findViewById(R.id.tv_renwuno_task_list_edit);
        tv_jhfl = (EditText) findViewById(R.id.tv_fangliang_task_list_edit);
        tv_kaipan_time = (EditText) findViewById(R.id.tv_time_task_list_edit);
        tv_depart = (TextView) findViewById(R.id.tv_depart_task_list_edit);
        tv_jzbw = (TextView) findViewById(R.id.tv_jzbw_task_list_edit);
        tv_sjqd = (TextView) findViewById(R.id.tv_sjqd_task_list_edit);
        tv_taluodu = (TextView) findViewById(R.id.tv_taluodu_task_list_edit);
        tv_jzfs = (TextView) findViewById(R.id.tv_jzfs_task_list_edit);
        tv_sgd = (TextView) findViewById(R.id.tv_workteam_task_list_edit);
        tv_gcmc = (EditText) findViewById(R.id.tv_gcmc_task_list_edit);
        tv_kddj = (EditText) findViewById(R.id.tv_kddj_task_list_edit);
        tv_ksdj = (EditText) findViewById(R.id.tv_ksdj_task_list_edit);
        tv_person = (TextView) findViewById(R.id.tv_person_task_list_edit);
        tv_create_time = (TextView) findViewById(R.id.tv_create_time_task_list_edit);
        tv_remrak = (EditText) findViewById(R.id.tv_remrak_task_list_edit);

        btn_save.setOnClickListener(this);
        tv_depart.setOnClickListener(this);
        tv_jzbw.setOnClickListener(this);
        tv_sjqd.setOnClickListener(this);
        tv_taluodu.setOnClickListener(this);
        tv_jzfs.setOnClickListener(this);
        tv_sgd.setOnClickListener(this);

        tv_kaipan_time.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setStartDateTime();
                        break;
                }
                return true;
            }
        });
        tv_create_time.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setStartDateTime();
                        break;
                }
                return true;
            }
        });
        //任务单标号
        tv_renwuno.addTextChangedListener(new TextWatcher() {
            private int cou = 0;
            int selectionEnd = 0;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cou = before + count;
                String editable = tv_renwuno.getText().toString();
                String str = stringFilter(editable); //过滤特殊字符
                if (!editable.equals(str)) {
                    tv_renwuno.setText(str);
                }
                tv_renwuno.setSelection(tv_renwuno.length());
                cou = tv_renwuno.length();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (cou > mMaxLenth) {
                    selectionEnd = tv_renwuno.getSelectionEnd();
                    s.delete(mMaxLenth, selectionEnd);
                }
            }
        });
        //计划方量
        tv_jhfl.addTextChangedListener(new TextWatcher() {
            private int cou = 0;
            int selectionEnd = 0;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cou = before + count;
                String editable = tv_jhfl.getText().toString();
                String str = stringFilter(editable); //过滤特殊字符
                if (!editable.equals(str)) {
                    tv_jhfl.setText(str);
                }
                tv_jhfl.setSelection(tv_jhfl.length());
                cou = tv_jhfl.length();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (cou > mMaxLenth) {
                    selectionEnd = tv_jhfl.getSelectionEnd();
                    s.delete(mMaxLenth, selectionEnd);
                }
            }
        });
        //抗冻等级
        tv_kddj.addTextChangedListener(new TextWatcher() {
            private int cou = 0;
            int selectionEnd = 0;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cou = before + count;
                String editable = tv_kddj.getText().toString();
                String str = stringFilter(editable); //过滤特殊字符
                if (!editable.equals(str)) {
                    tv_kddj.setText(str);
                }
                tv_kddj.setSelection(tv_kddj.length());
                cou = tv_kddj.length();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (cou > mMaxLenth) {
                    selectionEnd = tv_kddj.getSelectionEnd();
                    s.delete(mMaxLenth, selectionEnd);
                }
            }
        });
        //抗渗等级
        tv_ksdj.addTextChangedListener(new TextWatcher() {
            private int cou = 0;
            int selectionEnd = 0;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cou = before + count;
                String editable = tv_ksdj.getText().toString();
                String str = stringFilter(editable); //过滤特殊字符
                if (!editable.equals(str)) {
                    tv_ksdj.setText(str);
                }
                tv_ksdj.setSelection(tv_ksdj.length());
                cou = tv_ksdj.length();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (cou > mMaxLenth) {
                    selectionEnd = tv_ksdj.getSelectionEnd();
                    s.delete(mMaxLenth, selectionEnd);
                }
            }
        });
        //备注
        tv_remrak.addTextChangedListener(new TextWatcher() {
            private int cou = 0;
            int selectionEnd = 0;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cou = before + count;
                String editable = tv_remrak.getText().toString();
                String str = stringFilter(editable); //过滤特殊字符
                if (!editable.equals(str)) {
                    tv_remrak.setText(str);
                }
                tv_remrak.setSelection(tv_remrak.length());
                cou = tv_remrak.length();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (cou > mMaxLenth) {
                    selectionEnd = tv_remrak.getSelectionEnd();
                    s.delete(mMaxLenth, selectionEnd);
                }
            }
        });
    }

    int mMaxLenth = 200;//设置允许输入的字符长度
    public  String stringFilter(String str)throws PatternSyntaxException {
        String regEx = "[/\\:*?<>|\"\n\t]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

    private void initData() {
        listData = new ArrayList<>();
        mGson = new Gson();
        tv_person.setText(username);
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        setSupportActionBar(mToolbar);
       // initPageStateLayout(mPageStateLayout);
       // initPtrFrameLayout(mPtrFrameLayout);
        Log.e(TAG, "----------initData-----------" );
    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mNestedScrollView.getScrollY() == 0) {
            return true;
        }
        return false;
    }

//    @Override
//    public String createRefreshULR() {
//        mPageStateLayout.showLoading();
//        //todo
////        String taskListEditData = URL.getRenwudanEditData(mDataBean.getId());
////        Log.e(TAG,"url=:"+taskListEditData);
////        return URL.getRenwudanEditData(mDataBean.getId());
//        url = URL.getRenwudanEditData(tasklistdetail);
//        Log.e(TAG, "任务单编辑url=:"+url);
//
//        return url;
//    }

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
                data = mGson.fromJson(response, TaskListEditActivityData.class);
                if (null != data) {
                    if (data.isSuccess()) {
                        mPageStateLayout.showContent();
                        listData.addAll(data.getData());
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
    public void loadMoreSuccess(String response) {
        setTaskListEditActivityView(response);
    }

    public void setTaskListEditActivityView(String response){

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

        List<TaskListEditActivityData.DataBean> data = this.data.getData();
        TaskListEditActivityData.DataBean dataBean = data.get(0);
//        tv_renwuno.setText(dataBean.getRenwuno());
//        tv_jhfl.setText(dataBean.getJihuafangliang());
//        tv_kaipan_time.setText(dataBean.getKaipanriqi());
//        tv_gcmc.setText(dataBean.getGcmc());
//        tv_kddj.setText(dataBean.getKangdongdengji());
//        tv_ksdj.setText(dataBean.getKangshendengji());
//        tv_person.setText(dataBean.getCreateperson());
//        tv_create_time.setText(dataBean.getCreatetime());
//        tv_remrak.setText(dataBean.getRemark());
//        tv_jzfs.setText(dataBean.getJiaozhufangshi());
//        tv_depart.setText(dataBean.getDepartname());
//        tv_sjqd.setText(dataBean.getShuinibiaohao());
//        tv_taluodu.setText(dataBean.getTanluodu());
//
//        if(!TextUtils.isEmpty(dataBean.getJzbw())){
//            tv_jzbw.setText(dataBean.getJzbw());
//            Log.e(TAG,"++++++++++++++++");
//        }
//        id = dataBean.getId();

    }


    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.engineering_department) + " > ");
            sb.append(getString(R.string.renwudan_zx) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //保存
            case R.id.btn_save:
                renwuno = tv_renwuno.getText().toString().trim();
                jihuafangliang = tv_jhfl.getText().toString().trim();
                kaipan_time = tv_kaipan_time.getText().toString().trim();
                department = tv_depart.getText().toString().trim();
                jzbw = tv_jzbw.getText().toString().trim();
                sjqd = tv_sjqd.getText().toString().trim();
                gcmc = tv_gcmc.getText().toString().trim();
                taluodu = tv_taluodu.getText().toString().trim();
                kangdongdengji  = tv_kddj.getText().toString().trim();
                kangshendengji   = tv_ksdj.getText().toString().trim();
                jzfs = tv_jzfs.getText().toString().trim();
                createperson  = tv_person.getText().toString().trim();
                createTime  = tv_create_time.getText().toString().trim();
                remark   = tv_remrak.getText().toString().trim();

                if (!TextUtils.isEmpty(renwuno) && !TextUtils.isEmpty(jihuafangliang) && !TextUtils.isEmpty(kaipan_time)&& !TextUtils.isEmpty(department) && !TextUtils.isEmpty(jzbw)&& !TextUtils.isEmpty(gcmc)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(TaskListNewEditActivity.this)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    MaterialDialog progressDialog = new MaterialDialog.Builder(TaskListNewEditActivity.this)
                                            .title("提交")
                                            .content("正在提交中，请稍等……")
                                            .progress(true, 0)
                                            .progressIndeterminateStyle(true)
                                            .cancelable(false)
                                            .show();
                                    taskEditSave(progressDialog);
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    if (TextUtils.isEmpty(renwuno)) {
                        tv_renwuno.setError("任务编号不能为空");
                    } else if (TextUtils.isEmpty(jihuafangliang)) {
                        tv_jhfl.setError("计划方量不能为空");
                    }else if (TextUtils.isEmpty(kaipan_time)) {
                        tv_kaipan_time.setError("开盘时间不能为空");
                    }else if (TextUtils.isEmpty(department)) {
                        tv_depart.setError("所属机构不能为空");
                    }else if (TextUtils.isEmpty(jzbw)) {
                        tv_jzbw.setError("浇筑部位不能为空");
                    }else if (TextUtils.isEmpty(gcmc)) {
                        tv_gcmc.setError("工程名称不能为空");
                    }
                }
                break;



            //所属机构
            case R.id.tv_depart_task_list_edit:
                Intent intent1 = new Intent(this,OrganizationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ConstantsUtils.DEPARTMENT, mDepartmentData);
                intent1.putExtras(bundle);
                intent1.putExtra("type", "1");
                intent1.putExtra("newedite","newedite");
                startActivityForResult(intent1,1);
                break;

            case R.id.tv_jzbw_task_list_edit:
                Intent intent2 = new Intent(this,PourPositionActivity.class);
                intent2.putExtra("departId",departId);
                startActivityForResult(intent2,2);
                break;

            case R.id.tv_sjqd_task_list_edit:
                Intent intent3 = new Intent(this,DesignStrengthActivity.class);
                startActivityForResult(intent3,3);
                break;

            case R.id.tv_taluodu_task_list_edit:
                Intent intent4 = new Intent(this,SlumpActivity.class);
                startActivityForResult(intent4,4);
                break;

            case R.id.tv_jzfs_task_list_edit:
                Intent intent5 = new Intent(this,PourWayActivity.class);
                startActivityForResult(intent5,5);
                break;

            case R.id.tv_workteam_task_list_edit:
                Intent intent6 = new Intent(this,WorkingTeamActivity.class);
                intent6.putExtra("departId",departId);
                startActivityForResult(intent6,6);

                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1){
            if (resultCode == 15){
                tv_depart.setText(data.getExtras().getString("departmentname"));
                departmentId = data.getExtras().getString("departmentnno");
                Log.e("tv_depart",data.getStringExtra("departmentname"));
            }
        }if (requestCode == 2){
            if (resultCode == 22){
                tv_jzbw.setText(data.getExtras().getString("pourposition"));
                tv_gcmc.setText(data.getExtras().getString("projectname"));
                tv_sjqd.setText(data.getExtras().getString("sjqd"));
                tv_jhfl.setText(data.getExtras().getString("sjfl"));
                treeguid = data.getExtras().getString("treeguid");
                Log.e("tv_jzbw",data.getStringExtra("pourposition"));

            }
        }else if (requestCode == 3){
            if (resultCode == 33){
                tv_sjqd.setText(data.getExtras().getString("designstrength"));
                Log.e("tv_sjqd",data.getStringExtra("designstrength"));
            }
        }else if (requestCode == 4){
            if (resultCode == 44){
                tv_taluodu.setText(data.getExtras().getString("slumpdata"));
                Log.e("tv_taluodu",data.getStringExtra("slumpdata"));

            }
        }else if (requestCode == 5){
            if (resultCode == 55){
                tv_jzfs.setText(data.getExtras().getString("pourway"));
                Log.e("tv_jzfs",data.getStringExtra("pourway"));
            }
        }else if (requestCode == 6){
            if (resultCode == 66){
                tv_sgd.setText(data.getExtras().getString("workteam"));
                workteamid = data.getExtras().getString("workteamid");
                Log.e("tv_sgd",data.getStringExtra("workteamid"));
            }
        }
    }

    private void taskEditSave(final MaterialDialog progressDialog) {

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("isAdd","1");
 //       paramsMap.put("id",id);
        paramsMap.put("renwuno", renwuno);
        paramsMap.put("jihuafangliang", jihuafangliang);
        paramsMap.put("kaipanriqi",kaipan_time);
        paramsMap.put("jzbw", jzbw);
        paramsMap.put("shuinibiaohao", sjqd);
        paramsMap.put("gcmc", gcmc);
        paramsMap.put("tanluodu", taluodu);
        paramsMap.put("kangdongdengji", kangdongdengji);
        paramsMap.put("kangshendengji", kangshendengji);
        paramsMap.put("jiaozhufangshi", jzfs);
        paramsMap.put("createperson", createperson);
        paramsMap.put("createtime", createTime);
        paramsMap.put("remark", remark);
        paramsMap.put("username",username);
        paramsMap.put("departid",departmentId);
        paramsMap.put("shigongteamid",workteamid);
        paramsMap.put("treeguid",treeguid);
        List<Map<String,String>> maps = new ArrayList<>();


        HttpUtils.postJsonRequest(URL.TASK_EDIT_SAVE, paramsMap, new HttpUtils.HttpListener() {
            @Override
            public void onSuccess(String response) {
                progressDialog.dismiss();
                KLog.json(response);
                if (!TextUtils.isEmpty(response)) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        TastyToast.makeText(getApplicationContext(), "解析异常！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }

                    if (jsonObject.optBoolean("success")) {

                        BaseApplication.bus.post(new EventData(ConstantsUtils.REFRESH));
                        TastyToast.makeText(getApplicationContext(), "上传成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                        finish();
                    } else if(!jsonObject.optBoolean("success")){
                        TastyToast.makeText(getApplicationContext(), "任务单单号已存在", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                    }else {
                        TastyToast.makeText(getApplicationContext(), "上传失败，请重试！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }



                } else {
                    TastyToast.makeText(getApplicationContext(), "上传失败，请重试！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }
            }

            @Override
            public void onFailed(VolleyError error) {
                progressDialog.dismiss();
                if (!NetworkUtils.isConnected(TaskListNewEditActivity.this)) {
                    //提示网络异常,让用户点击设置网络，
                    View view = TaskListNewEditActivity.this.getWindow().getDecorView();
                    Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                            .setAction("设置网络", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // 跳转到系统的网络设置界面
                                    NetworkUtils.openSetting(TaskListNewEditActivity.this);
                                }
                            }).show();
                } else {
                    //服务器异常，展示错误页面，点击刷新
                    TastyToast.makeText(getApplicationContext(), "服务器异常！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }
            }
        });
    }

    private void setStartDateTime() {
        isStartDateTime = true;
        showDatePicker();
    }

    private void showDatePicker() {
        Calendar now = Calendar.getInstance();
        if (isStartDateTime) {
            now.add(Calendar.MONTH, -3);
        }
        DatePickerDialog dpd = DatePickerDialog.newInstance(TaskListNewEditActivity.this, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        dpd.vibrate(true);
        dpd.dismissOnPause(false);
        dpd.setAccentColor(Color.parseColor("#3F51B5"));
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    private void showTimePicker() {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(TaskListNewEditActivity.this, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);
        tpd.vibrate(true);
        tpd.dismissOnPause(false);
        tpd.setAccentColor(Color.parseColor("#3F51B5"));
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String monthString = (++monthOfYear) < 10 ? "0" + (monthOfYear) : "" + (monthOfYear);
        String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
        String dateString = year + "-" + monthString + "-" + dayString + " ";
        if (isStartDateTime) {
            startDateTime = dateString;
            kaipanDataTime = dateString;
        }
        showTimePicker();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String timeString = hourString + ":" + minuteString + ":" + secondString;
        if (isStartDateTime) {
            startDateTime = startDateTime + timeString;
            tv_create_time.setText(startDateTime);
            tv_kaipan_time.setText(kaipanDataTime);
        }
    }
}

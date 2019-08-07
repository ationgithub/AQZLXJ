package com.shtoone.aqxj.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.bean.BHZEquipment;
import com.shtoone.aqxj.bean.DesignStrengthData;
import com.shtoone.aqxj.bean.EquipmentAndTestTypeData;
import com.shtoone.aqxj.bean.MaterialListData;
import com.shtoone.aqxj.bean.ParametersData;
import com.shtoone.aqxj.bean.StorageMaterialData;
import com.shtoone.aqxj.bean.WaagListData;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.DateUtils;
import com.shtoone.aqxj.utils.URL;
import com.socks.library.KLog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

import static com.shtoone.aqxj.BaseApplication.mDepartmentData;

/**
 * Created by leguang on 2016/6/01 0031.
 */

public class DialogActivity extends BaseActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private static final String TAG = DialogActivity.class.getSimpleName();
    private TextInputLayout start_date_time;
    private TextInputLayout end_date_time;
    private CircularProgressButton bt_search;
    private MaterialSpinner ms_select_equipment;
    private MaterialSpinner ms_select_test_type;
    private MaterialSpinner ms_select_material;
    private MaterialSpinner ms_select_strength;
    private MaterialSpinner ms_select_lq;
    private MaterialSpinner ms_select_waagname;
    //    private MaterialSpinner ms_select_materialname;
    private ImageView iv_cancel;
    private boolean isStartDateTime;
    private String startDateTime;
    private String endDateTime;
    private ParametersData mParametersData;
    private FrameLayout fl_container;
    private String url;
    private EquipmentAndTestTypeData mEquipmentTestData;
    private BHZEquipment mBHZEquipment;
    private StorageMaterialData mStorageMaterialData;
    private DesignStrengthData mDesignStrengthData;
    private List<String> equipmentNames;
    private List<String> equipmentIDs;
    private List<String> testTypeNames;
    private List<String> testTypeIDs;
    private List<String> materialIDs;
    private List<String> materialNames;
    private List<String> strengthIds;
    private List<String> lqList;
    private List<String> strengthNames;
    private RadioGroup rg_handle;
    private RadioGroup rg_examine;
    private RadioGroup rg_tasklist;
    private RadioGroup rg_unfinsh;
    private RadioGroup rg_finsh;
    private RadioGroup               rg_jinchang_handle;
    private RadioGroup               rg_chuchang_handle;
    private RadioGroup               rg_sjpeihe_dialog;
    private WaagListData             waagListData;
    private MaterialListData         materialListData;
    private List<String>             cailiaoName;
    private List<String>             cailiaoNo;
    private TextView tv_MaterialName;
    private TextView tv_DepartmentName;
    private EditText ed_jzbw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
    }

    private void initView() {
        //获取传过来的参数对象
        fl_container = (FrameLayout) findViewById(R.id.fl_container_dialog_activity);
        mParametersData = (ParametersData) getIntent().getSerializableExtra(ConstantsUtils.PARAMETERS);
        start_date_time = (TextInputLayout) findViewById(R.id.start_date_time_dialog);
        end_date_time = (TextInputLayout) findViewById(R.id.end_date_time_dialog);
        start_date_time.getEditText().setText(startDateTime = mParametersData.startDateTime);
        end_date_time.getEditText().setText(endDateTime = mParametersData.endDateTime);
        bt_search = (CircularProgressButton) findViewById(R.id.bt_search_dialog);
        iv_cancel = (ImageView) findViewById(R.id.iv_cancel_dialog);
        ms_select_equipment = (MaterialSpinner) findViewById(R.id.ms_select_equipment_dialog);
        ms_select_test_type = (MaterialSpinner) findViewById(R.id.ms_select_test_type_dialog);
        ms_select_material = (MaterialSpinner) findViewById(R.id.ms_select_material_dialog);
        ms_select_strength = (MaterialSpinner) findViewById(R.id.ms_select_strength_dialog);
        ms_select_lq = (MaterialSpinner) findViewById(R.id.ms_select_lq_dialog);
        ms_select_waagname = (MaterialSpinner) findViewById(R.id.ms_select_waagname_dialog);
//        ms_select_materialname = (MaterialSpinner) findViewById(R.id.ms_select_materialname_dialog);
        rg_handle = (RadioGroup) findViewById(R.id.rg_handle_dialog);
        rg_examine = (RadioGroup) findViewById(R.id.rg_examine_dialog);
        rg_jinchang_handle = (RadioGroup) findViewById(R.id.rg_jinchang_handle_dialog);
        rg_chuchang_handle= (RadioGroup) findViewById(R.id.rg_chuchang_handle_dialog);
        rg_tasklist = (RadioGroup) findViewById(R.id.rg_tasklist_dialog);
        rg_unfinsh = (RadioGroup) findViewById(R.id.rg_unfinsh_dialog);
        rg_finsh = (RadioGroup) findViewById(R.id.rg_finsh_dialog);
        rg_sjpeihe_dialog = (RadioGroup) findViewById(R.id.rg_sjpeihe_dialog);
        start_date_time.getEditText().setInputType(InputType.TYPE_NULL);
        end_date_time.getEditText().setInputType(InputType.TYPE_NULL);
        tv_MaterialName = (TextView) findViewById(R.id.tv_material_choose);
        tv_DepartmentName = (TextView) findViewById(R.id.tv_department_choose);
        ed_jzbw = (EditText) findViewById(R.id.ed_jzbw_choose);

        iv_cancel.setOnClickListener(this);
        bt_search.setOnClickListener(this);
        tv_MaterialName.setOnClickListener(this);
        tv_DepartmentName.setOnClickListener(this);

        start_date_time.getEditText().setOnTouchListener(new View.OnTouchListener() {
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

        end_date_time.getEditText().setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        end_date_time.setError("");
                        end_date_time.setErrorEnabled(false);
                        setEndDateTime();
                        break;
                }
                return true;
            }
        });


        ms_select_equipment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KLog.e("equipment选择第：" + i + "个");
                if (i >= 0) {
                    mParametersData.equipmentID = equipmentIDs.get(i);
                    KLog.e("equipmentIDs[i]:" + equipmentNames.get(i));
                } else if (i == -1) {
                    mParametersData.equipmentID = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ms_select_test_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KLog.e("test_type选择第：" + i + "个");
                if (i >= 0) {
                    mParametersData.testTypeID = testTypeIDs.get(i);
                    KLog.e("testTypeIDs[i]:" + testTypeNames.get(i));
                } else if (i == -1) {
                    mParametersData.testTypeID = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ms_select_material.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e(TAG,"material选择第：" + i + "个");
                if (i >= 0) {
                    mParametersData.materialID = materialIDs.get(i);
                    Log.e(TAG,"materialIDs[i]:" + materialNames.get(i));
                } else if (i == -1) {
                    mParametersData.materialID = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        /*****************************************/
        //假数据
        lqList = new ArrayList<>();
        //使用数组作为数据源
        final String[] lqDataArr = new String[]{"7","28","56"};
        // adpater对象
        ArrayAdapter<String> lqArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lqDataArr);
        ms_select_lq.setAdapter(lqArrayAdapter);
        ms_select_lq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i >= 0) {
                    mParametersData.lq = lqDataArr[i];
                } else if (i == -1) {
                    mParametersData.strengthId = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*****************************************/

        ms_select_waagname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KLog.e("equipment选择第：" + i + "个");
                if (i >= 0) {
                    mParametersData.equipmentID = equipmentIDs.get(i);
                    KLog.e("equipmentIDs[i]:" + equipmentNames.get(i));
                } else if (i == -1) {
                    mParametersData.equipmentID = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        ms_select_materialname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.e("equipment选择第：", + i + "个");
//                if (i >= 0) {
//                    Log.e(TAG, "onItemSelected: "+ cailiaoNo.size() +" bianhao88  " + cailiaoNo.get(i));
//                    mParametersData.cailiaono = cailiaoNo.get(i);
//                    KLog.e("equipmentIDs[i]:" + cailiaoName.get(i));
//                } else if (i == -1) {
//                    mParametersData.cailiaono = "";
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        rg_handle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.rb_all_handle_dialog) {
                    rg_examine.setVisibility(View.INVISIBLE);
                    mParametersData.handleType = "";
                } else if (i == R.id.rb_not_handle_dialog) {
                    rg_examine.setVisibility(View.INVISIBLE);
                    rg_examine.check(R.id.rb_all_examine_dialog);
                    mParametersData.handleType = "0";
                } else if (i == R.id.rb_handled_dialog) {
                    rg_examine.setVisibility(View.VISIBLE);
                    mParametersData.handleType = "1";
                }
            }
        });

        rg_examine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_all_examine_dialog) {
                    mParametersData.handleType = "1";
                } else if (i == R.id.rb_not_examine_dialog) {
                    mParametersData.handleType = "2";
                } else if (i == R.id.rb_examined_dialog) {
                    mParametersData.handleType = "3";
                }
            }
        });

        rg_jinchang_handle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                if (i==R.id.rb_ji_handle_dialog){
                    mParametersData.dataType="0";
                }else if(i==R.id.rb_yue_handle_dialog){
                    mParametersData.dataType="1";
                }else if (i==R.id.rb__zhou_handled_dialog){
                    mParametersData.dataType = "2";
                }
            }
        });

        rg_chuchang_handle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                if (i==R.id.rb_chu_all_handle_dialog){
                    mParametersData.states="";
                }else if (i==R.id.rb_feiliao_handle_dialog){
                    mParametersData.states="0";
                }else if (i==R.id.rb__diaobo_handled_dialog){
                    mParametersData.states="1";
                }
            }
        });

        rg_tasklist.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                if (i==R.id.rb_all_tasklist_dialog){
                    mParametersData.zhuangtai="";
                }else if (i==R.id.rb_unpeiliao_tasklist_dialog){
                    mParametersData.zhuangtai="0";
                }else if (i==R.id.rb_peiliao_tasklist_dialog){
                    mParametersData.zhuangtai="1";
                }else if (i==R.id.rb_unfinsh_tasklist_dialog){
                    mParametersData.zhuangtai="2";
                }else if (i==R.id.rb_finsh_tasklist_dialog){
                    mParametersData.zhuangtai="3";
                }
            }
        });

        rg_unfinsh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                if (i==R.id.rb_unfinsh_all_handle_dialog){
                    mParametersData.unfinsh="";
                }else if (i==R.id.rb_unfinsh_unsubmit_handle_dialog){
                    mParametersData.unfinsh="-1";
                }else if (i==R.id.rb_unfinsh_unpeiliao_dialog){
                    mParametersData.unfinsh="0";
                }else if (i==R.id.rb_unfinsh_peiliao_dialog){
                    mParametersData.unfinsh="1";
                }
            }
        });

        rg_finsh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                if (i==R.id.rb_finsh_all_handle_dialog){
                    mParametersData.finsh="";
                }else if (i==R.id.rb_finsh_complete_handle_dialog){
                    mParametersData.finsh="3";
                }else if (i==R.id.rb_finsh_uncomplete_dialog){
                    mParametersData.finsh="2";
                }

            }
        });

        rg_sjpeihe_dialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                if (i==R.id.rb_all_sjpeihe_dialog){
                    mParametersData.sjzt = "";
                }else if (i == R.id.rb_unsubmit_sjpeihe_dialog){
                    mParametersData.sjzt = "-1";
                }else if (i== R.id.rb_submit_sjpeihe_dialog){
                    mParametersData.sjzt = "0";
                }
            }
        });



        //设置哪些条件选择该显示，默认只有时间选择是显示的
        switch (mParametersData.fromTo) {

            case ConstantsUtils.POURPOSITION:
                start_date_time.setVisibility(View.GONE);
                end_date_time.setVisibility(View.GONE);
                ed_jzbw.setVisibility(View.VISIBLE);


                break;

            case ConstantsUtils.ENGINEERINGHOME:
            case ConstantsUtils.LABORATORYFRAGMENT:
            case ConstantsUtils.CONCRETEFRAGMENT:
                //默认开始和结束时间是可见的
                break;
            case ConstantsUtils.WANNENGJIFRAGMENT:
                ms_select_equipment.setVisibility(View.VISIBLE);
                url = URL.getLibEquipmentTest(mParametersData.userGroupID);
                refresh();
                Log.e("WANNENGJIFRAGMENT", "url=:" + url);
                break;
            case ConstantsUtils.YALIJIFRAGMENT:
                //设置设备和试验类型的下拉选择可见
                ms_select_equipment.setVisibility(View.VISIBLE);
                ms_select_strength.setVisibility(View.VISIBLE);
                ms_select_lq.setVisibility(View.VISIBLE);
                url = URL.getLibEquipmentTest(mParametersData.userGroupID);
                Log.e("YALIJIFRAGMENT", "url=:" + url);

                //假数据
                strengthIds = new ArrayList<>();
                //使用数组作为数据源
                final String[] strengthDataArr = new String[]{"C15","C20","C25","C30","C35","C40","C45","C50","C55","C60","C65",};
                // adpater对象
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strengthDataArr);
                ms_select_strength.setAdapter(arrayAdapter);
                ms_select_strength.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i >= 0) {
                            mParametersData.sjqd = strengthDataArr[i];
                        } else if (i == -1) {
                            mParametersData.strengthId = "";
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                refresh();
                break;
//            case ConstantsUtils.TASKLISTIMPQUERYFRAGMENT:
//                url = URL.getDataDictionary("SJQD");
//                refresh();
//                break;


            case ConstantsUtils.MATERIALSTATISTICFRAGMENT:
            case ConstantsUtils.PRODUCEQUERYFRAGMENT:
                //设置设备的下拉选择可见
                ms_select_equipment.setVisibility(View.VISIBLE);
                url = URL.getBHZEquipment(mParametersData.userGroupID);
                refresh();
                break;

            case ConstantsUtils.OVERPROOFFRAGMENT:
                //设置设备的下拉选择可见
                ms_select_equipment.setVisibility(View.VISIBLE);
                rg_handle.setVisibility(View.VISIBLE);
                rg_examine.setVisibility(View.INVISIBLE);
                url = URL.getBHZEquipment(mParametersData.userGroupID);
                refresh();
                break;
            case ConstantsUtils.WEIGHTHOUSEFRAGMENT:
                ms_select_waagname.setVisibility(View.VISIBLE);
                tv_MaterialName.setVisibility(View.VISIBLE);
//                ms_select_materialname.setVisibility(View.VISIBLE);
                url = URL.getWaagList(mParametersData.userGroupID);
                refresh();
//                url = URL.MATERIAL_LIST;
//                loadMore();
                break;

            case ConstantsUtils.YCLJINCHANG:
                rg_jinchang_handle.setVisibility(View.VISIBLE);
                ms_select_waagname.setVisibility(View.VISIBLE);
                tv_MaterialName.setVisibility(View.VISIBLE);
                //tv_DepartmentName.setVisibility(View.VISIBLE);
                url = URL.getWaagList(mParametersData.userGroupID);
                refresh();
                break;

            case ConstantsUtils.YCLCHUCHANG:
                rg_jinchang_handle.setVisibility(View.VISIBLE);
                rg_chuchang_handle.setVisibility(View.VISIBLE);
                ms_select_waagname.setVisibility(View.VISIBLE);
                tv_MaterialName.setVisibility(View.VISIBLE);
                //tv_DepartmentName.setVisibility(View.VISIBLE);
                url = URL.getWaagList(mParametersData.userGroupID);
                refresh();

                break;
            case ConstantsUtils.STORAGEFRAGMENT:
 //               ms_select_material.setVisibility(View.VISIBLE);
 //               url = URL.getStorageMaterialName();
                tv_MaterialName.setVisibility(View.VISIBLE);
 //               refresh();
                 break;
            case ConstantsUtils.TASKLISTIMPQUERYFRAGMENT:
                ms_select_strength.setVisibility(View.VISIBLE);
                rg_tasklist.setVisibility(View.VISIBLE);
                url = URL.getDataDictionary("SJQD");
                refresh();
                break;


            case ConstantsUtils.JOBORDERFINSH:
//                tv_DepartmentName.setVisibility(View.VISIBLE);
//                rg_finsh.setVisibility(View.VISIBLE);
                break;

            case ConstantsUtils.JOBORDERUNSUBMIT:


                break;

            case ConstantsUtils.JOBORDERUNCOMPOUNDING:

                break;

            case ConstantsUtils.JOBORDERCOMPOUNDING:

                break;

            case ConstantsUtils.JOBORDERUNFINSH:
                rg_unfinsh.setVisibility(View.VISIBLE);

                break;

            case ConstantsUtils.MATERIALCONSUME:
                //tv_DepartmentName.setVisibility(View.VISIBLE);

                break;

            case ConstantsUtils.SHEJIPEIHEBI:
                rg_sjpeihe_dialog.setVisibility(View.VISIBLE);
                ms_select_strength.setVisibility(View.VISIBLE);
                url = URL.getDataDictionary("SJQD");
                refresh();
                break;
        }

        if (mParametersData.finsh.equals("")){
            rg_finsh.check(R.id.rb_finsh_all_handle_dialog);
        }else if (mParametersData.finsh.equals("2")){
            rg_finsh.check(R.id.rb_finsh_uncomplete_dialog);
        }else if (mParametersData.finsh.equals("3")){
            rg_finsh.check(R.id.rb_finsh_complete_handle_dialog);
        }

        if (mParametersData.unfinsh.equals("")){
            rg_unfinsh.check(R.id.rb_unfinsh_all_handle_dialog);
        }else if (mParametersData.unfinsh.equals("-1")){
            rg_unfinsh.check(R.id.rb_unfinsh_unsubmit_handle_dialog);
        }else if (mParametersData.unfinsh.equals("0")){
            rg_unfinsh.check(R.id.rb_unfinsh_unpeiliao_dialog);
        }else if (mParametersData.unfinsh.equals("1")){
            rg_unfinsh.check(R.id.rb_unfinsh_peiliao_dialog);
        }

        if (mParametersData.handleType.equals("")) {
            rg_handle.check(R.id.rb_all_handle_dialog);
        } else if (mParametersData.handleType.equals("0")) {
            rg_handle.check(R.id.rb_not_handle_dialog);
        } else if (mParametersData.handleType.equals("1")) {
            rg_handle.check(R.id.rb_handled_dialog);
            rg_examine.check(R.id.rb_all_examine_dialog);
            rg_examine.setVisibility(View.VISIBLE);
        } else if (mParametersData.handleType.equals("2")) {
            rg_handle.check(R.id.rb_handled_dialog);
            rg_examine.check(R.id.rb_not_examine_dialog);
            rg_examine.setVisibility(View.VISIBLE);
        } else if (mParametersData.handleType.equals("3")) {
            rg_handle.check(R.id.rb_handled_dialog);
            rg_examine.check(R.id.rb_examined_dialog);
            rg_examine.setVisibility(View.VISIBLE);
        }

        if (mParametersData.dataType.equals("0")){
            rg_jinchang_handle.check(R.id.rb_ji_handle_dialog);
        }else if(mParametersData.dataType.equals("1")){
            rg_jinchang_handle.check(R.id.rb_yue_handle_dialog);
        }else if (mParametersData.dataType.equals("2")){
            rg_jinchang_handle.check(R.id.rb__zhou_handled_dialog);
        }

        if (mParametersData.states.equals("")){
            rg_chuchang_handle.check(R.id.rb_chu_all_handle_dialog);
        }else if(mParametersData.states.equals("0")){
            rg_chuchang_handle.check(R.id.rb_feiliao_handle_dialog);
        }else if (mParametersData.states.equals("1")){
            rg_chuchang_handle.check(R.id.rb__diaobo_handled_dialog);
        }

        if (mParametersData.zhuangtai.equals("")){
            rg_tasklist.check(R.id.rb_all_tasklist_dialog);
        }else if(mParametersData.zhuangtai.equals("0")){
            rg_tasklist.check(R.id.rb_unpeiliao_tasklist_dialog);
        }else if (mParametersData.zhuangtai.equals("1")){
            rg_tasklist.check(R.id.rb_peiliao_tasklist_dialog);
        }else if (mParametersData.zhuangtai.equals("2")){
            rg_tasklist.check(R.id.rb_unfinsh_tasklist_dialog);
        }else if (mParametersData.zhuangtai.equals("3")){
            rg_tasklist.check(R.id.rb_finsh_tasklist_dialog);
        }

        if (mParametersData.sjzt.equals("")){
            rg_sjpeihe_dialog.check(R.id.rb_all_sjpeihe_dialog);
        }else if (mParametersData.sjzt.equals("-1")){
            rg_sjpeihe_dialog.check(R.id.rb_unsubmit_sjpeihe_dialog);
        }else if (mParametersData.sjzt.equals("0")){
            rg_sjpeihe_dialog.check(R.id.rb_submit_sjpeihe_dialog);
        }


    }

//    @Override
//    public void loadMoreSuccess(String response) {
//        materialListData = new Gson().fromJson(response, MaterialListData.class);
//        setMaterialListView();
//    }

    @Override
    public void onRefreshSuccess(String response) {
        Log.e(TAG, "response=:" + response.toString());
        switch (mParametersData.fromTo) {
            case ConstantsUtils.ENGINEERINGHOME:
            case ConstantsUtils.LABORATORYFRAGMENT:
            case ConstantsUtils.CONCRETEFRAGMENT:

                break;

            case ConstantsUtils.YALIJIFRAGMENT:
                mEquipmentTestData = new Gson().fromJson(response, EquipmentAndTestTypeData.class);
                setYalijiQueryView();
                break;

            case ConstantsUtils.WANNENGJIFRAGMENT:
                mEquipmentTestData = new Gson().fromJson(response, EquipmentAndTestTypeData.class);
                setWannengjiQueryView();
                break;

            case ConstantsUtils.MATERIALSTATISTICFRAGMENT:
            case ConstantsUtils.PRODUCEQUERYFRAGMENT:
            case ConstantsUtils.OVERPROOFFRAGMENT:
                mBHZEquipment = new Gson().fromJson(response, BHZEquipment.class);
                setBHZQueryView();
                break;
            case ConstantsUtils.STORAGEFRAGMENT:
                mStorageMaterialData = new Gson().fromJson(response, StorageMaterialData.class);
                setStorageQueryView();
                break;
            case ConstantsUtils.TASKLISTIMPQUERYFRAGMENT:
                mDesignStrengthData = new Gson().fromJson(response, DesignStrengthData.class);
                setStrengthQueryView();
                break;
            case ConstantsUtils.WEIGHTHOUSEFRAGMENT:
                waagListData = new Gson().fromJson(response, WaagListData.class);
                setWaagListView();
                break;

            case ConstantsUtils.YCLJINCHANG:
                waagListData = new Gson().fromJson(response, WaagListData.class);
                setWaagListView();

            case ConstantsUtils.YCLCHUCHANG:
                waagListData = new Gson().fromJson(response, WaagListData.class);
                setWaagListView();

            case ConstantsUtils.SHEJIPEIHEBI:
                mDesignStrengthData = new Gson().fromJson(response, DesignStrengthData.class);
                setsjqdQueryView();
                break;
        }

    }

    private void setWaagListView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (WaagListData.DataBean temp : waagListData.getData()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }

        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_waagname.setAdapter(equipmentsAdapter);

        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_waagname.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }
    }

//    private void setMaterialListView() {
//        cailiaoName = new ArrayList<>();
//        cailiaoNo = new ArrayList<>();
//        for (MaterialListData.DataBean temp : materialListData.getData()) {
//            cailiaoName.add(temp.getCailiaoname());
//            cailiaoNo.add(temp.getCailiaono());
//        }
//
//        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cailiaoName);
//        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        ms_select_materialname.setAdapter(equipmentsAdapter);
//
//        for (int i = 0; i < cailiaoNo.size(); i++) {
//            if (mParametersData.cailiaono.equals(cailiaoNo.get(i))) {
//                ms_select_materialname.setSelection(i + 1);
//                Log.e("默认：" ,+ (i + 1) + "个");
//            }
//        }
//    }

    private void setBHZQueryView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (BHZEquipment.DataBean temp : mBHZEquipment.getData()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }

        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_equipment.setAdapter(equipmentsAdapter);

        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_equipment.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }
    }


    private void setStorageQueryView() {
        materialNames = new ArrayList<>();
        materialIDs = new ArrayList<>();
        for (StorageMaterialData.DataBean temp : mStorageMaterialData.getData()) {
            materialNames.add(temp.getCailiaoname());
            materialIDs.add(temp.getCailiaono());
        }
        Log.e(TAG,"materialNames=:" + materialNames);
        Log.e(TAG,"materialIDs=:" + materialIDs);
        ArrayAdapter<String> materialsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialNames);
        materialsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_material.setAdapter(materialsAdapter);
        Log.e(TAG, "-----setStorageQueryView----");
        for (int i = 0; i < materialIDs.size(); i++) {
            if (mParametersData.materialID.equals(materialIDs.get(i))) {
                ms_select_material.setSelection(i + 1);
                Log.e(TAG,"默认：" + (i + 1) + "个");
            }
        }
    }

    private void setStrengthQueryView() {
        strengthNames = new ArrayList<>();
        strengthIds = new ArrayList<>();
        for (DesignStrengthData.DataBean temp : mDesignStrengthData.getData()) {
            strengthNames.add(temp.getTypename());
            strengthIds.add(temp.getTypecode());
        }
        Log.e(TAG,"strengthNames=:" + strengthNames);
        Log.e(TAG,"strengthIds=:" + strengthIds);
        ArrayAdapter<String> strengthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strengthNames);
        strengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_strength.setAdapter(strengthAdapter);
        ms_select_strength.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i >= 0) {


                    mParametersData.sjqd = strengthIds.get(i);
                } else if (i == -1) {
                    mParametersData.sjqd = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Log.e(TAG, "-----setStrengthQueryView----");
        for (int i = 0; i < strengthIds.size(); i++) {
            if (mParametersData.materialID.equals(strengthIds.get(i))) {
                ms_select_material.setSelection(i + 1);
                Log.e(TAG,"默认：" + (i + 1) + "个");
            }
        }
    }

    private void setsjqdQueryView() {
        strengthNames = new ArrayList<>();
        strengthIds = new ArrayList<>();
        for (DesignStrengthData.DataBean temp : mDesignStrengthData.getData()) {
            strengthNames.add(temp.getTypename());
            strengthIds.add(temp.getTypecode());
        }
        Log.e(TAG,"strengthNames=:" + strengthNames);
        Log.e(TAG,"strengthIds=:" + strengthIds);
        ArrayAdapter<String> strengthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strengthNames);
        strengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_strength.setAdapter(strengthAdapter);
        ms_select_strength.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i >= 0) {


                    mParametersData.llsjqd = strengthIds.get(i);
                } else if (i == -1) {
                    mParametersData.llsjqd = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Log.e(TAG, "-----setStrengthQueryView----");
        for (int i = 0; i < strengthIds.size(); i++) {
            if (mParametersData.materialID.equals(strengthIds.get(i))) {
                ms_select_material.setSelection(i + 1);
                Log.e(TAG,"默认：" + (i + 1) + "个");
            }
        }
    }

    private void setWannengjiQueryView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.WnjsbBean temp : mEquipmentTestData.getData().getWnjsb()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }
        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_equipment.setAdapter(equipmentsAdapter);


        testTypeNames = new ArrayList<>();
        testTypeIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.WnjtpBean temp : mEquipmentTestData.getData().getWnjtp()) {
            testTypeNames.add(temp.getTestName());
            testTypeIDs.add(temp.getTestId());
        }
        ArrayAdapter<String> testTypessAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, testTypeNames);
        testTypessAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_test_type.setAdapter(testTypessAdapter);

        //根据传过来的参数对象来设置这些选择框该显示的内容
        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_equipment.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }

        for (int i = 0; i < testTypeIDs.size(); i++) {
            if (mParametersData.testTypeID.equals(testTypeIDs.get(i))) {
                ms_select_test_type.setSelection(i + 1);
            }
        }
    }

    private void setYalijiQueryView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.YljsbBean temp : mEquipmentTestData.getData().getYljsb()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }
        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_equipment.setAdapter(equipmentsAdapter);


        testTypeNames = new ArrayList<>();
        testTypeIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.YljtpBean temp : mEquipmentTestData.getData().getYljtp()) {
            testTypeNames.add(temp.getTestName());
            testTypeIDs.add(temp.getTestId());
        }
        ArrayAdapter<String> testTypessAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, testTypeNames);
        testTypessAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_test_type.setAdapter(testTypessAdapter);

        //根据传过来的参数对象来设置这些选择框该显示的内容
        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_equipment.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }

        KLog.e("mParametersData.testTypeID:" + mParametersData.testTypeID);
        for (int i = 0; i < testTypeIDs.size(); i++) {
            if (mParametersData.testTypeID.equals(testTypeIDs.get(i))) {
                KLog.e("111111111testTypeID：" + (i + 1) + "个");
                ms_select_test_type.setSelection(i + 1);
                KLog.e("22222222222testTypeID：" + (i + 1) + "个");
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_cancel_dialog:
                onBackPressed();
                break;

            case R.id.bt_search_dialog:
                String startTime = DateUtils.ChangeTimeToLong(start_date_time.getEditText().getText().toString());
                String endTime = DateUtils.ChangeTimeToLong(end_date_time.getEditText().getText().toString());
                mParametersData.keyword = ed_jzbw.getText().toString().trim();
                if (Integer.valueOf(startTime) <= Integer.valueOf(endTime)) {
                    BaseApplication.bus.post(mParametersData);
                    onBackPressed();
                } else {
                    end_date_time.setError("结束时间不能小于开始时间");
                    end_date_time.setErrorEnabled(true);
                }
                break;

            case R.id.tv_material_choose:
                Intent material = new Intent(this,MaterialListActivity.class);
                startActivityForResult(material,10);

                break;

            case R.id.tv_department_choose:
                Intent intent = new Intent(this, OrganizationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ConstantsUtils.DEPARTMENT, mDepartmentData);
                intent.putExtras(bundle);
                intent.putExtra("type", "1");
                startActivityForResult(intent,12);

                break;
        }
    }


    private void setStartDateTime() {
        isStartDateTime = true;
        showDatePicker();
    }

    private void setEndDateTime() {
        isStartDateTime = false;
        showDatePicker();
    }

    private void showDatePicker() {
        Calendar now = Calendar.getInstance();
        if (isStartDateTime) {
            now.add(Calendar.MONTH, -3);
        }
        DatePickerDialog dpd = DatePickerDialog.newInstance(this, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        dpd.vibrate(true);
        dpd.dismissOnPause(false);
        dpd.setAccentColor(Color.parseColor("#3F51B5"));
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    private void showTimePicker() {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(this, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);
        tpd.vibrate(true);
        tpd.dismissOnPause(false);
        tpd.setAccentColor(Color.parseColor("#3F51B5"));
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }

    private void revealView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fl_container.post(new Runnable() {
                @Override
                public void run() {

                    int cx = fl_container.getRight();
                    int cy = fl_container.getBottom();
                    int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, 0, radius);
                    mAnimator.setDuration(300);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.start();
                }
            });
        }
    }

    private void hideView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = fl_container.getRight();
            int cy = fl_container.getBottom();
            int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
            Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, radius, 0);
            mAnimator.setDuration(500);
            mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimator.addListener(new AnimatorListenerAdapter() {

                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    fl_container.setVisibility(View.INVISIBLE);
                    finish();
                }
            });
            mAnimator.start();
        } else {
            finish();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");

        if (tpd != null) tpd.setOnTimeSetListener(this);
        if (dpd != null) dpd.setOnDateSetListener(this);

        revealView();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String timeString = hourString + ":" + minuteString + ":" + secondString;
        if (isStartDateTime) {
            startDateTime = startDateTime + timeString;
            start_date_time.getEditText().setText(startDateTime);
            mParametersData.startDateTime = startDateTime;
        } else {
            endDateTime = endDateTime + timeString;
            end_date_time.getEditText().setText(endDateTime);
            mParametersData.endDateTime = endDateTime;
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String monthString = (++monthOfYear) < 10 ? "0" + (monthOfYear) : "" + (monthOfYear);
        String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
        String dateString = year + "-" + monthString + "-" + dayString + " ";
        if (isStartDateTime) {
            startDateTime = dateString;
        } else {
            endDateTime = dateString;
        }
        showTimePicker();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==10){

            if (resultCode==15){

                tv_MaterialName.setText(data.getExtras().getString("cailiaoname"));
                mParametersData.cailiaono=data.getExtras().getString("cailiaono");
                mParametersData.materialID = data.getExtras().getString("cailiaono");
                Log.e("tv_MaterialName",data.getStringExtra("cailiaoname"));

            }

        }else if (requestCode==12){
            if (resultCode==15){

                tv_DepartmentName.setText(data.getExtras().getString("departmentname"));
                mParametersData.userGroupID=data.getExtras().getString("departmentnno");
                Log.e("tv_DepartmentName",data.getStringExtra("departmentnno"));
            }
        }

    }

    @Override
    public void onBackPressed() {
        hideView();
    }

    @Override
    public String createRefreshULR() {
        return url;
    }

//    @Override
//    public String createLoadMoreULR() {
//        return url;
//    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}

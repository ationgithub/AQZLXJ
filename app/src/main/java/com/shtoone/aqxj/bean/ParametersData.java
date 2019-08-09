package com.shtoone.aqxj.bean;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by leguang on 2016/5/31 0031.
 * 请求参数实体类
 */
public class ParametersData implements Cloneable, Serializable {
    private static final String TAG = ParametersData.class.getSimpleName();
    public String startDateTime = "2015-03-01 00:00:00";
    public String endDateTime = "2016-06-01 00:00:00";
    public String userGroupID = "";
    public String deviceType = "";
    public String testTypeID = "";
    public String disposition = "";
    public String level = "";
    public String isQualified = "";
    public String equipmentID = "";
    public String alarmLevel = "";
    public String handleType = "";
    public String currentPage = "1";
    public String isReal = "";
    public String detailID = "";
    public int fromTo;
    public String materialID = "";
    public String maxPageItems = "10";
    public String cailiaomingcheng = "";
    public String strengthId = "";
    public String pici = "";
    public String cheliangbianhao = "";
    public String cailiaono = "";
    public String cailiaoname="";
    public String dataType = "0";
    public String states = "";
    public String parentno="";
    public String projectno = "";
    public String username = "";
    public String zhuangtai = "";
    public String unfinsh = "";
    public String finsh = "";
    public String sjqd = "";
    public String lq = "";
    public String sjzt = "";
    public String llsjqd = "";
    public String keyword = "";


    public ParametersData() {
        initParametersData();
    }

    private void initParametersData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Calendar rld = Calendar.getInstance();
        endDateTime = sdf.format(rld.getTime());
        rld.add(Calendar.MONTH, -1);
        startDateTime = sdf.format(rld.getTime());
    }

    //克隆
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ParametersData{" +
                "sjqd='" + sjqd + '\'' +
                ", lq='" + lq + '\'' +
                '}';
    }
}

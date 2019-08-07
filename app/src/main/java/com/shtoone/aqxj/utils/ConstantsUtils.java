package com.shtoone.aqxj.utils;

import com.shtoone.aqxj.BaseApplication;

import java.io.File;

public class ConstantsUtils {

    /**
     * 不允许new,EventBus注册
     */
    private ConstantsUtils() {
        throw new Error("Do not need instantiate!");
    }

    //    public static final String DOMAIN_1 = "shtoone.com";
    //    public static final String DOMAIN_2 = "sh-toone";
    public static final String DOMAIN_1 = "ccccltd.cn";
    public static final String DOMAIN_2 = "ccccltd";
    public static final String ISFIRSTENTRY = "isfirstentry";
    public static final String ISFIRSTGUIDE = "isfirstguide";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PARAMETERS = "parameters";
    public static final String USERGROUPID = "usergroupid";
    public static final String ABOUTWHAT = "aboutwhat";
    public static final String DEPARTMENT = "Department";
    public static final String SUCCESS = "success";
    public static final String ENCRYPT_KEY = "leguang";


    public static final String ABOUTAPP = "http://note.youdao.com/share/?id=37e5d8602c49af15d7589d7f91bd548b&type=note";
    public static final String ABOUTCOMPANY = "http://en.ccccltd.cn/ccccltd/";

    public static final int LABORATORYFRAGMENT = 0;
    public static final int YALIJIFRAGMENT = 1;
    public static final int WANNENGJIFRAGMENT = 2;
    public static final int CONCRETEFRAGMENT = 3;
    public static final int MATERIALSTATISTICFRAGMENT = 4;
    public static final int TESTSTATISTICFRAGMENT = 11;
    public static final int PRODUCEQUERYFRAGMENT = 5;
    public static final int OVERPROOFFRAGMENT = 6;
    public static final int WEIGHTHOUSEFRAGMENT = 7;
    public static final int PLAYPOUNDSQUERY = 8;
    public static final int ENTERPOUNDSQUERY = 9;

    public static final int STORAGEFRAGMENT = 8;

    public static final int CAMERA = 1;
    public static final int ALBUM = 2;
    public static final int REFRESH = 11;
    public static final int YALIJIFABHIDE = 12;
    public static final int YALIJIFABSHOW = 13;
    public static final int WANNENGJIFABHIDE = 14;
    public static final int WANNENGJIFABSHOW = 15;
    public static final int OVERPROOFFABHIDE = 17;
    public static final int OVERPROOFFABSHOW = 16;
    public static final int NOTIFY_REFRESH = 22;
    public static final int MATERIALCONSUME = 23;
    public static final int PEILIAOTONGZHIDAN = 24;
    public static final int TASKLISTIMPQUERYFRAGMENT = 25;
    public static final int SHEJIPEIHEBI = 26;

    public static final int YCLJINCHANG = 37;
    public static final int YCLCHUCHANG = 38;
    public static final int WZPROGRESS = 39;
    public static final int ENGINEERINGHOME = 40;

    public static final int JOBORDERUNFINSH = 43;
    public static final int JOBORDERFINSH = 44;

    public static final int JOBORDERUNSUBMIT = 45;
    public static final int JOBORDERUNCOMPOUNDING = 46;
    public static final int JOBORDERCOMPOUNDING = 47;
    public static final int POURPOSITION = 48;

    public static final int PIC1 = 51;
    public static final int PIC2 = 52;
    public static final int PIC3 = 53;
    public static final int PIC4 = 54;
    public static final int SHUINI = 55;

    public static final int PEICHANGERED = 56;
    public static final int RENCHANGERED = 57;


    //SD卡路径
    public static final String PATH_DATA = DirectoryUtils.getDiskCacheDirectory(BaseApplication.context, "data").getAbsolutePath();
    public static final String PATH_NET_CACHE = PATH_DATA + File.separator + "NetCache";
}

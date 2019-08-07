package com.shtoone.aqxj.common;

import com.shtoone.aqxj.bean.YangpinDemoData;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ApiService {

    //登录验证
//    @POST("app.do?appLogin")
//    Call<UserInfoBean> login(@Query("account") String account, @Query("userPwd") String userPwd, @Query("OSType") String OSType, @Query("machineCode") String machineCode, @Query("phoneBrand") String phoneBrand, @Query("phoneSysVersion") String phoneSysVersion, @Query("phoneModel") String phoneModel);
//    //更新检测
//    @GET("app.do?checkUpdate")
//    Call<CheckUpdateBean> checkUpdate();

//    @GET("app.do?ysszxsDownload")
//    Observable<YusheshuizhunxianInfoBean> yusheshuizhunxianInfoDownload(@Query("departId") String departId);

    //下载基点信息
//    @GET("app.do?gzjdsDownload")
//    Observable<JidianBean> jidianDownload();

    //下载人员信息
//    @GET("app.do?wyguancerenyuan2")
//    Observable<StaffBean> staffDownload();
//    //上传断面信息
////    @POST("app.do?originalDataUpload")
////    Call<ResponseBody> upload(@Query("original") String duanmianBeen);
//    @POST("app.do?duanmianxiazhai")
//    Call<ResponseBody> sendDuanmianCall(@Body List<DuanmianData> sendCallData);
////  上传测点
//    @POST("app.do?celiangshujuxiazhai")
//    Call<ResponseBody> sendCedianCall(@Body List<CedianDuanmianData> cdd);
//    //  上传断面status,封存断面
//    @POST("app.do?fengcun")
//    Call<ResponseBody> sendStatusCall(@Query("duanmianId") String duanmianId);
//    //下载工点下所有断面统计信息,导出月报，周报
//    @GET("app.do?gongdingdaochu")
//    Observable<GongdianDaochu> duanmiantaDownload(@Query("gongDianId") String gongDianId, @Query("state") String state, @Query("cediantype") String cediantype);
//    //下载测点的预警相关参数，围岩测量数据
//    @GET("app.do?wyceliangvalue")
//    Observable<WarnInfo> cedianWarn(@Query("cedianid") String cedianid);
//    //围岩处置列表下载
//    @GET("app.do?wybaojing")
//    Observable<BaojingInfo> cedianWarnDo();

    // 围岩处置保存
    @POST("app.do?wybaojing")
    Call<ResponseBody> doSaveCall(@Query("id") String id, @Query("user") String user, @Query("process") String process);

    //  @Part("ContactInformation")String conInfo,
    @Multipart
    @POST("appWZTaiZhang.do?yangpingAdd")
    Call<ResponseBody> feedBack(@Part("data") YangpinDemoData Content, @Part() List<MultipartBody.Part> parts);

//    @POST("")
//    Flowable<UploadImgBean> upload(@Body RequestBody Body);
//    // 历史数据查询
//    @GET("app.do?lishishujuchaxun")
//    Observable<CeliangDataBean> historyCedian(@Query("cedianid") String cedianid, @Query("cediantype") String cediantype);
}

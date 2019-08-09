package com.shtoone.aqxj.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */
public class StorageQueryDetailActivityData {


    /**
     * deatilData : [{"baojing":"1","baojingname":"test","baojingphone":"18671729428","cailiaoguid":"003001","cailiaoname":"河砂(中砂)","chushi":"600.00","chushiliang":600000,"createdatetime":"2016-11-29 10:55:34","createperson":"shtoone","departid":"8a8ab0b246dc81120146dc8180ba0017","departname":"广西交通工程质量安全质监站","guid":"289f7f01-d57a-487c-bc21-0dad0caadc1a","id":8,"isdel":"","jin":"","jingjiezhi":20000,"jinliang":0,"kucun":0,"lilun":"","lilunchuliang":0,"orgCode":"A01","result":"810.00","shiji":"","shijichuliang":0,"status":"","ts":"1499912636656","xiuzheng":"210.00","xiuzhengliang":210000}]
     * success : true
     * xiuZhengMsg : []
     */

    private boolean success;
    private List<DeatilDataBean> deatilData;
    private List<XiuzhengBean> xiuZhengMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DeatilDataBean> getDeatilData() {
        return deatilData;
    }

    public void setDeatilData(List<DeatilDataBean> deatilData) {
        this.deatilData = deatilData;
    }

    public List<XiuzhengBean> getXiuZhengMsg() {
        return xiuZhengMsg;
    }

    public void setXiuZhengMsg(List<XiuzhengBean> xiuZhengMsg) {
        this.xiuZhengMsg = xiuZhengMsg;
    }

    public static class DeatilDataBean {
        /**
         * baojing : 1
         * baojingname : test
         * baojingphone : 18671729428
         * cailiaoguid : 003001
         * cailiaoname : 河砂(中砂)
         * chushi : 600.00
         * chushiliang : 600000
         * createdatetime : 2016-11-29 10:55:34
         * createperson : shtoone
         * departid : 8a8ab0b246dc81120146dc8180ba0017
         * departname : 广西交通工程质量安全质监站
         * guid : 289f7f01-d57a-487c-bc21-0dad0caadc1a
         * id : 8
         * isdel :
         * jin :
         * jingjiezhi : 20000
         * jinliang : 0
         * kucun : 0
         * lilun :
         * lilunchuliang : 0
         * orgCode : A01
         * result : 810.00
         * shiji :
         * shijichuliang : 0
         * status :
         * ts : 1499912636656
         * xiuzheng : 210.00
         * xiuzhengliang : 210000
         */

        private String baojing;
        private String baojingname;
        private String baojingphone;
        private String cailiaoguid;
        private String cailiaoname;
        private String chushi;
        private int chushiliang;
        private String createdatetime;
        private String createperson;
        private String departid;
        private String departname;
        private String guid;
        private int id;
        private String isdel;
        private String jin;
        private double jingjiezhi;
        private String jinliang;
        private double kucun;
        private String lilun;
        private float lilunchuliang;
        private String orgCode;
        private String result;
        private String shiji;

        private float shijichuliang;
        private String status;
        private String ts;
        private String xiuzheng;
        private int xiuzhengliang;

        public float getLilunchuliang() {
            return lilunchuliang;
        }
        public void setLilunchuliang(float lilunchuliang) {
            this.lilunchuliang = lilunchuliang;
        }
        public String getBaojing() {
            return baojing;
        }

        public void setBaojing(String baojing) {
            this.baojing = baojing;
        }

        public String getBaojingname() {
            return baojingname;
        }

        public void setBaojingname(String baojingname) {
            this.baojingname = baojingname;
        }

        public String getBaojingphone() {
            return baojingphone;
        }

        public void setBaojingphone(String baojingphone) {
            this.baojingphone = baojingphone;
        }

        public String getCailiaoguid() {
            return cailiaoguid;
        }

        public void setCailiaoguid(String cailiaoguid) {
            this.cailiaoguid = cailiaoguid;
        }

        public String getCailiaoname() {
            return cailiaoname;
        }

        public void setCailiaoname(String cailiaoname) {
            this.cailiaoname = cailiaoname;
        }

        public String getChushi() {
            return chushi;
        }

        public void setChushi(String chushi) {
            this.chushi = chushi;
        }

        public int getChushiliang() {
            return chushiliang;
        }

        public void setChushiliang(int chushiliang) {
            this.chushiliang = chushiliang;
        }

        public String getCreatedatetime() {
            return createdatetime;
        }

        public void setCreatedatetime(String createdatetime) {
            this.createdatetime = createdatetime;
        }

        public String getCreateperson() {
            return createperson;
        }

        public void setCreateperson(String createperson) {
            this.createperson = createperson;
        }

        public String getDepartid() {
            return departid;
        }

        public void setDepartid(String departid) {
            this.departid = departid;
        }

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIsdel() {
            return isdel;
        }

        public void setIsdel(String isdel) {
            this.isdel = isdel;
        }

        public String getJin() {
            return jin;
        }

        public void setJin(String jin) {
            this.jin = jin;
        }

        public double getJingjiezhi() {
            return jingjiezhi;
        }

        public void setJingjiezhi(double jingjiezhi) {
            this.jingjiezhi = jingjiezhi;
        }

        public String getJinliang() {
            return jinliang;
        }

        public void setJinliang(String jinliang) {
            this.jinliang = jinliang;
        }

        public double getKucun() {
            return kucun;
        }

        public void setKucun(double kucun) {
            this.kucun = kucun;
        }

        public String getLilun() {
            return lilun;
        }

        public void setLilun(String lilun) {
            this.lilun = lilun;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getShiji() {
            return shiji;
        }

        public void setShiji(String shiji) {
            this.shiji = shiji;
        }

        public float getShijichuliang() {
            return shijichuliang;
        }

        public void setShijichuliang(float shijichuliang) {
            this.shijichuliang = shijichuliang;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public String getXiuzheng() {
            return xiuzheng;
        }

        public void setXiuzheng(String xiuzheng) {
            this.xiuzheng = xiuzheng;
        }

        public int getXiuzhengliang() {
            return xiuzhengliang;
        }

        public void setXiuzhengliang(int xiuzhengliang) {
            this.xiuzhengliang = xiuzhengliang;
        }
    }

    public static class XiuzhengBean{

        private String remark;
        private String createperson;
        private String createdatetime;
        private BigDecimal xiuzhengzhi;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreateperson() {
            return createperson;
        }

        public void setCreateperson(String createperson) {
            this.createperson = createperson;
        }

        public String getCreatedatetime() {
            return createdatetime;
        }

        public void setCreatedatetime(String createdatetime) {
            this.createdatetime = createdatetime;
        }

        public BigDecimal getXiuzhengzhi() {
            return xiuzhengzhi;
        }

        public void setXiuzhengzhi(BigDecimal xiuzhengzhi) {
            this.xiuzhengzhi = xiuzhengzhi;
        }
    }
}

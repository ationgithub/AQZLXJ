package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class StorageFragmentListData {


    /**
     * data : [{"baojing":"1","cailiaoguid":"003001","cailiaoname":"河砂(中砂)","cbdengji":0,"chushi":600,"chushiliang":600000,"createDatetime":"2016-11-29 10:55:34","createperson":"shtoone","departId":"8a8ab0b246dc81120146dc8180ba0017","departname":"广西交通工程质量安全质监站","id":8,"jingjiezhi":20000,"result":810,"xiuzheng":210,"xiuzhengliang":210000},{"baojing":"1","cailiaoguid":"002001","cailiaoname":"碎石(5-16mm)","cbdengji":0,"chushi":400,"chushiliang":400000,"createDatetime":"2017-07-11 16:57:55","createperson":"shtoone","departId":"8a8ab0b246dc81120146dc8180ba0017","departname":"广西交通工程质量安全质监站","id":9,"jingjiezhi":100000,"result":700,"xiuzheng":300,"xiuzhengliang":300000}]
     * success : true
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * baojing : 1
         * cailiaoguid : 003001
         * cailiaoname : 河砂(中砂)
         * cbdengji : 0
         * chushi : 600
         * chushiliang : 600000
         * createDatetime : 2016-11-29 10:55:34
         * createperson : shtoone
         * departId : 8a8ab0b246dc81120146dc8180ba0017
         * departname : 广西交通工程质量安全质监站
         * id : 8
         * jingjiezhi : 20000
         * result : 810
         * xiuzheng : 210
         * xiuzhengliang : 210000
         */

        private String baojing;
        private String cailiaoguid;
        private String cailiaoname;
        private int cbdengji;
        private String chushi;
        private int chushiliang;
        private String createDatetime;
        private String createperson;
        private String departId;
        private String departname;
        private String id;
        private String jingjiezhi;
        private String result;
        private String xiuzheng;
        private String LiaoCangname;
        private int xiuzhengliang;

        public String getLiaoCangname() {
            return LiaoCangname;
        }

        public void setLiaoCangname(String liaoCangname) {
            LiaoCangname = liaoCangname;
        }

        public String getBaojing() {
            return baojing;
        }

        public void setBaojing(String baojing) {
            this.baojing = baojing;
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

        public int getCbdengji() {
            return cbdengji;
        }

        public void setCbdengji(int cbdengji) {
            this.cbdengji = cbdengji;
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

        public String getCreateDatetime() {
            return createDatetime;
        }

        public void setCreateDatetime(String createDatetime) {
            this.createDatetime = createDatetime;
        }

        public String getCreateperson() {
            return createperson;
        }

        public void setCreateperson(String createperson) {
            this.createperson = createperson;
        }

        public String getDepartId() {
            return departId;
        }

        public void setDepartId(String departId) {
            this.departId = departId;
        }

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJingjiezhi() {
            return jingjiezhi;
        }

        public void setJingjiezhi(String jingjiezhi) {
            this.jingjiezhi = jingjiezhi;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
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
}

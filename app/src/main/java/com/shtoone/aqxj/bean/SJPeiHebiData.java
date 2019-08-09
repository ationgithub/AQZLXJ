package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */

public class SJPeiHebiData {


    /**
     * data : [{"id":"10023","departname":"广西交通工程质量安全质监站","shuijiaobi":"","createdatetime":"2017-08-14 16:09:06","sjqd":"C15","llphbno":"test13","zhuangtai":"0"},{"id":"10016","departname":"广西交通工程质量安全质监站","shuijiaobi":"0.20","createdatetime":"2017-07-22 14:30:22","sjqd":"C15","llphbno":"1333","zhuangtai":"0"},{"id":"10021","departname":"广西交通工程质量安全质监站","shuijiaobi":"","createdatetime":"2017-08-14 14:58:49","sjqd":"C15","llphbno":"12333","zhuangtai":"-1"},{"id":"10015","departname":"广西交通工程质量安全质监站","shuijiaobi":"0.33","createdatetime":"2017-07-21 17:03:02","sjqd":"C15","llphbno":"123","zhuangtai":"-1"},{"id":"10010","departname":"广西交通工程质量安全质监站","shuijiaobi":"","createdatetime":"2017-07-19 10:32:09","sjqd":"C15","llphbno":"23","zhuangtai":"-1"},{"id":"10008","departname":"广西交通工程质量安全质监站","shuijiaobi":"0.33","createdatetime":"2017-07-19 10:30:25","sjqd":"C15","llphbno":"132","zhuangtai":"-1"}]
     * success : true
     */

    private boolean success;
    private List<DataEntity> data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity implements Serializable{
        /**
         * id : 10023
         * departname : 广西交通工程质量安全质监站
         * shuijiaobi :
         * createdatetime : 2017-08-14 16:09:06
         * sjqd : C15
         * llphbno : test13
         * zhuangtai : 0
         */

        private String id;
        private String departname;
        private String shuijiaobi;
        private String createdatetime;
        private String sjqd;
        private String llphbno;
        private String zhuangtai;

        public void setId(String id) {
            this.id = id;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public void setShuijiaobi(String shuijiaobi) {
            this.shuijiaobi = shuijiaobi;
        }

        public void setCreatedatetime(String createdatetime) {
            this.createdatetime = createdatetime;
        }

        public void setSjqd(String sjqd) {
            this.sjqd = sjqd;
        }

        public void setLlphbno(String llphbno) {
            this.llphbno = llphbno;
        }

        public void setZhuangtai(String zhuangtai) {
            this.zhuangtai = zhuangtai;
        }

        public String getId() {
            return id;
        }

        public String getDepartname() {
            return departname;
        }

        public String getShuijiaobi() {
            return shuijiaobi;
        }

        public String getCreatedatetime() {
            return createdatetime;
        }

        public String getSjqd() {
            return sjqd;
        }

        public String getLlphbno() {
            return llphbno;
        }

        public String getZhuangtai() {
            return zhuangtai;
        }
    }
}

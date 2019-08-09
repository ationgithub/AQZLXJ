package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class PeiliaoTongzhidanVerifyFragmentListData {


    /**
     * data : [{"renwuNo":"手机app测试数据","createDateTime":"2018-09-27 16:44:24","departname":"15号拌和站","llphbNo":"18TL-04111","jzbw":"螺杆桩DK124+301.47-303.47","shihaofangliang":"","jihuafangliang":"22","state":"0","sjqd":"C30水下","sgphbNo":"ce-01"}]
     * success : true
     */

    private boolean success;
    private List<DataEntity> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity implements Serializable{
        /**
         * renwuNo : 手机app测试数据
         * createDateTime : 2018-09-27 16:44:24
         * departname : 15号拌和站
         * llphbNo : 18TL-04111
         * jzbw : 螺杆桩DK124+301.47-303.47
         * shihaofangliang :
         * jihuafangliang : 22
         * state : 0
         * sjqd : C30水下
         * sgphbNo : ce-01
         */

        private String renwuNo;
        private String createDateTime;
        private String departname;
        private String llphbNo;
        private String jzbw;
        private String shihaofangliang;
        private String jihuafangliang;
        private String state;
        private String sjqd;
        private String sgphbNo;
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRenwuNo() {
            return renwuNo;
        }

        public void setRenwuNo(String renwuNo) {
            this.renwuNo = renwuNo;
        }

        public String getCreateDateTime() {
            return createDateTime;
        }

        public void setCreateDateTime(String createDateTime) {
            this.createDateTime = createDateTime;
        }

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getLlphbNo() {
            return llphbNo;
        }

        public void setLlphbNo(String llphbNo) {
            this.llphbNo = llphbNo;
        }

        public String getJzbw() {
            return jzbw;
        }

        public void setJzbw(String jzbw) {
            this.jzbw = jzbw;
        }

        public String getShihaofangliang() {
            return shihaofangliang;
        }

        public void setShihaofangliang(String shihaofangliang) {
            this.shihaofangliang = shihaofangliang;
        }

        public String getJihuafangliang() {
            return jihuafangliang;
        }

        public void setJihuafangliang(String jihuafangliang) {
            this.jihuafangliang = jihuafangliang;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getSjqd() {
            return sjqd;
        }

        public void setSjqd(String sjqd) {
            this.sjqd = sjqd;
        }

        public String getSgphbNo() {
            return sgphbNo;
        }

        public void setSgphbNo(String sgphbNo) {
            this.sgphbNo = sgphbNo;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "renwuNo='" + renwuNo + '\'' +
                    ", createDateTime='" + createDateTime + '\'' +
                    ", departname='" + departname + '\'' +
                    ", llphbNo='" + llphbNo + '\'' +
                    ", jzbw='" + jzbw + '\'' +
                    ", shihaofangliang='" + shihaofangliang + '\'' +
                    ", jihuafangliang='" + jihuafangliang + '\'' +
                    ", state='" + state + '\'' +
                    ", sjqd='" + sjqd + '\'' +
                    ", sgphbNo='" + sgphbNo + '\'' +
                    '}';
        }
    }


}

package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class PeiliaoTongzhidanFragmentListData {


    /**
     * data : [{"createDateTime":"2017-07-14 11:26:38","departname":"广西交通工程质量安全质监站","jihuafangliang":"23.88","jzbw":"K10+400～K10+425右侧25米","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-01","renwuNo":"3123","sgphbNo":"13333","shihaofangliang":"","sjqd":"C20"},{"createDateTime":"2017-07-14 11:28:58","departname":"广西交通工程质量安全质监站","jihuafangliang":"23.88","jzbw":"K10+400～K10+425右侧25米","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-02","renwuNo":"3123","sgphbNo":"231231","shihaofangliang":"","sjqd":"C40"},{"createDateTime":"2017-07-13 16:10:28","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"213","renwuNo":"23131","sgphbNo":"23","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:12:57","departname":"梧柳高速","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"11111","renwuNo":"23131","sgphbNo":"32","shihaofangliang":"","sjqd":"C15"},{"createDateTime":"2017-07-13 16:26:45","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-01","renwuNo":"23131","sgphbNo":"13","shihaofangliang":"","sjqd":"C20"},{"createDateTime":"2017-07-13 15:29:29","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"1","renwuNo":"23131","sgphbNo":"3123","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:36:02","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"213","renwuNo":"23131","sgphbNo":"3213","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:36:44","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"213","renwuNo":"23131","sgphbNo":"1323","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:38:54","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"SHZQ15-ZTSJ0-PHB20160522-02","renwuNo":"23131","sgphbNo":"123321","shihaofangliang":"","sjqd":""},{"createDateTime":"2017-07-12 10:59:08","departname":"广西交通工程质量安全质监站","jihuafangliang":"41","jzbw":"171-4#桩基","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-01","renwuNo":"20170228-7","sgphbNo":"test123","shihaofangliang":"1","sjqd":"C20"}]
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

    public static class DataBean implements Serializable{
        /**
         * createDateTime : 2017-07-14 11:26:38
         * departname : 广西交通工程质量安全质监站
         * jihuafangliang : 23.88
         * jzbw : K10+400～K10+425右侧25米
         * llphbNo : SHZQ15-ZTSJ1-PHB20161128-01
         * renwuNo : 3123
         * sgphbNo : 13333
         * shihaofangliang :
         * sjqd : C20
         */

        private String createDateTime;
        private String departname;
        private String jihuafangliang;
        private String jzbw;
        private String llphbNo;
        private String renwuNo;
        private String sgphbNo;
        private String shihaofangliang;
        private String sjqd;

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

        public String getJihuafangliang() {
            return jihuafangliang;
        }

        public void setJihuafangliang(String jihuafangliang) {
            this.jihuafangliang = jihuafangliang;
        }

        public String getJzbw() {
            return jzbw;
        }

        public void setJzbw(String jzbw) {
            this.jzbw = jzbw;
        }

        public String getLlphbNo() {
            return llphbNo;
        }

        public void setLlphbNo(String llphbNo) {
            this.llphbNo = llphbNo;
        }

        public String getRenwuNo() {
            return renwuNo;
        }

        public void setRenwuNo(String renwuNo) {
            this.renwuNo = renwuNo;
        }

        public String getSgphbNo() {
            return sgphbNo;
        }

        public void setSgphbNo(String sgphbNo) {
            this.sgphbNo = sgphbNo;
        }

        public String getShihaofangliang() {
            return shihaofangliang;
        }

        public void setShihaofangliang(String shihaofangliang) {
            this.shihaofangliang = shihaofangliang;
        }

        public String getSjqd() {
            return sjqd;
        }

        public void setSjqd(String sjqd) {
            this.sjqd = sjqd;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "createDateTime='" + createDateTime + '\'' +
                    ", departname='" + departname + '\'' +
                    ", jihuafangliang='" + jihuafangliang + '\'' +
                    ", jzbw='" + jzbw + '\'' +
                    ", llphbNo='" + llphbNo + '\'' +
                    ", renwuNo='" + renwuNo + '\'' +
                    ", sgphbNo='" + sgphbNo + '\'' +
                    ", shihaofangliang='" + shihaofangliang + '\'' +
                    ", sjqd='" + sjqd + '\'' +
                    '}';
        }
    }
}

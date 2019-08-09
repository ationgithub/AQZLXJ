package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by liangfeng on 2017/10/9.
 */

public class TJFXData {

    /**
     * data : [{"isrCount":"41","nsrCount":"0","notijiaoCount":"0","isshengchancount":"18","shengchaningCount":"27","userGroupId":"8a8ab0b246dc81120146dc8180ba0017"}]
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

    public static class DataBean {
        /**
         * isrCount : 41
         * nsrCount : 0
         * notijiaoCount : 0
         * isshengchancount : 18
         * shengchaningCount : 27
         * userGroupId : 8a8ab0b246dc81120146dc8180ba0017
         */

        private String isrCount;
        private String nsrCount;
        private String notijiaoCount;
        private String isshengchancount;
        private String shengchaningCount;
        private String userGroupId;
        private String noshenhe;

        public String getNoshenhe() {
            return noshenhe;
        }

        public void setNoshenhe(String noshenhe) {
            this.noshenhe = noshenhe;
        }

        public String getIsrCount() {
            return isrCount;
        }

        public void setIsrCount(String isrCount) {
            this.isrCount = isrCount;
        }

        public String getNsrCount() {
            return nsrCount;
        }

        public void setNsrCount(String nsrCount) {
            this.nsrCount = nsrCount;
        }

        public String getNotijiaoCount() {
            return notijiaoCount;
        }

        public void setNotijiaoCount(String notijiaoCount) {
            this.notijiaoCount = notijiaoCount;
        }

        public String getIsshengchancount() {
            return isshengchancount;
        }

        public void setIsshengchancount(String isshengchancount) {
            this.isshengchancount = isshengchancount;
        }

        public String getShengchaningCount() {
            return shengchaningCount;
        }

        public void setShengchaningCount(String shengchaningCount) {
            this.shengchaningCount = shengchaningCount;
        }

        public String getUserGroupId() {
            return userGroupId;
        }

        public void setUserGroupId(String userGroupId) {
            this.userGroupId = userGroupId;
        }
    }
}

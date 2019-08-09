package com.shtoone.aqxj.bean;


import java.util.List;

/**
 * 用户实体类
 * Created by leguang on 2016/5/11 0031.
 */
public class UserInfoData {

    /**
     * SMSGroup : []
     * departId : 8a8ab0b246dc81120146dc8180ba0017
     * departName : 广西交通工程质量安全质监站
     * quanxian : {"WZBHZ":true,"WZGCB":true,"WZSYS":true}
     * success : true
     * type : GL
     * updateDepartTime : 2016-07-23 13:41:36
     * userFullName : 上海同望
     * userPhoneNum :
     * userRole : 1
     * xmmc : 项目APP
     */

    private String departId;
    private String departName;
    private QuanxianBean quanxian;
    private boolean success;
    private String type;
    private String updateDepartTime;
    private String userFullName;
    private String userPhoneNum;
    private String userRole;
    private String xmmc;
    private List<?> SMSGroup;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public QuanxianBean getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(QuanxianBean quanxian) {
        this.quanxian = quanxian;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateDepartTime() {
        return updateDepartTime;
    }

    public void setUpdateDepartTime(String updateDepartTime) {
        this.updateDepartTime = updateDepartTime;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public List<?> getSMSGroup() {
        return SMSGroup;
    }

    public void setSMSGroup(List<?> SMSGroup) {
        this.SMSGroup = SMSGroup;
    }

    public static class QuanxianBean {
        /**
         * WZBHZ : true
         * WZGCB : true
         * WZSYS : true
         */

        private boolean WZBHZ;
        private boolean WZGCB;
        private boolean WZSYS;
        private boolean WZTJ;
        private boolean WZPBSH;
        private boolean WZRWDSH;

        public boolean isWZRWDSH() {
            return WZRWDSH;
        }

        public void setWZRWDSH(boolean WZRWDSH) {
            this.WZRWDSH = WZRWDSH;
        }

        public boolean isWZPBSH() {
            return WZPBSH;
        }

        public void setWZPBSH(boolean WZPBSH) {
            this.WZPBSH = WZPBSH;
        }

        public boolean isWZTJ() {
            return WZTJ;
        }

        public void setWZTJ(boolean WZTJ) {
            this.WZTJ = WZTJ;
        }

        public boolean isWZBHZ() {
            return WZBHZ;
        }

        public void setWZBHZ(boolean WZBHZ) {
            this.WZBHZ = WZBHZ;
        }

        public boolean isWZGCB() {
            return WZGCB;
        }

        public void setWZGCB(boolean WZGCB) {
            this.WZGCB = WZGCB;
        }

        public boolean isWZSYS() {
            return WZSYS;
        }

        public void setWZSYS(boolean WZSYS) {
            this.WZSYS = WZSYS;
        }
    }
}

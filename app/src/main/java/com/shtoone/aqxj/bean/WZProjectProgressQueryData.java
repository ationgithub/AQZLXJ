package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class WZProjectProgressQueryData {


    /**
     * data : [{"tempRowNumber":1,"id":1241,"shijifangliang":425,"jindu":0.37,"shejifangliang":116022.13,"remark":null,"parentNo":null,"projectType":0,"projectName":"路基工程","tempColumn":0,"projectNo":"001"},{"tempRowNumber":2,"id":1857,"shijifangliang":null,"jindu":0,"shejifangliang":null,"remark":null,"parentNo":null,"projectType":0,"projectName":"test","tempColumn":0,"projectNo":"002"},{"tempRowNumber":3,"id":1858,"shijifangliang":null,"jindu":0,"shejifangliang":null,"remark":null,"parentNo":null,"projectType":0,"projectName":"asda","tempColumn":0,"projectNo":"003"}]
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

    public static class DataEntity {
        /**
         * tempRowNumber : 1
         * id : 1241
         * shijifangliang : 425
         * jindu : 0.37
         * shejifangliang : 116022.13
         * remark : null
         * parentNo : null
         * projectType : 0
         * projectName : 路基工程
         * tempColumn : 0
         * projectNo : 001
         */

        private int tempRowNumber;
        private int    id;
        private double    shijifangliang;
        private double jindu;
        private double shejifangliang;
        private Object remark;
        private Object parentNo;
        private int    projectType;
        private String projectName;
        private int    tempColumn;
        private String projectNo;

        public void setTempRowNumber(int tempRowNumber) {
            this.tempRowNumber = tempRowNumber;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setShijifangliang(double shijifangliang) {
            this.shijifangliang = shijifangliang;
        }

        public void setJindu(double jindu) {
            this.jindu = jindu;
        }

        public void setShejifangliang(double shejifangliang) {
            this.shejifangliang = shejifangliang;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public void setParentNo(Object parentNo) {
            this.parentNo = parentNo;
        }

        public void setProjectType(int projectType) {
            this.projectType = projectType;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setTempColumn(int tempColumn) {
            this.tempColumn = tempColumn;
        }

        public void setProjectNo(String projectNo) {
            this.projectNo = projectNo;
        }

        public int getTempRowNumber() {
            return tempRowNumber;
        }

        public int getId() {
            return id;
        }

        public double getShijifangliang() {
            return shijifangliang;
        }

        public double getJindu() {
            return jindu;
        }

        public double getShejifangliang() {
            return shejifangliang;
        }

        public Object getRemark() {
            return remark;
        }

        public Object getParentNo() {
            return parentNo;
        }

        public int getProjectType() {
            return projectType;
        }

        public String getProjectName() {
            return projectName;
        }

        public int getTempColumn() {
            return tempColumn;
        }

        public String getProjectNo() {
            return projectNo;
        }
    }
}

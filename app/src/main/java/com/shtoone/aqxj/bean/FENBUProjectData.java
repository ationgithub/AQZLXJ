package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class FENBUProjectData {


    /**
     * data : [{"parentNo":"001001001","projectName":"K10+400～K10+425右侧25米","projectNo":"001001001001"},{"parentNo":"001001001","projectName":"K10+630～K10+860右侧230米","projectNo":"001001001002"},{"parentNo":"001001003","projectName":"K10+630～K10+860右侧266米","projectNo":"001001003001"},{"parentNo":"001001003","projectName":"K10+670～K10+850右侧261米","projectNo":"001001003002"},{"parentNo":"001001002","projectName":"K10+425～K10+500右侧90米","projectNo":"001001002001"},{"parentNo":"001001002","projectName":"K10+860～K11+000右侧151米","projectNo":"001001002002"},{"parentNo":"001001","projectName":"边沟","projectNo":"001001001"},{"parentNo":"001001","projectName":"截水沟","projectNo":"001001003"},{"parentNo":"001001","projectName":"排水沟","projectNo":"001001002"},{"parentNo":"001","projectName":"排水工程","projectNo":"001001"},{"parentNo":null,"projectName":"分部分项","projectNo":null},{"parentNo":null,"projectName":"路基工程","projectNo":"001"}]
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
         * parentNo : 001001001
         * projectName : K10+400～K10+425右侧25米
         * projectNo : 001001001001
         */

        private String parentNo;
        private String projectName;
        private String projectNo;

        public void setParentNo(String parentNo) {
            this.parentNo = parentNo;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setProjectNo(String projectNo) {
            this.projectNo = projectNo;
        }

        public String getParentNo() {
            return parentNo;
        }

        public String getProjectName() {
            return projectName;
        }

        public String getProjectNo() {
            return projectNo;
        }
    }
}

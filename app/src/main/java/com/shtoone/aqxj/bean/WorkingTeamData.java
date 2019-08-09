package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

public class WorkingTeamData {


    /**
     * data : [{"id":"1","departname":"广西交通工程质量安全质监站","name":"施工队1","org_code":"A01","departId":"8a8ab0b246dc81120146dc8180ba0017"},{"id":"2","departname":"梧柳高速","name":"施工队311","org_code":"A01A01","departId":"402880fa5bb1f5bb015bb1fa23e70002"}]
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
         * id : 1
         * departname : 广西交通工程质量安全质监站
         * name : 施工队1
         * org_code : A01
         * departId : 8a8ab0b246dc81120146dc8180ba0017
         */

        private String id;
        private String departname;
        private String name;
        private String org_code;
        private String departId;

        public void setId(String id) {
            this.id = id;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOrg_code(String org_code) {
            this.org_code = org_code;
        }

        public void setDepartId(String departId) {
            this.departId = departId;
        }

        public String getId() {
            return id;
        }

        public String getDepartname() {
            return departname;
        }

        public String getName() {
            return name;
        }

        public String getOrg_code() {
            return org_code;
        }

        public String getDepartId() {
            return departId;
        }
    }
}

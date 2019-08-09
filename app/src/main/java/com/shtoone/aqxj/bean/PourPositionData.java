package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class PourPositionData {


    /**
     * data : [{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K10+400～K10+425右侧25米","bjiedian":"边沟","shejifangliang":"37.87","id":"1244","shejiqiangdu":"M7.5","treeguid":"8EFDEBB0-FB32-4F59-922D-A9179057096A"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K10+630～K10+860右侧230米","bjiedian":"边沟","shejifangliang":"219.65","id":"1245","shejiqiangdu":"M7.5","treeguid":"749CD598-0A4B-4BDE-96D7-76D45C8FD2A3"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K11+040～K11+150左侧110米","bjiedian":"边沟","shejifangliang":"105.05","id":"1246","shejiqiangdu":"M7.5","treeguid":"3F9835CA-F65F-47C2-AD18-B4A56256976D"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K11+000～K11+180右侧180米","bjiedian":"边沟","shejifangliang":"171.9","id":"1247","shejiqiangdu":"M7.5","treeguid":"C8272E56-922F-42D6-9B58-ED1988AF9925"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K11+420～K11+540右侧120米","bjiedian":"边沟","shejifangliang":"114.6","id":"1248","shejiqiangdu":"M7.5","treeguid":"6B28CEC0-9107-4318-A7AE-A07531499B3E"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K11+640～K11+670左侧30米","bjiedian":"边沟","shejifangliang":"28.65","id":"1249","shejiqiangdu":"M7.5","treeguid":"4E52D641-30D5-461F-B3BC-A6D683EA28B4"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K11+670～K11+850右侧180米","bjiedian":"边沟","shejifangliang":"171.9","id":"1250","shejiqiangdu":"M7.5","treeguid":"076B4BE3-0067-4B1E-A478-015DCFB9CB18"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K11+970～K12+110右侧140米","bjiedian":"边沟","shejifangliang":"133.7","id":"1251","shejiqiangdu":"M7.5","treeguid":"A9C2C89E-2A06-4438-9EA4-33037FC05C28"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K12+000～K12+090左侧90米","bjiedian":"边沟","shejifangliang":"85.95","id":"1252","shejiqiangdu":"M7.5","treeguid":"B7FD8827-6A05-40B1-B729-20C2920F54BC"},{"zjiedian":"路基工程","yjiedian":"排水工程","projectname":"K12+210～K12+400右侧190米","bjiedian":"边沟","shejifangliang":"181.45","id":"1253","shejiqiangdu":"M7.5","treeguid":"868C3D92-A523-4475-B8C2-FD2DC78CB1CE"}]
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
         * zjiedian : 路基工程
         * yjiedian : 排水工程
         * projectname : K10+400～K10+425右侧25米
         * bjiedian : 边沟
         * shejifangliang : 37.87
         * id : 1244
         * shejiqiangdu : M7.5
         * treeguid : 8EFDEBB0-FB32-4F59-922D-A9179057096A
         */

        private String zjiedian;
        private String yjiedian;
        private String projectname;
        private String bjiedian;
        private String shejifangliang;
        private String id;
        private String shejiqiangdu;
        private String treeguid;

        public String getZjiedian() {
            return zjiedian;
        }

        public void setZjiedian(String zjiedian) {
            this.zjiedian = zjiedian;
        }

        public String getYjiedian() {
            return yjiedian;
        }

        public void setYjiedian(String yjiedian) {
            this.yjiedian = yjiedian;
        }

        public String getProjectname() {
            return projectname;
        }

        public void setProjectname(String projectname) {
            this.projectname = projectname;
        }

        public String getBjiedian() {
            return bjiedian;
        }

        public void setBjiedian(String bjiedian) {
            this.bjiedian = bjiedian;
        }

        public String getShejifangliang() {
            return shejifangliang;
        }

        public void setShejifangliang(String shejifangliang) {
            this.shejifangliang = shejifangliang;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShejiqiangdu() {
            return shejiqiangdu;
        }

        public void setShejiqiangdu(String shejiqiangdu) {
            this.shejiqiangdu = shejiqiangdu;
        }

        public String getTreeguid() {
            return treeguid;
        }

        public void setTreeguid(String treeguid) {
            this.treeguid = treeguid;
        }
    }
}

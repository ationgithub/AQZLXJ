package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
public class TaskListEditActivityData {


    /**
     * data : [{"departname":"广西交通工程质量安全质监站","departid":"8a8ab0b246dc81120146dc8180ba0017","jzbw":"K10+400～K10+425右侧25米","jiaozhufangshi":"自卸","tanluodu":"30-50mm","remark":"","jihuafangliang":"37.87","kangdongdengji":"","kangshendengji":"","shuinibiaohao":"","org_code":"A01","createperson":"shtoone","kaipanriqi":"","treeguid":"8EFDEBB0-FB32-4F59-922D-A9179057096A","createtime":"2017-07-14 17:20:42","id":90780,"shijifangliang":"","sgphbguid":"","gcmc":"路基工程","renwuno":"045"}]
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
         * departname : 广西交通工程质量安全质监站
         * departid : 8a8ab0b246dc81120146dc8180ba0017
         * jzbw : K10+400～K10+425右侧25米
         * jiaozhufangshi : 自卸
         * tanluodu : 30-50mm
         * remark :
         * jihuafangliang : 37.87
         * kangdongdengji :
         * kangshendengji :
         * shuinibiaohao :
         * org_code : A01
         * createperson : shtoone
         * kaipanriqi :
         * treeguid : 8EFDEBB0-FB32-4F59-922D-A9179057096A
         * createtime : 2017-07-14 17:20:42
         * id : 90780
         * shijifangliang :
         * sgphbguid :
         * gcmc : 路基工程
         * renwuno : 045
         */

        private String departname;
        private String departid;
        private String jzbw;
        private String jiaozhufangshi;
        private String tanluodu;
        private String remark;
        private String jihuafangliang;
        private String kangdongdengji;
        private String kangshendengji;
        private String shuinibiaohao;
        private String org_code;
        private String createperson;
        private String kaipanriqi;
        private String treeguid;
        private String createtime;
        private String id;
        private String shijifangliang;
        private String sgphbguid;
        private String gcmc;
        private String renwuno;
        private String shigongteamname;
        private String shigongteamid;
        private String guid;

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getShigongteamid() {
            return shigongteamid;
        }

        public void setShigongteamid(String shigongteamid) {
            this.shigongteamid = shigongteamid;
        }

        public String getShigongteamname() {
            return shigongteamname;
        }

        public void setShigongteamname(String shigongteamname) {
            this.shigongteamname = shigongteamname;
        }



        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getDepartid() {
            return departid;
        }

        public void setDepartid(String departid) {
            this.departid = departid;
        }

        public String getJzbw() {
            return jzbw;
        }

        public void setJzbw(String jzbw) {
            this.jzbw = jzbw;
        }

        public String getJiaozhufangshi() {
            return jiaozhufangshi;
        }

        public void setJiaozhufangshi(String jiaozhufangshi) {
            this.jiaozhufangshi = jiaozhufangshi;
        }

        public String getTanluodu() {
            return tanluodu;
        }

        public void setTanluodu(String tanluodu) {
            this.tanluodu = tanluodu;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getJihuafangliang() {
            return jihuafangliang;
        }

        public void setJihuafangliang(String jihuafangliang) {
            this.jihuafangliang = jihuafangliang;
        }

        public String getKangdongdengji() {
            return kangdongdengji;
        }

        public void setKangdongdengji(String kangdongdengji) {
            this.kangdongdengji = kangdongdengji;
        }

        public String getKangshendengji() {
            return kangshendengji;
        }

        public void setKangshendengji(String kangshendengji) {
            this.kangshendengji = kangshendengji;
        }

        public String getShuinibiaohao() {
            return shuinibiaohao;
        }

        public void setShuinibiaohao(String shuinibiaohao) {
            this.shuinibiaohao = shuinibiaohao;
        }

        public String getOrg_code() {
            return org_code;
        }

        public void setOrg_code(String org_code) {
            this.org_code = org_code;
        }

        public String getCreateperson() {
            return createperson;
        }

        public void setCreateperson(String createperson) {
            this.createperson = createperson;
        }

        public String getKaipanriqi() {
            return kaipanriqi;
        }

        public void setKaipanriqi(String kaipanriqi) {
            this.kaipanriqi = kaipanriqi;
        }

        public String getTreeguid() {
            return treeguid;
        }

        public void setTreeguid(String treeguid) {
            this.treeguid = treeguid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShijifangliang() {
            return shijifangliang;
        }

        public void setShijifangliang(String shijifangliang) {
            this.shijifangliang = shijifangliang;
        }

        public String getSgphbguid() {
            return sgphbguid;
        }

        public void setSgphbguid(String sgphbguid) {
            this.sgphbguid = sgphbguid;
        }

        public String getGcmc() {
            return gcmc;
        }

        public void setGcmc(String gcmc) {
            this.gcmc = gcmc;
        }

        public String getRenwuno() {
            return renwuno;
        }

        public void setRenwuno(String renwuno) {
            this.renwuno = renwuno;
        }
    }
}

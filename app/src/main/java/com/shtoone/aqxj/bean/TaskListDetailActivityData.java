package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
public class TaskListDetailActivityData {


    /**
     * JCXXData : {"departName":"广西交通工程质量安全质监站","gcmc":"路基工程","jiaozhufangshi":"车泵","jihuafangliang":"181.45","jzbw":"K12+210～K12+400右侧190米","kaipanriqi":"2017-07-14","renwuno":"1","shuinibiaohao":"C15"}
     * XGJLData : []
     * ZXQKData : {"baifenbi":"13.23","jiechao":"157.45","jihuafangliang":"181.45","shijifangliang":"24.0","shijipanshu":""}
     * ZYJLData : [{"caozuozhe":"shtoone","fangliang":"10","id":7,"renwuno1":"3123","renwuno2":"1","shijian":"2017-07-14 16:52:18","type":"1"},{"caozuozhe":"shtoone","fangliang":"10","id":6,"renwuno1":"3123","renwuno2":"1","shijian":"2017-07-14 16:50:13","type":"1"}]
     * success : true
     */

    private JCXXDataBean JCXXData;
    private ZXQKDataBean ZXQKData;
    private boolean success;
    private List<XGJLDataBean> XGJLData;
    private List<ZYJLDataBean> ZYJLData;

    public JCXXDataBean getJCXXData() {
        return JCXXData;
    }

    public void setJCXXData(JCXXDataBean JCXXData) {
        this.JCXXData = JCXXData;
    }

    public ZXQKDataBean getZXQKData() {
        return ZXQKData;
    }

    public void setZXQKData(ZXQKDataBean ZXQKData) {
        this.ZXQKData = ZXQKData;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<XGJLDataBean> getXGJLData() {
        return XGJLData;
    }

    public void setXGJLData(List<XGJLDataBean> XGJLData) {
        this.XGJLData = XGJLData;
    }

    public List<ZYJLDataBean> getZYJLData() {
        return ZYJLData;
    }

    public void setZYJLData(List<ZYJLDataBean> ZYJLData) {
        this.ZYJLData = ZYJLData;
    }

    public static class JCXXDataBean {
        /**
         * departName : 广西交通工程质量安全质监站
         * gcmc : 路基工程
         * jiaozhufangshi : 车泵
         * jihuafangliang : 181.45
         * jzbw : K12+210～K12+400右侧190米
         * kaipanriqi : 2017-07-14
         * renwuno : 1
         * shuinibiaohao : C15
         */

        private String departName;
        private String gcmc;
        private String jiaozhufangshi;
        private String jihuafangliang;
        private String jzbw;
        private String kaipanriqi;
        private String renwuno;
        private String shuinibiaohao;

        public String getDepartName() {
            return departName;
        }

        public void setDepartName(String departName) {
            this.departName = departName;
        }

        public String getGcmc() {
            return gcmc;
        }

        public void setGcmc(String gcmc) {
            this.gcmc = gcmc;
        }

        public String getJiaozhufangshi() {
            return jiaozhufangshi;
        }

        public void setJiaozhufangshi(String jiaozhufangshi) {
            this.jiaozhufangshi = jiaozhufangshi;
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

        public String getKaipanriqi() {
            return kaipanriqi;
        }

        public void setKaipanriqi(String kaipanriqi) {
            this.kaipanriqi = kaipanriqi;
        }

        public String getRenwuno() {
            return renwuno;
        }

        public void setRenwuno(String renwuno) {
            this.renwuno = renwuno;
        }

        public String getShuinibiaohao() {
            return shuinibiaohao;
        }

        public void setShuinibiaohao(String shuinibiaohao) {
            this.shuinibiaohao = shuinibiaohao;
        }
    }

    public static class ZXQKDataBean {
        /**
         * baifenbi : 13.23
         * jiechao : 157.45
         * jihuafangliang : 181.45
         * shijifangliang : 24.0
         * shijipanshu :
         */

        private String baifenbi;
        private String jiechao;
        private String jihuafangliang;
        private String shijifangliang;
        private String shijipanshu;

        public String getBaifenbi() {
            return baifenbi;
        }

        public void setBaifenbi(String baifenbi) {
            this.baifenbi = baifenbi;
        }

        public String getJiechao() {
            return jiechao;
        }

        public void setJiechao(String jiechao) {
            this.jiechao = jiechao;
        }

        public String getJihuafangliang() {
            return jihuafangliang;
        }

        public void setJihuafangliang(String jihuafangliang) {
            this.jihuafangliang = jihuafangliang;
        }

        public String getShijifangliang() {
            return shijifangliang;
        }

        public void setShijifangliang(String shijifangliang) {
            this.shijifangliang = shijifangliang;
        }

        public String getShijipanshu() {
            return shijipanshu;
        }

        public void setShijipanshu(String shijipanshu) {
            this.shijipanshu = shijipanshu;
        }
    }

    public static class XGJLDataBean{

        private String renwuno;
        private String xiugairen;
        private String xiugaishijian;
        private String type;

        public String getRenwuno() {
            return renwuno;
        }

        public void setRenwuno(String renwuno) {
            this.renwuno = renwuno;
        }

        public String getXiugairen() {
            return xiugairen;
        }

        public void setXiugairen(String xiugairen) {
            this.xiugairen = xiugairen;
        }

        public String getXiugaishijian() {
            return xiugaishijian;
        }

        public void setXiugaishijian(String xiugaishijian) {
            this.xiugaishijian = xiugaishijian;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ZYJLDataBean {
        /**
         * caozuozhe : shtoone
         * fangliang : 10
         * id : 7
         * renwuno1 : 3123
         * renwuno2 : 1
         * shijian : 2017-07-14 16:52:18
         * type : 1
         */

        private String caozuozhe;
        private String fangliang;
        private int id;
        private String renwuno1;
        private String renwuno2;
        private String shijian;
        private String type;

        public String getCaozuozhe() {
            return caozuozhe;
        }

        public void setCaozuozhe(String caozuozhe) {
            this.caozuozhe = caozuozhe;
        }

        public String getFangliang() {
            return fangliang;
        }

        public void setFangliang(String fangliang) {
            this.fangliang = fangliang;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRenwuno1() {
            return renwuno1;
        }

        public void setRenwuno1(String renwuno1) {
            this.renwuno1 = renwuno1;
        }

        public String getRenwuno2() {
            return renwuno2;
        }

        public void setRenwuno2(String renwuno2) {
            this.renwuno2 = renwuno2;
        }

        public String getShijian() {
            return shijian;
        }

        public void setShijian(String shijian) {
            this.shijian = shijian;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

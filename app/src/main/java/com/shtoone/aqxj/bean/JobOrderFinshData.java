package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */

public class JobOrderFinshData {


    /**
     * data : [{"id":"90777","baifenbi":"100.00","shijifangliang":"216.00","jzbw":"K10+400～K10+425右侧25米","gcmc":"路基工程","jihuafangliang":"23.88","jiechao":"-192.12","sgphbno":"13333","shuinibiaohao":"C15","kaipanriqi":"2017-07-11","zhuangtai":"2","renwuno":"3123"},{"id":"90777","baifenbi":"100.00","shijifangliang":"216.00","jzbw":"K10+400～K10+425右侧25米","gcmc":"路基工程","jihuafangliang":"23.88","jiechao":"-192.12","sgphbno":"231231","shuinibiaohao":"C15","kaipanriqi":"2017-07-11","zhuangtai":"2","renwuno":"3123"},{"id":"90773","baifenbi":"100.00","shijifangliang":"6.00","shejifangliang":"","jzbw":"dDdDd2","gcmc":"测试11111","jihuafangliang":"2.12122","jiechao":"-3.88","sgphbno":"未配料","shuinibiaohao":"","kaipanriqi":"2017-07-13","zhuangtai":"2","renwuno":"23213"},{"id":"10029","baifenbi":"100.00","shijifangliang":"100.00","shejifangliang":"","jzbw":"171-4#桩基","gcmc":"裕溪河特大桥","jihuafangliang":"41","jiechao":"-59.00","sgphbno":"123312","shuinibiaohao":"C30水下","kaipanriqi":"2017-07-07","zhuangtai":"2","renwuno":"20170228-7"},{"id":"10029","baifenbi":"100.00","shijifangliang":"100.00","shejifangliang":"","jzbw":"171-4#桩基","gcmc":"裕溪河特大桥","jihuafangliang":"41","jiechao":"-59.00","sgphbno":"test123","shuinibiaohao":"C30水下","kaipanriqi":"2017-07-07","zhuangtai":"2","renwuno":"20170228-7"},{"id":"10029","baifenbi":"100.00","shijifangliang":"100.00","shejifangliang":"","jzbw":"171-4#桩基","gcmc":"裕溪河特大桥","jihuafangliang":"41","jiechao":"-59.00","sgphbno":"1234","shuinibiaohao":"C30水下","kaipanriqi":"2017-07-07","zhuangtai":"2","renwuno":"20170228-7"},{"id":"10029","baifenbi":"100.00","shijifangliang":"100.00","shejifangliang":"","jzbw":"171-4#桩基","gcmc":"裕溪河特大桥","jihuafangliang":"41","jiechao":"-59.00","sgphbno":"123456","shuinibiaohao":"C30水下","kaipanriqi":"2017-07-07","zhuangtai":"2","renwuno":"20170228-7"},{"id":"10029","baifenbi":"100.00","shijifangliang":"100.00","shejifangliang":"","jzbw":"171-4#桩基","gcmc":"裕溪河特大桥","jihuafangliang":"41","jiechao":"-59.00","sgphbno":"132333","shuinibiaohao":"C30水下","kaipanriqi":"2017-07-07","zhuangtai":"2","renwuno":"20170228-7"}]
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
         * id : 90777
         * baifenbi : 100.00
         * shijifangliang : 216.00
         * jzbw : K10+400～K10+425右侧25米
         * gcmc : 路基工程
         * jihuafangliang : 23.88
         * jiechao : -192.12
         * sgphbno : 13333
         * shuinibiaohao : C15
         * kaipanriqi : 2017-07-11
         * zhuangtai : 2
         * renwuno : 3123
         */

        private String id;
        private String baifenbi;
        private String shijifangliang;
        private String jzbw;
        private String gcmc;
        private String jihuafangliang;
        private String jiechao;
        private String sgphbno;
        private String shuinibiaohao;
        private String kaipanriqi;
        private String zhuangtai;
        private String renwuno;
        private String shejifangliang;

        public String getShejifangliang() {
            return shejifangliang;
        }

        public void setShejifangliang(String shejifangliang) {
            this.shejifangliang = shejifangliang;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setBaifenbi(String baifenbi) {
            this.baifenbi = baifenbi;
        }

        public void setShijifangliang(String shijifangliang) {
            this.shijifangliang = shijifangliang;
        }

        public void setJzbw(String jzbw) {
            this.jzbw = jzbw;
        }

        public void setGcmc(String gcmc) {
            this.gcmc = gcmc;
        }

        public void setJihuafangliang(String jihuafangliang) {
            this.jihuafangliang = jihuafangliang;
        }

        public void setJiechao(String jiechao) {
            this.jiechao = jiechao;
        }

        public void setSgphbno(String sgphbno) {
            this.sgphbno = sgphbno;
        }

        public void setShuinibiaohao(String shuinibiaohao) {
            this.shuinibiaohao = shuinibiaohao;
        }

        public void setKaipanriqi(String kaipanriqi) {
            this.kaipanriqi = kaipanriqi;
        }

        public void setZhuangtai(String zhuangtai) {
            this.zhuangtai = zhuangtai;
        }

        public void setRenwuno(String renwuno) {
            this.renwuno = renwuno;
        }

        public String getId() {
            return id;
        }

        public String getBaifenbi() {
            return baifenbi;
        }

        public String getShijifangliang() {
            return shijifangliang;
        }

        public String getJzbw() {
            return jzbw;
        }

        public String getGcmc() {
            return gcmc;
        }

        public String getJihuafangliang() {
            return jihuafangliang;
        }

        public String getJiechao() {
            return jiechao;
        }

        public String getSgphbno() {
            return sgphbno;
        }

        public String getShuinibiaohao() {
            return shuinibiaohao;
        }

        public String getKaipanriqi() {
            return kaipanriqi;
        }

        public String getZhuangtai() {
            return zhuangtai;
        }

        public String getRenwuno() {
            return renwuno;
        }
    }
}

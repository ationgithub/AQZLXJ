package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

public class PlayPoundsListData {


    /**
     * data : [{"id":"30036","maozhong":"50.64","jinchangshijian":"2017-06-14 15:31:44","sibangyuan":"董振鹏","jingzhong":"34.16","gongyingshangname":"安徽祥实商贸有限公司","guobangleibie":"1","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-06-14 15:42:52","qianchepai":"皖LA4996","cailiaoname":"碎石(16-31.5mm)"},{"id":"30035","maozhong":"0.00","jinchangshijian":"2017-06-02 17:21:18","sibangyuan":"董振鹏","jingzhong":"","gongyingshangname":"全椒润尧商贸有限公司","guobangleibie":"1","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-06-02 17:21:43","qianchepai":"皖LA4996","cailiaoname":"河砂(中砂)"},{"id":"30034","maozhong":"56.26","jinchangshijian":"2017-06-02 16:03:51","sibangyuan":"董振鹏","jingzhong":"39.94","gongyingshangname":"安徽祥实商贸有限公司","guobangleibie":"1","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-06-02 16:21:27","qianchepai":"皖LA4996","cailiaoname":"碎石(16-31.5mm)"},{"id":"10030","maozhong":"0.00","jinchangshijian":"2017-05-02 14:08:26","sibangyuan":"董振鹏","jingzhong":"","gongyingshangname":"四川恒泽建材有限公司","guobangleibie":"0","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-05-02 14:08:43","qianchepai":"皖B16236","cailiaoname":"减水剂"},{"id":"29","maozhong":"9.62","jinchangshijian":"2017-04-26 08:47:44","sibangyuan":"董振鹏","jingzhong":"6.24","gongyingshangname":"四川恒泽建材有限公司","guobangleibie":"0","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-04-26 09:58:08","qianchepai":"皖BY8582","cailiaoname":"减水剂"},{"id":"25","maozhong":"19.64","jinchangshijian":"2017-03-18 14:23:17","sibangyuan":"董振鹏","jingzhong":"3.70","gongyingshangname":"全椒润尧商贸有限公司","guobangleibie":"1","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-03-18 14:30:56","qianchepai":"001","cailiaoname":"河砂(中砂)"},{"id":"23","maozhong":"48.10","jinchangshijian":"2017-03-17 14:01:45","sibangyuan":"董振鹏","jingzhong":"34.26","gongyingshangname":"安徽祥实商贸有限公司","guobangleibie":"0","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-03-17 14:18:47","qianchepai":"皖A85433","cailiaoname":"碎石(16-31.5mm)"},{"id":"24","maozhong":"51.00","jinchangshijian":"2017-03-17 14:00:19","sibangyuan":"董振鹏","jingzhong":"37.04","gongyingshangname":"安徽祥实商贸有限公司","guobangleibie":"0","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-03-17 14:11:05","qianchepai":"皖A85499","cailiaoname":"碎石(16-31.5mm)"},{"id":"22","maozhong":"0.00","jinchangshijian":"2017-03-17 13:42:29","sibangyuan":"董振鹏","jingzhong":"","gongyingshangname":"安徽祥实商贸有限公司","guobangleibie":"0","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-03-17 13:42:43","qianchepai":"皖C33925","cailiaoname":"碎石(16-31.5mm)"},{"id":"21","maozhong":"0.00","jinchangshijian":"2017-03-17 13:41:41","sibangyuan":"董振鹏","jingzhong":"","gongyingshangname":"四川恒泽建材有限公司","guobangleibie":"0","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-03-17 13:41:57","qianchepai":"asfdsf","cailiaoname":"碎石(16-31.5mm)"}]
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

    public static class DataEntity implements Serializable{
        /**
         * id : 30036
         * maozhong : 50.64
         * jinchangshijian : 2017-06-14 15:31:44
         * sibangyuan : 董振鹏
         * jingzhong : 34.16
         * gongyingshangname : 安徽祥实商贸有限公司
         * guobangleibie : 1
         * banhezhanminchen : 1号拌合站地磅
         * chuchangshijian : 2017-06-14 15:42:52
         * qianchepai : 皖LA4996
         * cailiaoname : 碎石(16-31.5mm)
         */

        private String id;
        private String maozhong;
        private String jinchangshijian;
        private String sibangyuan;
        private String jingzhong;
        private String gongyingshangname;
        private String guobangleibie;
        private String banhezhanminchen;
        private String chuchangshijian;
        private String qianchepai;
        private String cailiaoname;

        public void setId(String id) {
            this.id = id;
        }

        public void setMaozhong(String maozhong) {
            this.maozhong = maozhong;
        }

        public void setJinchangshijian(String jinchangshijian) {
            this.jinchangshijian = jinchangshijian;
        }

        public void setSibangyuan(String sibangyuan) {
            this.sibangyuan = sibangyuan;
        }

        public void setJingzhong(String jingzhong) {
            this.jingzhong = jingzhong;
        }

        public void setGongyingshangname(String gongyingshangname) {
            this.gongyingshangname = gongyingshangname;
        }

        public void setGuobangleibie(String guobangleibie) {
            this.guobangleibie = guobangleibie;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public void setChuchangshijian(String chuchangshijian) {
            this.chuchangshijian = chuchangshijian;
        }

        public void setQianchepai(String qianchepai) {
            this.qianchepai = qianchepai;
        }

        public void setCailiaoname(String cailiaoname) {
            this.cailiaoname = cailiaoname;
        }

        public String getId() {
            return id;
        }

        public String getMaozhong() {
            return maozhong;
        }

        public String getJinchangshijian() {
            return jinchangshijian;
        }

        public String getSibangyuan() {
            return sibangyuan;
        }

        public String getJingzhong() {
            return jingzhong;
        }

        public String getGongyingshangname() {
            return gongyingshangname;
        }

        public String getGuobangleibie() {
            return guobangleibie;
        }

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public String getChuchangshijian() {
            return chuchangshijian;
        }

        public String getQianchepai() {
            return qianchepai;
        }

        public String getCailiaoname() {
            return cailiaoname;
        }
    }
}

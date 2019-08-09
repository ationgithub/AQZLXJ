package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

public class EnterPoundsListData {


    /**
     * data : [{"id":"184812","maozhong":"74.64","jinchangshijian":"2017-07-24 23:59:51","sibangyuan":"董振鹏","jingzhong":"53.02","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:05:08","qianchepai":"皖B15619","cailiaoname":"碎石(16-31.5mm)"},{"id":"184856","maozhong":"55.40","jinchangshijian":"2017-07-24 23:59:37","sibangyuan":"董振鹏","jingzhong":"40.94","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:10:01","qianchepai":"皖A85963","cailiaoname":"碎石(16-31.5mm)"},{"id":"101920","maozhong":"53.94","jinchangshijian":"2017-07-24 23:59:10","sibangyuan":"董振鹏","jingzhong":"39.30","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:10:17","qianchepai":"皖A85479","cailiaoname":"碎石(16-31.5mm)"},{"id":"164276","maozhong":"60.62","jinchangshijian":"2017-07-24 23:58:55","sibangyuan":"董振鹏","jingzhong":"42.30","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:03:19","qianchepai":"皖SA0475","cailiaoname":"碎石(16-31.5mm)"},{"id":"267","maozhong":"98.08","jinchangshijian":"2017-07-24 23:58:19","sibangyuan":"刘铁敏","jingzhong":"74.63","gongyingshangname":"全椒润尧商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:17:44","qianchepai":"皖A82355","cailiaoname":"河砂(中砂)"},{"id":"174735","maozhong":"63.04","jinchangshijian":"2017-07-24 23:57:46","sibangyuan":"董振鹏","jingzhong":"47.06","gongyingshangname":"全椒润尧商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:03:16","qianchepai":"皖A85485","cailiaoname":"河砂(中砂)"},{"id":"144019","maozhong":"67.38","jinchangshijian":"2017-07-24 23:57:16","sibangyuan":"董振鹏","jingzhong":"46.51","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:04:03","qianchepai":"皖A81842","cailiaoname":"碎石(16-31.5mm)"},{"id":"102085","maozhong":"53.60","jinchangshijian":"2017-07-23 23:57:09","sibangyuan":"董振鹏","jingzhong":"38.67","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:06:22","qianchepai":"皖D76405","cailiaoname":"碎石(16-31.5mm)"},{"id":"184855","maozhong":"55.92","jinchangshijian":"2017-07-23 23:56:24","sibangyuan":"董振鹏","jingzhong":"40.94","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:07:35","qianchepai":"皖A85189","cailiaoname":"碎石(16-31.5mm)"},{"id":"144018","maozhong":"70.68","jinchangshijian":"2017-07-23 23:55:57","sibangyuan":"董振鹏","jingzhong":"49.12","gongyingshangname":"安徽祥实商贸有限公司","banhezhanminchen":"1号拌合站地磅","chuchangshijian":"2017-07-24 00:02:16","qianchepai":"皖B15619","cailiaoname":"碎石(16-31.5mm)"}]
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
         * id : 184812
         * maozhong : 74.64
         * jinchangshijian : 2017-07-24 23:59:51
         * sibangyuan : 董振鹏
         * jingzhong : 53.02
         * gongyingshangname : 安徽祥实商贸有限公司
         * banhezhanminchen : 1号拌合站地磅
         * chuchangshijian : 2017-07-24 00:05:08
         * qianchepai : 皖B15619
         * cailiaoname : 碎石(16-31.5mm)
         */

        private String serialNo;
        private String pici;
        private String LCname;
        private String id;
        private String maozhong;
        private String jinchangshijian;
        private String sibangyuan;
        private String jingzhong;
        private String gongyingshangname;
        private String banhezhanminchen;
        private String chuchangshijian;
        private String qianchepai;
        private String cailiaoname;

        public String getSerialNo() {
            return serialNo;
        }
        public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
        }
        public String getPici() {
            return pici;
        }
        public void setPici(String pici) {
            this.pici = pici;
        }
        public String getLCname() {
            return LCname;
        }
        public void setLCname(String LCname) {
            this.LCname = LCname;
        }
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

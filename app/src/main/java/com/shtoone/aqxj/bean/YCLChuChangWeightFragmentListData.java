package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class YCLChuChangWeightFragmentListData {


    /**
     * data : [{"cailiaoName":"碎石(16-31.5mm)","maozhong":50.64,"jingzhong":34.16,"ccmin":"2017-06-14","pici":null,"gongyingshangdanweibianma":"feaec4e3-8338-4592-9656-22402384952f","cailiaoNo":"002002","shebeibianhao":"TJ1B1db","pizhong":15.78,"tempRowNumber":1,"id":1,"jcmax":"2017-06-14","guobangleibie":"1","datetype":"2季度","banhezhanminchen":"1号拌合站地磅","gongyingshangName":"安徽祥实商贸有限公司","tempColumn":0,"jcmin":"2017-06-14","ccmax":"2017-06-14"}]
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

    public static class DataEntity implements Serializable {
        /**
         * cailiaoName : 碎石(16-31.5mm)
         * maozhong : 50.64
         * jingzhong : 34.16
         * ccmin : 2017-06-14
         * pici : null
         * gongyingshangdanweibianma : feaec4e3-8338-4592-9656-22402384952f
         * cailiaoNo : 002002
         * shebeibianhao : TJ1B1db
         * pizhong : 15.78
         * tempRowNumber : 1
         * id : 1
         * jcmax : 2017-06-14
         * guobangleibie : 1
         * datetype : 2季度
         * banhezhanminchen : 1号拌合站地磅
         * gongyingshangName : 安徽祥实商贸有限公司
         * tempColumn : 0
         * jcmin : 2017-06-14
         * ccmax : 2017-06-14
         */

        private String cailiaoName;
        private double maozhong;
        private double jingzhong;
        private String ccmin;
        private Object pici;
        private String gongyingshangdanweibianma;
        private String cailiaoNo;
        private String shebeibianhao;
        private double pizhong;
        private int    tempRowNumber;
        private int    id;
        private String jcmax;
        private String guobangleibie;
        private String datetype;
        private String banhezhanminchen;
        private String gongyingshangName;
        private int    tempColumn;
        private String jcmin;
        private String ccmax;

        public void setCailiaoName(String cailiaoName) {
            this.cailiaoName = cailiaoName;
        }

        public void setMaozhong(double maozhong) {
            this.maozhong = maozhong;
        }

        public void setJingzhong(double jingzhong) {
            this.jingzhong = jingzhong;
        }

        public void setCcmin(String ccmin) {
            this.ccmin = ccmin;
        }

        public void setPici(Object pici) {
            this.pici = pici;
        }

        public void setGongyingshangdanweibianma(String gongyingshangdanweibianma) {
            this.gongyingshangdanweibianma = gongyingshangdanweibianma;
        }

        public void setCailiaoNo(String cailiaoNo) {
            this.cailiaoNo = cailiaoNo;
        }

        public void setShebeibianhao(String shebeibianhao) {
            this.shebeibianhao = shebeibianhao;
        }

        public void setPizhong(double pizhong) {
            this.pizhong = pizhong;
        }

        public void setTempRowNumber(int tempRowNumber) {
            this.tempRowNumber = tempRowNumber;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setJcmax(String jcmax) {
            this.jcmax = jcmax;
        }

        public void setGuobangleibie(String guobangleibie) {
            this.guobangleibie = guobangleibie;
        }

        public void setDatetype(String datetype) {
            this.datetype = datetype;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public void setGongyingshangName(String gongyingshangName) {
            this.gongyingshangName = gongyingshangName;
        }

        public void setTempColumn(int tempColumn) {
            this.tempColumn = tempColumn;
        }

        public void setJcmin(String jcmin) {
            this.jcmin = jcmin;
        }

        public void setCcmax(String ccmax) {
            this.ccmax = ccmax;
        }

        public String getCailiaoName() {
            return cailiaoName;
        }

        public double getMaozhong() {
            return maozhong;
        }

        public double getJingzhong() {
            return jingzhong;
        }

        public String getCcmin() {
            return ccmin;
        }

        public Object getPici() {
            return pici;
        }

        public String getGongyingshangdanweibianma() {
            return gongyingshangdanweibianma;
        }

        public String getCailiaoNo() {
            return cailiaoNo;
        }

        public String getShebeibianhao() {
            return shebeibianhao;
        }

        public double getPizhong() {
            return pizhong;
        }

        public int getTempRowNumber() {
            return tempRowNumber;
        }

        public int getId() {
            return id;
        }

        public String getJcmax() {
            return jcmax;
        }

        public String getGuobangleibie() {
            return guobangleibie;
        }

        public String getDatetype() {
            return datetype;
        }

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public String getGongyingshangName() {
            return gongyingshangName;
        }

        public int getTempColumn() {
            return tempColumn;
        }

        public String getJcmin() {
            return jcmin;
        }

        public String getCcmax() {
            return ccmax;
        }
    }
}

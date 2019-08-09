package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class YCLJinChangWeightFragmentListData {


    /**
     * data : [{"cailiaoName":"河砂(中砂)","maozhong":65.9,"jingzhong":49.53,"ccmin":"2017-07-04","pici":null,"gongyingshangdanweibianma":"b785dea1-1aa2-402d-9e8c-c799d891979b","cailiaoNo":"003001","shebeibianhao":"TJ1B1db","pizhong":14.84,"tempRowNumber":1,"id":1,"jcmax":"2017-07-04","jinchuliaodanNo":"20170704210353","datetype":"3季度","banhezhanminchen":"1号拌合站地磅","gongyingshangName":"全椒润尧商贸有限公司","tempColumn":0,"jcmin":"2017-07-04","ccmax":"2017-07-04"}]
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
         * cailiaoName : 河砂(中砂)
         * maozhong : 65.9
         * jingzhong : 49.53
         * ccmin : 2017-07-04
         * pici : null
         * gongyingshangdanweibianma : b785dea1-1aa2-402d-9e8c-c799d891979b
         * cailiaoNo : 003001
         * shebeibianhao : TJ1B1db
         * pizhong : 14.84
         * tempRowNumber : 1
         * id : 1
         * jcmax : 2017-07-04
         * jinchuliaodanNo : 20170704210353
         * datetype : 3季度
         * banhezhanminchen : 1号拌合站地磅
         * gongyingshangName : 全椒润尧商贸有限公司
         * tempColumn : 0
         * jcmin : 2017-07-04
         * ccmax : 2017-07-04
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
        private String jinchuliaodanNo;
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

        public void setJinchuliaodanNo(String jinchuliaodanNo) {
            this.jinchuliaodanNo = jinchuliaodanNo;
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

        public String getJinchuliaodanNo() {
            return jinchuliaodanNo;
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

package com.shtoone.aqxj.bean;

import java.util.List;

public class WaagListData {

    /**
     * data : [{"gprsbianhao":"TJ1B1db","banhezhanminchen":"1号拌合站地磅"},{"gprsbianhao":"TJ1B2db","banhezhanminchen":"梧柳高速2地磅"},{"gprsbianhao":"TJ1B3db","banhezhanminchen":"梧柳高速3地磅"}]
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
         * gprsbianhao : TJ1B1db
         * banhezhanminchen : 1号拌合站地磅
         */

        private String gprsbianhao;
        private String banhezhanminchen;

        public String getGprsbianhao() {
            return gprsbianhao;
        }

        public void setGprsbianhao(String gprsbianhao) {
            this.gprsbianhao = gprsbianhao;
        }

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }
    }
}

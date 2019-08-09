package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MaterialConsumeFragmentData {


    /**
     * data : [{"cailiaoName":"减水剂","chuchang":"6.37","jinchang":"401.34","xiaohao":"10162.379999999876"},{"cailiaoName":"碎石(5-16mm)","chuchang":"0","jinchang":"0","xiaohao":"2222289.40000001"},{"cailiaoName":"混凝土","chuchang":"0","jinchang":"0","xiaohao":"323059.17000000324"},{"cailiaoName":"碎石(16-31.5mm)","chuchang":"0","jinchang":"0","xiaohao":"0.00"},{"cailiaoName":"河砂(中砂)","chuchang":"145.40","jinchang":"67996.71","xiaohao":"296375.1999999966"},{"cailiaoName":"粉煤灰(F类Ⅱ级)","chuchang":"3.70","jinchang":"83702.38","xiaohao":"1481588.8099999952"},{"cailiaoName":"普通硅酸盐水泥(低碱)","chuchang":"0","jinchang":"9923.92","xiaohao":"277761.24000000244"}]
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
         * cailiaoName : 减水剂
         * chuchang : 6.37
         * jinchang : 401.34
         * xiaohao : 10162.379999999876
         */

        private String cailiaoName;
        private String chuchang;
        private String jinchang;
        private String xiaohao;

        public String getCailiaoName() {
            return cailiaoName;
        }

        public void setCailiaoName(String cailiaoName) {
            this.cailiaoName = cailiaoName;
        }

        public String getChuchang() {
            return chuchang;
        }

        public void setChuchang(String chuchang) {
            this.chuchang = chuchang;
        }

        public String getJinchang() {
            return jinchang;
        }

        public void setJinchang(String jinchang) {
            this.jinchang = jinchang;
        }

        public String getXiaohao() {
            return xiaohao;
        }

        public void setXiaohao(String xiaohao) {
            this.xiaohao = xiaohao;
        }
    }
}

package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class SlumpData {


    /**
     * data : [{"typecode":"30-50mm","typename":"30-50mm"},{"typecode":"160-200mm","typename":"160-200mm"},{"typecode":"80-130mm","typename":"80-130mm"},{"typecode":"180-220mm","typename":"180-220mm"},{"typecode":"100-140mm","typename":"100-140mm"}]
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
         * typecode : 30-50mm
         * typename : 30-50mm
         */

        private String typecode;
        private String typename;

        public String getTypecode() {
            return typecode;
        }

        public void setTypecode(String typecode) {
            this.typecode = typecode;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }
    }
}

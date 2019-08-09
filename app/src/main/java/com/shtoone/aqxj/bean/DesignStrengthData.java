package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public class DesignStrengthData {


    /**
     * data : [{"typecode":"C15","typename":"C15"},{"typecode":"C20","typename":"C20"},{"typecode":"C25","typename":"C25"},{"typecode":"C30","typename":"C30"},{"typecode":"C30水下","typename":"C30水下"},{"typecode":"C40","typename":"C40"},{"typecode":"C40水下","typename":"C40水下"},{"typecode":"C50","typename":"C50"},{"typecode":"C60","typename":"C60"}]
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
         * typecode : C15
         * typename : C15
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

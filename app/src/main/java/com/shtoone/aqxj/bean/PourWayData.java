package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class PourWayData {


    /**
     * data : [{"typecode":"自卸","typename":"自卸"},{"typecode":"车泵","typename":"车泵"},{"typecode":"塔吊","typename":"塔吊"},{"typecode":"流放","typename":"流放"},{"typecode":"非泵送","typename":"非泵送"},{"typecode":"车载泵","typename":"车载泵"},{"typecode":"喷射","typename":"喷射"}]
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
         * typecode : 自卸
         * typename : 自卸
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "typecode='" + typecode + '\'' +
                    ", typename='" + typename + '\'' +
                    '}';
        }
    }
}

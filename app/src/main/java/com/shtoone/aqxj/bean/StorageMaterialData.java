package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
public class StorageMaterialData {


    /**
     * data : [{"parentnode":"001","cailiaono":"001001","cailiaoname":"普通硅酸盐水泥(低碱)"},{"parentnode":"002","cailiaono":"002001","cailiaoname":"碎石(5-16mm)"},{"parentnode":"002","cailiaono":"002002","cailiaoname":"碎石(16-31.5mm)"},{"parentnode":"002","cailiaono":"2222","cailiaoname":"2222"},{"parentnode":"003","cailiaono":"003001","cailiaoname":"河砂(中砂)"},{"parentnode":"004","cailiaono":"004001","cailiaoname":"粉煤灰(F类I级)"},{"parentnode":"004","cailiaono":"004002","cailiaoname":"粉煤灰(F类Ⅱ级)"},{"parentnode":"004","cailiaono":"11122222222222222","cailiaoname":"2222222"},{"parentnode":"006","cailiaono":"006001","cailiaoname":"减水剂"},{"parentnode":"007","cailiaono":"007001","cailiaoname":"混凝土"},{"parentnode":"007","cailiaono":"0070222","cailiaoname":"饮用水2"},{"parentnode":"01235","cailiaono":"00011","cailiaoname":"混凝土"},{"parentnode":"01235","cailiaono":"0232","cailiaoname":"混凝土"},{"parentnode":"01235","cailiaono":"我QQ","cailiaoname":"121"},{"parentnode":"002003","cailiaono":"002003001","cailiaoname":"柴油"},{"parentnode":"002003","cailiaono":"","cailiaoname":""},{"parentnode":null,"cailiaono":"1000","cailiaoname":"sadfasf"},{"parentnode":null,"cailiaono":"001","cailiaoname":"水泥"},{"parentnode":"","cailiaono":"002","cailiaoname":"粗骨料"},{"parentnode":"","cailiaono":"003","cailiaoname":"细骨料"},{"parentnode":"","cailiaono":"004","cailiaoname":"粉煤灰"},{"parentnode":"","cailiaono":"005","cailiaoname":"矿粉"},{"parentnode":"","cailiaono":"006","cailiaoname":"外加剂"},{"parentnode":"","cailiaono":"007","cailiaoname":"水"},{"parentnode":"","cailiaono":"01235","cailiaoname":"混凝土"},{"parentnode":"","cailiaono":"002003","cailiaoname":"柴油"}]
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
         * parentnode : 001
         * cailiaono : 001001
         * cailiaoname : 普通硅酸盐水泥(低碱)
         */

        private String parentnode;
        private String cailiaono;
        private String cailiaoname;

        public String getParentnode() {
            return parentnode;
        }

        public void setParentnode(String parentnode) {
            this.parentnode = parentnode;
        }

        public String getCailiaono() {
            return cailiaono;
        }

        public void setCailiaono(String cailiaono) {
            this.cailiaono = cailiaono;
        }

        public String getCailiaoname() {
            return cailiaoname;
        }

        public void setCailiaoname(String cailiaoname) {
            this.cailiaoname = cailiaoname;
        }
    }
}

package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */

public class JobOrderUnfinshData {

    /**
     * data : [{"createtime":"2017-07-14 17:20:42","id":"90780","jzbw":"K10+400～K10+425右侧25米","gcmc":"路基工程","jihuafangliang":"37.87","sgphbno":"未配料","shuinibiaohao":"","createperson":"shtoone","kaipanriqi":"","zhuangtai":"0","renwuno":"045"},{"createtime":"2017-07-14 14:00:26","id":"90779","jzbw":"K12+210～K12+400右侧190米","gcmc":"路基工程","jihuafangliang":"181.45","sgphbno":"12342","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"2017-07-14","zhuangtai":"1","renwuno":"1"},{"createtime":"2017-07-14 14:00:26","id":"90779","jzbw":"K12+210～K12+400右侧190米","gcmc":"路基工程","jihuafangliang":"181.45","sgphbno":"001","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"2017-07-14","zhuangtai":"1","renwuno":"1"},{"createtime":"2017-07-14 14:00:26","id":"90779","jzbw":"K12+210～K12+400右侧190米","gcmc":"路基工程","jihuafangliang":"181.45","sgphbno":"001001","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"2017-07-14","zhuangtai":"1","renwuno":"1"},{"createtime":"2017-07-14 13:56:25","id":"90778","jzbw":"K10+400～K10+425右侧25米","gcmc":"路基工程","jihuafangliang":"37.87","sgphbno":"未配料","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"2017-07-14","zhuangtai":"0","renwuno":"1312313"},{"createtime":"2017-07-13 15:16:23","id":"90776","jzbw":"dDdDd2","gcmc":"测试11111","jihuafangliang":"2.12122","sgphbno":"3123","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"312","zhuangtai":"1","renwuno":"23131"},{"createtime":"2017-07-13 15:16:23","id":"90776","jzbw":"dDdDd2","gcmc":"测试11111","jihuafangliang":"2.12122","sgphbno":"23","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"312","zhuangtai":"1","renwuno":"23131"},{"createtime":"2017-07-13 15:16:23","id":"90776","jzbw":"dDdDd2","gcmc":"测试11111","jihuafangliang":"2.12122","sgphbno":"32","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"312","zhuangtai":"1","renwuno":"23131"},{"createtime":"2017-07-13 15:16:23","id":"90776","jzbw":"dDdDd2","gcmc":"测试11111","jihuafangliang":"2.12122","sgphbno":"13","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"312","zhuangtai":"1","renwuno":"23131"},{"createtime":"2017-07-13 15:16:23","id":"90776","jzbw":"dDdDd2","gcmc":"测试11111","jihuafangliang":"2.12122","sgphbno":"3213","shuinibiaohao":"C15","createperson":"shtoone","kaipanriqi":"312","zhuangtai":"1","renwuno":"23131"}]
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

    public static class DataEntity {
        /**
         * createtime : 2017-07-14 17:20:42
         * id : 90780
         * jzbw : K10+400～K10+425右侧25米
         * gcmc : 路基工程
         * jihuafangliang : 37.87
         * sgphbno : 未配料
         * shuinibiaohao :
         * createperson : shtoone
         * kaipanriqi :
         * zhuangtai : 0
         * renwuno : 045
         */

        private String createtime;
        private String id;
        private String jzbw;
        private String gcmc;
        private String jihuafangliang;
        private String sgphbno;
        private String shuinibiaohao;
        private String createperson;
        private String kaipanriqi;
        private String zhuangtai;
        private String renwuno;
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        private boolean isSelected = false;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setJzbw(String jzbw) {
            this.jzbw = jzbw;
        }

        public void setGcmc(String gcmc) {
            this.gcmc = gcmc;
        }

        public void setJihuafangliang(String jihuafangliang) {
            this.jihuafangliang = jihuafangliang;
        }

        public void setSgphbno(String sgphbno) {
            this.sgphbno = sgphbno;
        }

        public void setShuinibiaohao(String shuinibiaohao) {
            this.shuinibiaohao = shuinibiaohao;
        }

        public void setCreateperson(String createperson) {
            this.createperson = createperson;
        }

        public void setKaipanriqi(String kaipanriqi) {
            this.kaipanriqi = kaipanriqi;
        }

        public void setZhuangtai(String zhuangtai) {
            this.zhuangtai = zhuangtai;
        }

        public void setRenwuno(String renwuno) {
            this.renwuno = renwuno;
        }

        public String getCreatetime() {
            return createtime;
        }

        public String getId() {
            return id;
        }

        public String getJzbw() {
            return jzbw;
        }

        public String getGcmc() {
            return gcmc;
        }

        public String getJihuafangliang() {
            return jihuafangliang;
        }

        public String getSgphbno() {
            return sgphbno;
        }

        public String getShuinibiaohao() {
            return shuinibiaohao;
        }

        public String getCreateperson() {
            return createperson;
        }

        public String getKaipanriqi() {
            return kaipanriqi;
        }

        public String getZhuangtai() {
            return zhuangtai;
        }

        public String getRenwuno() {
            return renwuno;
        }
    }
}

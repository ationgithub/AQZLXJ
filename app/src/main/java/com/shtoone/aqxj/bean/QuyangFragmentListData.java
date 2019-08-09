package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class QuyangFragmentListData {

    /**
     * data : [{"createDateTime":"2017-07-14 11:26:38","departname":"广西交通工程质量安全质监站","jihuafangliang":"23.88","jzbw":"K10+400～K10+425右侧25米","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-01","renwuNo":"3123","sgphbNo":"13333","shihaofangliang":"","sjqd":"C20"},{"createDateTime":"2017-07-14 11:28:58","departname":"广西交通工程质量安全质监站","jihuafangliang":"23.88","jzbw":"K10+400～K10+425右侧25米","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-02","renwuNo":"3123","sgphbNo":"231231","shihaofangliang":"","sjqd":"C40"},{"createDateTime":"2017-07-13 16:10:28","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"213","renwuNo":"23131","sgphbNo":"23","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:12:57","departname":"梧柳高速","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"11111","renwuNo":"23131","sgphbNo":"32","shihaofangliang":"","sjqd":"C15"},{"createDateTime":"2017-07-13 16:26:45","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-01","renwuNo":"23131","sgphbNo":"13","shihaofangliang":"","sjqd":"C20"},{"createDateTime":"2017-07-13 15:29:29","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"1","renwuNo":"23131","sgphbNo":"3123","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:36:02","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"213","renwuNo":"23131","sgphbNo":"3213","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:36:44","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"213","renwuNo":"23131","sgphbNo":"1323","shihaofangliang":"","sjqd":"C30水下"},{"createDateTime":"2017-07-13 16:38:54","departname":"广西交通工程质量安全质监站","jihuafangliang":"2.12122","jzbw":"dDdDd2","llphbNo":"SHZQ15-ZTSJ0-PHB20160522-02","renwuNo":"23131","sgphbNo":"123321","shihaofangliang":"","sjqd":""},{"createDateTime":"2017-07-12 10:59:08","departname":"广西交通工程质量安全质监站","jihuafangliang":"41","jzbw":"171-4#桩基","llphbNo":"SHZQ15-ZTSJ1-PHB20161128-01","renwuNo":"20170228-7","sgphbNo":"test123","shihaofangliang":"1","sjqd":"C20"}]
     * success : true
     */
    private int total;
    private boolean success;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

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

    public static class DataBean implements Serializable{

//                "LCbianhao":"2490c2a4-7546-4ad6-b0dd-7fc25754d7ef",    料仓编号
//                "guigexinghao":"河砂细砂"

//          "guigexinghao":"河砂细砂",
//                  "jingzhongT":"47.95",
//                  "cailiaoName":"细骨料",
//                  "pici":"20181115-01",
//                  "cailiaoNo":"0042",
//                  "maozhongT":"64.25",
//                  "LCname":"3#横洞油库",
//                  "departname":"郑万5标3站",
//                  "bfName":"郑万5标3号站磅房",
//                  "LCbianhao":"2490c2a4-7546-4ad6-b0dd-7fc25754d7ef",
//                  "jinchangshijian":"2018-11-15 12:52:14",
//                  "departid":"f632d5396710e74a016711129d630095",
//                  "bfbianhao":"zwtl0503",
//                  "id":1,
//                  "pizhongT":"16.3",
//                  "ts":1545103020286

        private String guigexinghao;
        private String jingzhongT;
        private String cailiaoName;
        private String pici;

        private String cailiaoNo;
        private String maozhongT;
        private String LCname;
        private String departname;
        private String bfName;

        private String LCbianhao;
        private String jinchangshijian;
        private String departid;
        private String bfbianhao;

        private int id;
        private String pizhongT;
        private String ts;

        public String getGuigexinghao() {
            return guigexinghao;
        }

        public void setGuigexinghao(String guigexinghao) {
            this.guigexinghao = guigexinghao;
        }

        public String getJingzhongT() {
            return jingzhongT;
        }

        public void setJingzhongT(String jingzhongT) {
            this.jingzhongT = jingzhongT;
        }

        public String getCailiaoName() {
            return cailiaoName;
        }

        public void setCailiaoName(String cailiaoName) {
            this.cailiaoName = cailiaoName;
        }

        public String getPici() {
            return pici;
        }

        public void setPici(String pici) {
            this.pici = pici;
        }

        public String getCailiaoNo() {
            return cailiaoNo;
        }

        public void setCailiaoNo(String cailiaoNo) {
            this.cailiaoNo = cailiaoNo;
        }

        public String getMaozhongT() {
            return maozhongT;
        }

        public void setMaozhongT(String maozhongT) {
            this.maozhongT = maozhongT;
        }

        public String getLCname() {
            return LCname;
        }

        public void setLCname(String LCname) {
            this.LCname = LCname;
        }

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getBfName() {
            return bfName;
        }

        public void setBfName(String bfName) {
            this.bfName = bfName;
        }

        public String getLCbianhao() {
            return LCbianhao;
        }

        public void setLCbianhao(String LCbianhao) {
            this.LCbianhao = LCbianhao;
        }

        public String getJinchangshijian() {
            return jinchangshijian;
        }

        public void setJinchangshijian(String jinchangshijian) {
            this.jinchangshijian = jinchangshijian;
        }

        public String getDepartid() {
            return departid;
        }

        public void setDepartid(String departid) {
            this.departid = departid;
        }

        public String getBfbianhao() {
            return bfbianhao;
        }

        public void setBfbianhao(String bfbianhao) {
            this.bfbianhao = bfbianhao;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPizhongT() {
            return pizhongT;
        }

        public void setPizhongT(String pizhongT) {
            this.pizhongT = pizhongT;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }
    }
}

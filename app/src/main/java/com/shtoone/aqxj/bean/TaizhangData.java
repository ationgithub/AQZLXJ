package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

public class TaizhangData {
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
    public static class DataBean implements Serializable {
//     "jlpic":"jlpic20181219_035637.jpg",
//             "taizhangid":1,
//             "gzpic":"",
//             "pzpic":"",
//             "qypic":"qypic20181219_035631.jpg",
//             "quyangshijian":"2018-12-19_03:58:44",
//             "id":"40288a8e67c5521f0167c57974da0005",
//             "ts":1545206330582
        String jlpic;
        int taizhangid;
        String gzpic;
        String pzpic;
        String qypic;
        String quyangshijian;
        String id ;
        long ts;

        public String getJlpic() {
            return jlpic;
        }

        public void setJlpic(String jlpic) {
            this.jlpic = jlpic;
        }

        public int getTaizhangid() {
            return taizhangid;
        }

        public void setTaizhangid(int taizhangid) {
            this.taizhangid = taizhangid;
        }

        public String getGzpic() {
            return gzpic;
        }

        public void setGzpic(String gzpic) {
            this.gzpic = gzpic;
        }

        public String getPzpic() {
            return pzpic;
        }

        public void setPzpic(String pzpic) {
            this.pzpic = pzpic;
        }

        public String getQypic() {
            return qypic;
        }

        public void setQypic(String qypic) {
            this.qypic = qypic;
        }

        public String getQuyangshijian() {
            return quyangshijian;
        }

        public void setQuyangshijian(String quyangshijian) {
            this.quyangshijian = quyangshijian;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTs() {
            return ts;
        }

        public void setTs(long ts) {
            this.ts = ts;
        }
    }
}

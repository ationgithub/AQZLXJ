package com.shtoone.aqxj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leguang on 2016/6/23 0016.
 */
public class WannengjiFragmentViewPagerFragmentRecyclerViewItemData {

    /**
     * data : [{"GCMC":"路面工程","SYRQ":"2016-08-13","SYJID":"2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+990横向排水管","GCZJ":"12","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0004-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-13","SYJID":"2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+990横向排水管","GCZJ":"12","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0004-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-13","SYJID":"2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+990横向排水管","GCZJ":"12","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0004-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-13","SYJID":"2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+990横向排水管","GCZJ":"12","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0004-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-13","SYJID":"2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+990横向排水管","GCZJ":"12","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0004-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-13","SYJID":"2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+990横向排水管","GCZJ":"12","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0004-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-11","SYJID":"C8995E8B-7B6D-411E-9586-A60C31BF22E80","chuzhi":"0","testName":"钢筋试验","SGBW":"K124+640 K124+840 K124+940 左侧 K124+740右侧","GCZJ":"2","LZQD":"","shebeiname":"贵合高速F标1#压力机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0003-B","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-11","SYJID":"F6C9695B-06C1-4555-93FB-9F126C4389DB1","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+640 K124+840 K124+940 左侧 K124+740右侧","GCZJ":"6","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0003-C","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-11","SYJID":"F6C9695B-06C1-4555-93FB-9F126C4389DB2","chuzhi":"1","testName":"钢筋试验","SGBW":"K124+640 K124+840 K124+940 左侧 K124+740右侧","GCZJ":"6","LZQD":"","shebeiname":"贵合高速B标1#万能机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0003-C","PZBM":""},{"GCMC":"路面工程","SYRQ":"2016-08-09","SYJID":"F00AA601-8317-4D5A-A601-4DEF7989B9073","chuzhi":"0","testName":"钢筋试验","SGBW":"K124+340 K124+390 K124+440 K124+490左侧横向排水管","GCZJ":"1","LZQD":"","shebeiname":"贵合高速F标1#压力机","PDJG":"合格","QFLZ":"","SJBH":"YP2016ZF-TYH-0002-C","PZBM":""}]
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

    public static class DataBean implements Serializable{
        /**
         * GCMC : 路面工程
         * SYRQ : 2016-08-13
         * SYJID : 2566BEEA-BCA3-4E9F-95DE-EB20A0F6B181
         * chuzhi : 1
         * testName : 钢筋试验
         * SGBW : K124+990横向排水管
         * GCZJ : 12
         * LZQD :
         * shebeiname : 贵合高速B标1#万能机
         * PDJG : 合格
         * QFLZ :
         * SJBH : YP2016ZF-TYH-0004-B
         * PZBM :
         */

        private String GCMC;
        private String SYRQ;
        private String SYJID;
        private String chuzhi;
        private String testName;
        private String SGBW;
        private String GCZJ;
        private String LZQD;
        private String shebeiname;
        private String PDJG;
        private String QFLZ;
        private String SJBH;
        private String PZBM;

        public String getGCMC() {
            return GCMC;
        }

        public void setGCMC(String GCMC) {
            this.GCMC = GCMC;
        }

        public String getSYRQ() {
            return SYRQ;
        }

        public void setSYRQ(String SYRQ) {
            this.SYRQ = SYRQ;
        }

        public String getSYJID() {
            return SYJID;
        }

        public void setSYJID(String SYJID) {
            this.SYJID = SYJID;
        }

        public String getChuzhi() {
            return chuzhi;
        }

        public void setChuzhi(String chuzhi) {
            this.chuzhi = chuzhi;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public String getSGBW() {
            return SGBW;
        }

        public void setSGBW(String SGBW) {
            this.SGBW = SGBW;
        }

        public String getGCZJ() {
            return GCZJ;
        }

        public void setGCZJ(String GCZJ) {
            this.GCZJ = GCZJ;
        }

        public String getLZQD() {
            return LZQD;
        }

        public void setLZQD(String LZQD) {
            this.LZQD = LZQD;
        }

        public String getShebeiname() {
            return shebeiname;
        }

        public void setShebeiname(String shebeiname) {
            this.shebeiname = shebeiname;
        }

        public String getPDJG() {
            return PDJG;
        }

        public void setPDJG(String PDJG) {
            this.PDJG = PDJG;
        }

        public String getQFLZ() {
            return QFLZ;
        }

        public void setQFLZ(String QFLZ) {
            this.QFLZ = QFLZ;
        }

        public String getSJBH() {
            return SJBH;
        }

        public void setSJBH(String SJBH) {
            this.SJBH = SJBH;
        }

        public String getPZBM() {
            return PZBM;
        }

        public void setPZBM(String PZBM) {
            this.PZBM = PZBM;
        }
    }
}

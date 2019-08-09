package com.shtoone.aqxj.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */

public class YCLJinChangWeightFragmentDetailData {


    /**
     * data : [{"jinchangshijian":"2017-07-04 20:59:24","remark":null,"houchepai":null,"JCGKPic":null,"chengzhongpiancha":null,"cailiaoNo":"003001","kouzhong":0,"qianchepai":"皖B45657","pizhong":14.84,"id":184974,"sibangyuan":"董振鹏","CCGKPic":null,"JCHCPPic":null,"CCBFPic":null,"guobangleibie":"0","istongji":1,"cailiaoName":"河砂(中砂)","departid":"8a8ab0b246dc81120146dc8180ba0017","maozhong":65.9,"jingzhong":49.53,"CCHCPPic":null,"cheliangbianhao":null,"pici":null,"org_code":"A01","gongyingshangdanweibianma":"b785dea1-1aa2-402d-9e8c-c799d891979b","JCCPPic":null,"JCBFPic":null,"liaocang":null,"chuchangshijian":"2017-07-04 21:03:52","shebeibianhao":"TJ1B1db","CCCPPic":null,"koulv":"97","cheliangleixing":null,"jinchuliaodanNo":"20170704210353","banhezhanminchen":"1号拌合站地磅","gongyingshangName":"全椒润尧商贸有限公司"}]
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
         * jinchangshijian : 2017-07-04 20:59:24
         * remark : null
         * houchepai : null
         * JCGKPic : null
         * chengzhongpiancha : null
         * cailiaoNo : 003001
         * kouzhong : 0
         * qianchepai : 皖B45657
         * pizhong : 14.84
         * id : 184974
         * sibangyuan : 董振鹏
         * CCGKPic : null
         * JCHCPPic : null
         * CCBFPic : null
         * guobangleibie : 0
         * istongji : 1
         * cailiaoName : 河砂(中砂)
         * departid : 8a8ab0b246dc81120146dc8180ba0017
         * maozhong : 65.9
         * jingzhong : 49.53
         * CCHCPPic : null
         * cheliangbianhao : null
         * pici : null
         * org_code : A01
         * gongyingshangdanweibianma : b785dea1-1aa2-402d-9e8c-c799d891979b
         * JCCPPic : null
         * JCBFPic : null
         * liaocang : null
         * chuchangshijian : 2017-07-04 21:03:52
         * shebeibianhao : TJ1B1db
         * CCCPPic : null
         * koulv : 97
         * cheliangleixing : null
         * jinchuliaodanNo : 20170704210353
         * banhezhanminchen : 1号拌合站地磅
         * gongyingshangName : 全椒润尧商贸有限公司
         */

        private String jinchangshijian;
        private Object remark;
        private Object houchepai;
        private Object JCGKPic;
        private Object chengzhongpiancha;
        private String cailiaoNo;
        private int    kouzhong;
        private String qianchepai;
        private double pizhong;
        private int    id;
        private String sibangyuan;
        private Object CCGKPic;
        private Object JCHCPPic;
        private Object CCBFPic;
        private String guobangleibie;
        private int    istongji;
        private String cailiaoName;
        private String departid;
        private double maozhong;
        private double jingzhong;
        private Object CCHCPPic;
        private Object cheliangbianhao;
        private Object pici;
        private String org_code;
        private String gongyingshangdanweibianma;
        private Object JCCPPic;
        private Object JCBFPic;
        private Object liaocang;
        private String chuchangshijian;
        private String shebeibianhao;
        private Object CCCPPic;
        private String koulv;
        private Object cheliangleixing;
        private String jinchuliaodanNo;
        private String banhezhanminchen;
        private String gongyingshangName;

        public void setJinchangshijian(String jinchangshijian) {
            this.jinchangshijian = jinchangshijian;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public void setHouchepai(Object houchepai) {
            this.houchepai = houchepai;
        }

        public void setJCGKPic(Object JCGKPic) {
            this.JCGKPic = JCGKPic;
        }

        public void setChengzhongpiancha(Object chengzhongpiancha) {
            this.chengzhongpiancha = chengzhongpiancha;
        }

        public void setCailiaoNo(String cailiaoNo) {
            this.cailiaoNo = cailiaoNo;
        }

        public void setKouzhong(int kouzhong) {
            this.kouzhong = kouzhong;
        }

        public void setQianchepai(String qianchepai) {
            this.qianchepai = qianchepai;
        }

        public void setPizhong(double pizhong) {
            this.pizhong = pizhong;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSibangyuan(String sibangyuan) {
            this.sibangyuan = sibangyuan;
        }

        public void setCCGKPic(Object CCGKPic) {
            this.CCGKPic = CCGKPic;
        }

        public void setJCHCPPic(Object JCHCPPic) {
            this.JCHCPPic = JCHCPPic;
        }

        public void setCCBFPic(Object CCBFPic) {
            this.CCBFPic = CCBFPic;
        }

        public void setGuobangleibie(String guobangleibie) {
            this.guobangleibie = guobangleibie;
        }

        public void setIstongji(int istongji) {
            this.istongji = istongji;
        }

        public void setCailiaoName(String cailiaoName) {
            this.cailiaoName = cailiaoName;
        }

        public void setDepartid(String departid) {
            this.departid = departid;
        }

        public void setMaozhong(double maozhong) {
            this.maozhong = maozhong;
        }

        public void setJingzhong(double jingzhong) {
            this.jingzhong = jingzhong;
        }

        public void setCCHCPPic(Object CCHCPPic) {
            this.CCHCPPic = CCHCPPic;
        }

        public void setCheliangbianhao(Object cheliangbianhao) {
            this.cheliangbianhao = cheliangbianhao;
        }

        public void setPici(Object pici) {
            this.pici = pici;
        }

        public void setOrg_code(String org_code) {
            this.org_code = org_code;
        }

        public void setGongyingshangdanweibianma(String gongyingshangdanweibianma) {
            this.gongyingshangdanweibianma = gongyingshangdanweibianma;
        }

        public void setJCCPPic(Object JCCPPic) {
            this.JCCPPic = JCCPPic;
        }

        public void setJCBFPic(Object JCBFPic) {
            this.JCBFPic = JCBFPic;
        }

        public void setLiaocang(Object liaocang) {
            this.liaocang = liaocang;
        }

        public void setChuchangshijian(String chuchangshijian) {
            this.chuchangshijian = chuchangshijian;
        }

        public void setShebeibianhao(String shebeibianhao) {
            this.shebeibianhao = shebeibianhao;
        }

        public void setCCCPPic(Object CCCPPic) {
            this.CCCPPic = CCCPPic;
        }

        public void setKoulv(String koulv) {
            this.koulv = koulv;
        }

        public void setCheliangleixing(Object cheliangleixing) {
            this.cheliangleixing = cheliangleixing;
        }

        public void setJinchuliaodanNo(String jinchuliaodanNo) {
            this.jinchuliaodanNo = jinchuliaodanNo;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public void setGongyingshangName(String gongyingshangName) {
            this.gongyingshangName = gongyingshangName;
        }

        public String getJinchangshijian() {
            return jinchangshijian;
        }

        public Object getRemark() {
            return remark;
        }

        public Object getHouchepai() {
            return houchepai;
        }

        public Object getJCGKPic() {
            return JCGKPic;
        }

        public Object getChengzhongpiancha() {
            return chengzhongpiancha;
        }

        public String getCailiaoNo() {
            return cailiaoNo;
        }

        public int getKouzhong() {
            return kouzhong;
        }

        public String getQianchepai() {
            return qianchepai;
        }

        public double getPizhong() {
            return pizhong;
        }

        public int getId() {
            return id;
        }

        public String getSibangyuan() {
            return sibangyuan;
        }

        public Object getCCGKPic() {
            return CCGKPic;
        }

        public Object getJCHCPPic() {
            return JCHCPPic;
        }

        public Object getCCBFPic() {
            return CCBFPic;
        }

        public String getGuobangleibie() {
            return guobangleibie;
        }

        public int getIstongji() {
            return istongji;
        }

        public String getCailiaoName() {
            return cailiaoName;
        }

        public String getDepartid() {
            return departid;
        }

        public double getMaozhong() {
            return maozhong;
        }

        public double getJingzhong() {
            return jingzhong;
        }

        public Object getCCHCPPic() {
            return CCHCPPic;
        }

        public Object getCheliangbianhao() {
            return cheliangbianhao;
        }

        public Object getPici() {
            return pici;
        }

        public String getOrg_code() {
            return org_code;
        }

        public String getGongyingshangdanweibianma() {
            return gongyingshangdanweibianma;
        }

        public Object getJCCPPic() {
            return JCCPPic;
        }

        public Object getJCBFPic() {
            return JCBFPic;
        }

        public Object getLiaocang() {
            return liaocang;
        }

        public String getChuchangshijian() {
            return chuchangshijian;
        }

        public String getShebeibianhao() {
            return shebeibianhao;
        }

        public Object getCCCPPic() {
            return CCCPPic;
        }

        public String getKoulv() {
            return koulv;
        }

        public Object getCheliangleixing() {
            return cheliangleixing;
        }

        public String getJinchuliaodanNo() {
            return jinchuliaodanNo;
        }

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public String getGongyingshangName() {
            return gongyingshangName;
        }
    }
}

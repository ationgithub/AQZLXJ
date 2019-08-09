package com.shtoone.aqxj.bean;

import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeId;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeLabel;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodePid;

/**
 * Created by Administrator on 2017/8/10.
 */

public class MaterialData {


    @TreeNodeId
    private String cailiaono;

    @TreeNodePid
    private String parentnode;

    @TreeNodeLabel
    private String cailiaoname;

    public MaterialData(String cailiaono, String parentnode, String cailiaoname) {
        this.cailiaono = cailiaono;
        this.parentnode = parentnode;
        this.cailiaoname = cailiaoname;
    }

    public String getCailiaono() {
        return cailiaono;
    }

    public void setCailiaono(String cailiaono) {
        this.cailiaono = cailiaono;
    }

    public String getParentnode() {
        return parentnode;
    }

    public void setParentnode(String parentnode) {
        this.parentnode = parentnode;
    }

    public String getCailiaoname() {
        return cailiaoname;
    }

    public void setCailiaoname(String cailiaoname) {
        this.cailiaoname = cailiaoname;
    }
}

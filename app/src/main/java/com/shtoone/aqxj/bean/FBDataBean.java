package com.shtoone.aqxj.bean;

import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeId;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeLabel;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodePid;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/9/28.
 */

public class FBDataBean extends DataSupport {
    /**
     * parentNo : 001001001
     * projectName : 路堤混凝土
     * projectNo : 001001001001
     *
     *
     *
     @TreeNodeId
     private String projectNo;

     @TreeNodePid
     private String parentNo;

     @TreeNodeLabel
     private String projectName;
     */
    @TreeNodePid
    private String parentNo;
    @TreeNodeLabel
    private String projectName;
    @TreeNodeId
    private String projectNo;

    public FBDataBean() {
    }

    public FBDataBean(String projectNo, String parentNo, String projectName) {

    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }


    @Override
    public String toString() {
        return "FBDataBean{" +
                "parentNo='" + parentNo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectNo='" + projectNo + '\'' +
                '}';
    }
}

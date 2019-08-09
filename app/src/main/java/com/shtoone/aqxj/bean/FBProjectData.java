package com.shtoone.aqxj.bean;

import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeId;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeLabel;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodePid;

/**
 * Created by Administrator on 2017/8/10.
 */

public class FBProjectData {


    @TreeNodeId
    private String projectNo;

    @TreeNodePid
    private String parentNo;

    @TreeNodeLabel
    private String projectName;

    public FBProjectData(String projectNo, String parentNo, String projectName) {
        this.projectNo = projectNo;
        this.parentNo = parentNo;
        this.projectName = projectName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
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
}

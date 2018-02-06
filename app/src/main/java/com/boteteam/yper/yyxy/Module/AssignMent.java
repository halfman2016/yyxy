package com.boteteam.yper.yyxy.Module;

import org.bson.BsonDateTime;

import java.sql.Date;

/**
 * Created by jiangfeng on 2018/1/25.
 */

public class AssignMent {
    private int idAssignMent;
    private Date postdate;
    private String assignmentmemo;
    private Date collectdate;
    private String assignmentcode;
    private String assignname;
    private String assignteaid;
    private String assigngcname;
    private String assigngcid;

    public int getIdAssignMent() {
        return idAssignMent;
    }

    public void setIdAssignMent(int idAssignMent) {
        this.idAssignMent = idAssignMent;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getAssignmentmemo() {
        return assignmentmemo;
    }

    public void setAssignmentmemo(String assignmentmemo) {
        this.assignmentmemo = assignmentmemo;
    }

    public Date getCollectdate() {
        return collectdate;
    }

    public void setCollectdate(Date collectdate) {
        this.collectdate = collectdate;
    }

    public String getAssignmentcode() {
        return assignmentcode;
    }

    public void setAssignmentcode(String assignmentcode) {
        this.assignmentcode = assignmentcode;
    }

    public String getAssignname() {
        return assignname;
    }

    public void setAssignname(String assignname) {
        this.assignname = assignname;
    }

    public String getAssignteaid() {
        return assignteaid;
    }

    public void setAssignteaid(String assignteaid) {
        this.assignteaid = assignteaid;
    }

    public String getAssigngcname() {
        return assigngcname;
    }

    public void setAssigngcname(String assigngcname) {
        this.assigngcname = assigngcname;
    }

    public String getAssigngcid() {
        return assigngcid;
    }

    public void setAssigngcid(String assigngcid) {
        this.assigngcid = assigngcid;
    }
}

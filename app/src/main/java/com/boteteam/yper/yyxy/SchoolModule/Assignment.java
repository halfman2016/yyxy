package com.boteteam.yper.yyxy.SchoolModule;

import com.boteteam.yper.yyxy.Module.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Feng Jiang on 2017/9/30.
 */

public class Assignment {
    private ArrayList<Timu> timus;
    private ArrayList<String> pics;
    private UUID _id=UUID.randomUUID();
    private Date bztime;
    private Date jstime;
    private UUID bzrid;
    private String bzrname;
    private String bjname; //班级名称
    private UUID bj_id; //班级id
    private String subject; //科目
    private ArrayList<Student> stus; //布置给甚么学生
    private ArrayList<Student> stuworkeds; // 已交作业集合


    public String getBjname() {
        return bjname;
    }

    public void setBjname(String bjname) {
        this.bjname = bjname;
    }

    public UUID getBj_id() {
        return bj_id;
    }

    public void setBj_id(UUID bj_id) {
        this.bj_id = bj_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Timu> getTimus() {
        return timus;
    }

    public void setTimus(ArrayList<Timu> timus) {
        this.timus = timus;
    }

    public ArrayList<String> getPics() {
        return pics;
    }

    public void setPics(ArrayList<String> pics) {
        this.pics = pics;
    }

    public UUID get_id() {
        return _id;
    }



    public Date getBztime() {
        return bztime;
    }

    public void setBztime(Date bztime) {
        this.bztime = bztime;
    }

    public Date getJstime() {
        return jstime;
    }

    public void setJstime(Date jstime) {
        this.jstime = jstime;
    }

    public UUID getBzrid() {
        return bzrid;
    }

    public void setBzrid(UUID bzrid) {
        this.bzrid = bzrid;
    }

    public String getBzrname() {
        return bzrname;
    }

    public void setBzrname(String bzrname) {
        this.bzrname = bzrname;
    }

    public ArrayList<Student> getStus() {
        return stus;
    }

    public void setStus(ArrayList<Student> stus) {
        this.stus = stus;
    }

    public ArrayList<Student> getStuworkeds() {
        return stuworkeds;
    }

    public void setStuworkeds(ArrayList<Student> stuworkeds) {
        this.stuworkeds = stuworkeds;
    }
}

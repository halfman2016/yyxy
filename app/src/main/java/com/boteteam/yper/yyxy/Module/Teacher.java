package com.boteteam.yper.yyxy.Module;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Feng on 2016/7/12.
 */
public class Teacher extends People {
    private String Tid;
    private ArrayList<String> Duty = new ArrayList<>();
    private String OnDutyGradeClassName;// == all 特权，3个特权，郑主任和罗校长，林校长。
    private UUID OnDutyGradeClassId;
    private String dutytitle;
    private String status; // 在职，不在职 // null 自动赋值
    private String Subject; //科目，作业使用

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDutytitle() {
        return dutytitle;
    }

    public void setDutytitle(String dutytitle) {
        this.dutytitle = dutytitle;
    }

    public String getOnDutyGradeClassName() {
        return OnDutyGradeClassName;
    }

    public void setOnDutyGradeClassName(String onDutyGradeClassName) {
        OnDutyGradeClassName = onDutyGradeClassName;
    }

    public UUID getOnDutyGradeClassId() {
        return OnDutyGradeClassId;
    }

    public void setOnDutyGradeClassId(UUID onDutyGradeClassId) {
        OnDutyGradeClassId = onDutyGradeClassId;
    }

    public Teacher(String name) {
        super(name);
    }

    public String getTid() {
        return Tid;
    }

    public void setTid(String tid) {
        Tid = tid;
    }
}

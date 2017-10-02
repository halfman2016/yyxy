package com.boteteam.yper.yyxy.SchoolModule;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Feng Jiang on 2017/10/1.
 */

//单人交回来的作业，会有作业属性，就是布置的是甚么题目，会有谁i叫的，则是两张mysql的表
    // AssignmentId StudentId FeedbackPics
    // AssignmentId StudentId TimuResults

    //这个对象存储一个学生一次作业的批改记录，内容从2张mysql表读取，一张表是交回来的作业图片表，一张表是
    //批阅结果表，批阅结果包括正确错误判定，题目分值。

public class Feedback {
    private UUID AssignmentId;
    private UUID _id=UUID.randomUUID();
    private UUID StudentId;
    private UUID TeacherId;
    private ArrayList<String> FeedbackPics;  //单表，pic和题目结果不是一一对应
    private ArrayList<String> TimuResults;  //正确 错误，和题目一一对应 student和assignment相乘的结果
    private ArrayList<Integer> TimuScores;  //和题目一一对应
    public UUID getAssignmentId() {
        return AssignmentId;
    }

    public void setAssignmentId(UUID assignmentId) {
        AssignmentId = assignmentId;
    }

    public UUID get_id() {
        return _id;
    }


    public UUID getStudentId() {
        return StudentId;
    }

    public void setStudentId(UUID studentId) {
        StudentId = studentId;
    }

    public UUID getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(UUID teacherId) {
        TeacherId = teacherId;
    }

    public ArrayList<String> getFeedbackPics() {
        return FeedbackPics;
    }

    public void setFeedbackPics(ArrayList<String> feedbackPics) {
        FeedbackPics = feedbackPics;
    }
}

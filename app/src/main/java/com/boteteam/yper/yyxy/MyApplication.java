package com.boteteam.yper.yyxy;

import android.app.Application;
import android.content.Context;

import com.boteteam.yper.yyxy.Module.GradeClass;
import com.boteteam.yper.yyxy.Module.Student;
import com.boteteam.yper.yyxy.Module.Teacher;
import com.boteteam.yper.yyxy.SchoolModule.GradeClassSubject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Feng Jiang on 2017/7/2.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private static Teacher teacher;
    private static Student student;
    private static Context context;
    private static HashMap<GradeClass,String> gcsubjects;
    private static String mode="test";
    private static ArrayList<GradeClassSubject> gcs;  //选上班级和科目列表
    @Override


    public void onCreate() {
        super.onCreate();
        instance=this;
        context=getApplicationContext();
    }

    public  HashMap<GradeClass, String> getGcsubjects() {
        return gcsubjects;
    }

    public  void setGcsubjects(HashMap<GradeClass, String> gcsubjects) {
        MyApplication.gcsubjects = gcsubjects;
    }

    public  void setContext(Context context) {
        MyApplication.context = context;
    }

    public  void setMode(String mode) {
        MyApplication.mode = mode;
    }

    public  ArrayList<GradeClassSubject> getGcs() {
        return gcs;
    }

    public  void setGcs(ArrayList<GradeClassSubject> gcs) {
        MyApplication.gcs = gcs;
    }

    public  String getMode() {
        return mode;
    }

    public  Context getContext() {
        return context;
    }

    public static  MyApplication getInstance(){
        return instance;
    }

    public  Student getStudent() {
        return student;
    }

    public  void setStudent(Student student) {
        MyApplication.student = student;
    }

    public  Teacher getTeacher() {
        return teacher;
    }

    public  void setTeacher(Teacher teacher) {
        MyApplication.teacher = teacher;
    }
}

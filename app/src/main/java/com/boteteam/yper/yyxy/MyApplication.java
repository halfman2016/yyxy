package com.boteteam.yper.yyxy;

import android.app.Application;
import android.content.Context;

import com.boteteam.yper.yyxy.Module.GradeClass;
import com.boteteam.yper.yyxy.Module.Student;
import com.boteteam.yper.yyxy.Module.Teacher;

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
    @Override


    public void onCreate() {
        super.onCreate();
        instance=this;
        context=getApplicationContext();
    }

    public static HashMap<GradeClass, String> getGcsubjects() {
        return gcsubjects;
    }

    public static void setGcsubjects(HashMap<GradeClass, String> gcsubjects) {
        MyApplication.gcsubjects = gcsubjects;
    }

    public static String getMode() {
        return mode;
    }

    public static Context getContext() {
        return context;
    }

    public static  MyApplication getInstance(){
        return instance;
    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        MyApplication.student = student;
    }

    public static Teacher getTeacher() {
        return teacher;
    }

    public static void setTeacher(Teacher teacher) {
        MyApplication.teacher = teacher;
    }
}

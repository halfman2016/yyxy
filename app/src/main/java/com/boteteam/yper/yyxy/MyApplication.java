package com.boteteam.yper.yyxy;

import android.app.Application;

import com.boteteam.yper.yyxy.Module.Student;
import com.boteteam.yper.yyxy.Module.Teacher;

/**
 * Created by Feng Jiang on 2017/7/2.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private static  Teacher teacher;
    private static Student student;
    private static String mode;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        mode="test";
    }

    public static String getMode() {
        return mode;
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

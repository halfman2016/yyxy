 package com.boteteam.yper.yyxy.Teacher

import android.drm.DrmStore
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.util.Log
import com.boteteam.yper.yyxy.MyApplication
import com.boteteam.yper.yyxy.R

 class teaAssignAssign : AppCompatActivity() {

     private var myapplication = MyApplication.getInstance();


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_assign_assign)
         for (gcstemp in myapplication.gcs){
         Log.d("myapp",gcstemp.gradeclassname)}
         var gcstemp=myapplication.gcs
         Log.d("myapp",gcstemp.count().toString())


    }
}

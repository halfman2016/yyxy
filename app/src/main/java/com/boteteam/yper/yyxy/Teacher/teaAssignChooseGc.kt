package com.boteteam.yper.yyxy.Teacher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import com.boteteam.yper.yyxy.Module.GradeClass
import com.boteteam.yper.yyxy.MyApplication
import com.boteteam.yper.yyxy.R
import kotlinx.android.synthetic.main.listitem_main_assignbz.view.*
import kotlinx.android.synthetic.main.teassignchoosegc.*

class teaAssignChooseGc() : AppCompatActivity(),View.OnClickListener {


    private var myapplication=MyApplication.getInstance();
    private var teacher=myapplication.teacher
    private var gcs=myapplication.gcsubjects

    constructor(parcel: Parcel) : this() {

    }
    //教授班级，教授科目

    override fun onClick(p0: View?) {

        if (p0 != null) {
            Log.d("myapp", p0.id.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teassignchoosegc)
        btngchoosenext.setOnClickListener(this)
        loaddata()
    }
    fun loaddata(){

        for (gc in gcs)
        {
            var checkBox=CheckBox(this);
            checkBox.text=gc.key.name
            checkBox.id= 923423423.toInt()
            checkBox.setOnClickListener(this)
            checkboxs.addView(checkBox)

        }
    }



}

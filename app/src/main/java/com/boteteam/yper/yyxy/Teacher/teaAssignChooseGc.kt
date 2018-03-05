package com.boteteam.yper.yyxy.Teacher

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import com.boteteam.yper.yyxy.Module.GradeClass
import com.boteteam.yper.yyxy.MyApplication
import com.boteteam.yper.yyxy.R
import com.boteteam.yper.yyxy.SchoolModule.GradeClassSubject
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.listitem_main_assignbz.view.*
import kotlinx.android.synthetic.main.teassignchoosegc.*

class teaAssignChooseGc() : AppCompatActivity(), View.OnClickListener {


    private var myapplication = MyApplication.getInstance();
    private var teacher = myapplication.teacher
    private var gcs = myapplication.gcsubjects
    private var selgcs = arrayListOf<GradeClassSubject>()

    constructor(parcel: Parcel) : this() {

    }
    //教授班级，教授科目

    override fun onClick(p0: View?) {
        var checks = arrayListOf<CheckBox>()

        when (p0) {
            is CheckBox -> {

                var b: CheckBox = p0
                Log.d("myapp", b.text.toString())
            }
            is Button -> {

                var i = 0
                var j=0
                selgcs.clear()

                while (i < checkboxs.childCount) {
                    var ch = checkboxs.getChildAt(i) as CheckBox
                    if (ch.isChecked) {
                        //选中的状态
                        var chars = ch.text.split(":")
                        var gcstemp : GradeClassSubject=GradeClassSubject()
                        gcstemp.gradeclassname=chars.get(0)
                        gcstemp.subject=chars.get(1)
                        selgcs.add(gcstemp)


                        j++
                    }

                    i++
                }


                if (j > 0) {

                    myapplication.gcs=selgcs

                    var intent = Intent();
                    intent.setClass(this, teaAssignAssign::class.java);
                    // myApplication 赋值
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"请至少选择一个",Toast.LENGTH_SHORT).show()
                    Log.d("myapp", "请选中至少一个")
                }
            }

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teassignchoosegc)
        btngchoosenext.setOnClickListener(this)
        loaddata()
    }

    fun loaddata() {

        for (gc in gcs) {
            var checkBox = CheckBox(this);
            checkBox.text = gc.key.name + ":" + gc.value
            checkBox.setOnClickListener(this)

            checkboxs.addView(checkBox)

        }
    }


}

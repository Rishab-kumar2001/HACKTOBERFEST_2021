package com.example.android.todoapplication

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.scrollView2
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_todos_desc.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var todo = hashMapOf<Int,String>()
        var todoDesc = hashMapOf<Int,String>()
        var linearlayt = LinearLayout(this@MainActivity)
        var i = 1
        scrollView2.addView(linearlayt)
        bt.setOnClickListener {
            todo [i]= et.text.toString()
            todoDesc [i]= etdesc.text.toString()
            var result : String = "Your ToDo List is as follows :"
            tv.text=result
            var btnView = Button(this@MainActivity)
            btnView.text = todo[i]
            btnView.id=i;
            btnView.setOnClickListener {
                val intent = Intent(this@MainActivity, TodosDesc::class.java)
                intent.putExtra("TodoTask",todo)
                intent.putExtra("TodoDesc",todoDesc)
                intent.putExtra("Todoid",btnView.id.toString())
                startActivity(intent)
            }
            linearlayt.addView(btnView)
            et.text.clear()
            etdesc.text.clear()
//            et.text=null
            i += 1
        }
        btclear.setOnClickListener {
            scrollView2.removeView(linearlayt)
            linearlayt = LinearLayout(this@MainActivity)
            scrollView2.addView(linearlayt)
            et.text.clear()
            etdesc.text.clear()
            todo = hashMapOf<Int,String>()
            todoDesc = hashMapOf<Int,String>()
            i=1
        }


    }


}







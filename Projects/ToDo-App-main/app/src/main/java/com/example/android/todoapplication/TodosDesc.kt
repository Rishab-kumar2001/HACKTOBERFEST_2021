package com.example.android.todoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_todos_desc.*

class TodosDesc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos_desc)

        var intent = intent
//        tvtit.text="hello"
        var todo = hashMapOf<Int,String>()
        todo = intent.getSerializableExtra("TodoTask") as HashMap<Int, String>
        var todoDet = hashMapOf<Int,String>()
        todoDet = intent.getSerializableExtra("TodoDesc") as HashMap<Int, String>

        var konsa1 : String? = intent.getStringExtra("Todoid")
        var konsa =konsa1!!.toInt()
        tvtit.text= todo[konsa]
        tvdesc.text= todoDet[konsa]


        bk.setOnClickListener {
            super.onBackPressed();
        }
    }
}
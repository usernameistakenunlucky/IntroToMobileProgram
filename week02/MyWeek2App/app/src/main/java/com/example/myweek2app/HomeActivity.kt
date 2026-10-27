package com.example.myweek2app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.view.KeyEvent.KEYCODE_ENTER

// Activity
class HomeActivity : AppCompatActivity()
{
    // only declare
    lateinit var myTextView: TextView
    lateinit var loginButton: Button
    lateinit var nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        // var ~ let ~ val
        myTextView = findViewById<TextView>(R.id.myTextView_id)
        loginButton = findViewById<Button>(R.id.loginButton_id)
        nameEditText = findViewById<EditText>(R.id.yourNameHereText_id)

        nameEditText.setOnKeyListener(keysFun())


    }
}








//    fun myFun() : Unit // this means void, its default
//    {
//
//    }
//    fun myInpFun (i:Int, j:Int): Int
//    {
//        return i * j
//    }


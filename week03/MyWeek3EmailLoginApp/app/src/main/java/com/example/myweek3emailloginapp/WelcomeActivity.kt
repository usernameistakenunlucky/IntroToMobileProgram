package com.example.myweek3emailloginapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra("name")
        val usersNameText_id = findViewById<TextView>(R.id.usersNameText_id)
        usersNameText_id.text = "$name"
    }
}
package com.example.myweek2app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.TextView
import android.widget.Button
import android.graphics.Color
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)

        findViewById<TextView>(R.id.loginTextView_id).text = intent.getStringExtra("myKey")
    }


    public fun goBack (v: View)
    {
        finish()
    }
}
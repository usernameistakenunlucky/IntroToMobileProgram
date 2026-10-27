package com.example.tourofandroid

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


// Activity ~ scene ~ level ~ page
class HomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        var myButton: Button = findViewById(R.id.myButton_id)

        var cityTextView = findViewById<TextView>(R.id.cityTextView_id)

        myButton.setOnClickListener()
        {
            cityTextView.text = "Riley"
            cityTextView.setTextColor(Color.DKGRAY)
            cityTextView.setBackgroundColor(Color.BLUE)
        }


    }
}
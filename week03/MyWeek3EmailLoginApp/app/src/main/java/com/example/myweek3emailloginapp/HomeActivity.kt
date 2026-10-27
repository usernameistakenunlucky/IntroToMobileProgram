package com.example.myweek3emailloginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myweek3emailloginapp.AppData.Companion.users
import java.util.UUID


class HomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)


        val emailInput = findViewById<EditText>(R.id.inputText_id)
        val loginButton = findViewById<Button>(R.id.loginButton_id)

        loginButton.setOnClickListener()
        {
            val found = users.find { it.email == emailInput.text.toString() }

            if (found != null)
            {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("name", found.name)
                startActivity(intent)
            }
        }


    }
}
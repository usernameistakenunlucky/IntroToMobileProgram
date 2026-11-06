package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        if (AppData.users.isEmpty())
        {
            AppData.populate()
        }

        val emailInput = findViewById<EditText>(R.id.usernameLoginText_id)
        val passwordInput = findViewById<EditText>(R.id.passwordLoginText_id)
        val loginButton = findViewById<Button>(R.id.loginButton_id)
        val signUpLink = findViewById<Button>(R.id.signUpLink_id)
        val loginError = findViewById<TextView>(R.id.loginErrorText_id)

        signUpLink.setOnClickListener()
        {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener()
        {
            val found = AppData.users.find {
                it.email == emailInput.text.toString() &&
                        it.password == passwordInput.text.toString()
            }

            if (found != null)
            {
                loginError.visibility = View.GONE

                AppData.currentUser = found

                val intent = Intent(this, HomeActivity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            else
            {
                loginError.visibility = View.VISIBLE
            }
        }
    }
}
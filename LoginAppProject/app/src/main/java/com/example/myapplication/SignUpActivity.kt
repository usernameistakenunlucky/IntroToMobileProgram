package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val usernameInput = findViewById<EditText>(R.id.usernameSignUpText_id)
        val emailInput = findViewById<EditText>(R.id.emailSignUpText_id)
        val passwordInput = findViewById<EditText>(R.id.passwordSignUpText_id)
        val signUpButton = findViewById<Button>(R.id.signUpButton_id)
        val signUpError = findViewById<TextView>(R.id.signUpErrorText_id)
        val confirmInput = findViewById<EditText>(R.id.passwordVerifySignUpText_id)
        val loginLink = findViewById<Button>(R.id.loginLink_id)

        signUpButton.setOnClickListener()
        {
            val newUser = User(
                usernameInput.text.toString(),
                emailInput.text.toString(),
                passwordInput.text.toString()
            )

            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("name", newUser.name)
            startActivity(intent)
        }

        signUpButton.setOnClickListener()
        {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val emailTaken = AppData.users.any { it.email == email }

            if (emailTaken)
            {
                signUpError.text = "An account with that email already exists"
                signUpError.visibility = View.VISIBLE
            }
            else if (password != confirmInput.text.toString())
            {
                signUpError.text = "Passwords do not match"
                signUpError.visibility = View.VISIBLE
            }
            else
            {
                val newUser = User(usernameInput.text.toString(), email, password)
                AppData.users += newUser

                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("name", newUser.name)
                startActivity(intent)
            }
        }

        loginLink.setOnClickListener()
        {
            finish()
        }
    }
}
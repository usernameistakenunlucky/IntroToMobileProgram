package com.example.myweek2app

import android.content.Intent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View

// class extensions: (since it has HomeActivity.*** it can extend this function to the class)
fun HomeActivity.keysFun(): View.OnKeyListener {
    return View.OnKeyListener { _, keyCode, _ ->

        if (keyCode == KEYCODE_ENTER) {
            val intent = Intent(
                this,
                LoginActivity::class.java
            )
            intent.putExtra("myKey", nameEditText.text.toString())
            startActivity(intent)
            true
        }

        false
    }
}
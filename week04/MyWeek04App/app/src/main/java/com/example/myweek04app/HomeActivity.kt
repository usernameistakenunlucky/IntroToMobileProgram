package com.example.myweek04app

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(), FragmentListener {
    override fun removeFragment() // require function
    {
        val frag = supportFragmentManager.findFragmentByTag("FreeTag")

        if (frag != null) {
            supportFragmentManager.beginTransaction()
                .remove(frag)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        // layout inflation
        // wee need to have a few things
        // a) a container where the new layout will attach top
        // b) we need to know


        val container = findViewById<FrameLayout>(R.id.containerLayout_id)

        val extra = layoutInflater.inflate(
            R.layout.extra_view,
            container,
            false
        )

        // button.setOnClickListener {}
        container.addView(extra)
        // ABOVE


        // For Fragment
        val fragContainer = findViewById<FrameLayout>(R.id.fragmentContainer_id)
        val loadFragmentButton = findViewById<Button>(R.id.loadFragmentButton_id)
        loadFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fragmentContainer_id,
                    MyFragment(),
                    "FreeTag"
                )
                .commit()
        }

        val removeFragmentButton = findViewById<Button>(R.id.removeFragmentButton_id)
        removeFragmentButton.setOnClickListener {

        }
    }
}

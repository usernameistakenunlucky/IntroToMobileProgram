package com.example.myweek04app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

interface FragmentListener
{
    fun removeFragment()
}

class MyFragment: Fragment()
{
    // you need a listener
    lateinit var listener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentListener)
            listener = context // our listener is the context where you are looking
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val fragLayout = inflater.inflate(R.layout.fragment_layout,
            container,
            false)

        val removeMeButton = fragLayout.findViewById<Button>(R.id.removeMeButton_id)
        removeMeButton.setOnClickListener{
            listener.removeFragment()
        }

        return fragLayout;
    }
}
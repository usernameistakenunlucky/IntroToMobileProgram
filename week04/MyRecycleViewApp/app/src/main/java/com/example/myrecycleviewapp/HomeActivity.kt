package com.example.myrecycleviewapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewDebug
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AppData
{
    companion object
    {
        val countries = arrayOf("Canada", "USA", "Mexico", "Brazil",
            "Argentina", "Ecuador", "Germany", "Netherlands", "Russia",
            "Japan", "China", "UK", "India", "Columbia", "Venezuela",
            "Peru", "Guatemala")
    }
}



class HomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        val countriesRv = findViewById<RecyclerView>(R.id.countriesRv_id)
        countriesRv.layoutManager = LinearLayoutManager(this)
        countriesRv.adapter = SimpleAdapter()

    }
}

class SimpleViewHolder (val root: TextView) : RecyclerView.ViewHolder(root)

class SimpleAdapter(): RecyclerView.Adapter<SimpleViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SimpleViewHolder
    {
        // what should we build for the few rows that are to be used and recycled
        val txtView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_row,
                parent,
                false)

        return SimpleViewHolder(txtView as TextView)
    }

    override fun onBindViewHolder(viewHolder: SimpleViewHolder, position: Int)
    {
        // when you want to display each row, what do you want to see
        viewHolder.root.text = AppData.countries[position]
    }

    override fun getItemCount(): Int
    {
        return AppData.countries.size
    }
}
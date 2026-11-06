package com.example.myapplication

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // *** keeps the Log Out button out from under the status bar,
        // *** and pushes the Add Item bar up above the keyboard when it opens
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // back to login screen if no one logged in
        val user = AppData.currentUser
        if (user == null)
        {
            goToLogin()
            return
        }

        val logoutButton = findViewById<TextView>(R.id.logoutButton_id)
        val profileButton = findViewById<ImageButton>(R.id.profileButton_id)
        val homeTitleText = findViewById<TextView>(R.id.homeTitleText_id)
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv_id)
        val newItemText = findViewById<EditText>(R.id.newItemText_id)
        val addItemButton = findViewById<Button>(R.id.addItemButton_id)
        val homeErrorText = findViewById<TextView>(R.id.homeErrorText_id)

        homeTitleText.text = "${user.name}'s List"

        // same as week04 in-class code
        val adapter = ItemAdapter(user.items)
        itemsRv.layoutManager = LinearLayoutManager(this)
        itemsRv.adapter = adapter

        addItemButton.setOnClickListener()
        {
            // *** trim() removes spaces at the start/end so "  milk " counts as "milk"
            val name = newItemText.text.toString().trim()
            val error = validateItem(name, user.items)

            if (error != null)
            {
                homeErrorText.text = error
                homeErrorText.visibility = View.VISIBLE
            }
            else
            {
                homeErrorText.visibility = View.GONE
                user.items.add(Item(name))

                // tell RecyclerView theres a new row, then scroll
                adapter.notifyItemInserted(user.items.size - 1)
                itemsRv.scrollToPosition(user.items.size - 1)
                newItemText.text.clear()
            }
        }

        logoutButton.setOnClickListener()
        {
            AppData.currentUser = null
            goToLogin()
        }

        profileButton.setOnClickListener()
        {
            // WelcomeActivity = profile page
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("name", user.name)
            startActivity(intent)
        }
    }

    // *** the two flags wipe the back stack, so pressing Back after logging out
    // *** can't bring you back into someone's list
    private fun goToLogin()
    {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    // return error message if invalid item name
    private fun validateItem(name: String, items: List<Item>): String?
    {
        if (name.isEmpty())
        {
            return "Item can't be empty"
        }

        // *** only allow letters, numbers, spaces and - ' , . &
        if (!name.matches(Regex("[A-Za-z0-9 ',.&-]+")))
        {
            return "Only letters, numbers, spaces and - ' , . & allowed"
        }

        // ignores case
        if (items.any { it.name.equals(name, ignoreCase = true) })
        {
            return "That item is already on your list"
        }

        return null
    }
}

// *** holds the 3 views inside one row
class ItemViewHolder(val root: View) : RecyclerView.ViewHolder(root)
{
    val itemCheckBox: CheckBox = root.findViewById(R.id.itemCheckBox_id)
    val itemNameText: TextView = root.findViewById(R.id.itemNameText_id)
    val deleteItemButton: ImageButton = root.findViewById(R.id.deleteItemButton_id)
}

class ItemAdapter(private val items: ArrayList<Item>) : RecyclerView.Adapter<ItemViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        // inflate item_row
        val row = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row,
                parent,
                false)

        return ItemViewHolder(row)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int)
    {
        val item = items[position]
        viewHolder.itemNameText.text = item.name

        // *** rows get RECYCLED: this row might still have the last item's listener on it.
        // *** remove it first, or setting isChecked below would change the wrong item
        viewHolder.itemCheckBox.setOnCheckedChangeListener(null)
        viewHolder.itemCheckBox.isChecked = item.isChecked
        showCrossedOff(viewHolder, item.isChecked)

        viewHolder.itemCheckBox.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
            showCrossedOff(viewHolder, isChecked)
        }

        viewHolder.deleteItemButton.setOnClickListener()
        {
            // ask for current position
            val pos = viewHolder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION)
            {
                items.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    private fun showCrossedOff(viewHolder: ItemViewHolder, crossed: Boolean)
    {
        val text = viewHolder.itemNameText
        if (crossed)
        {
            // line through the text + grey.
            text.paintFlags = text.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            text.setTextColor(0xFF9E9E9E.toInt())
        }
        else
        {
            // black text
            text.paintFlags = text.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            text.setTextColor(0xFF000000.toInt())
        }
    }
}
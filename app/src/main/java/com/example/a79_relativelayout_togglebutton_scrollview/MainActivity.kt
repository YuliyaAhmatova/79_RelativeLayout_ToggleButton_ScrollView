package com.example.a79_relativelayout_togglebutton_scrollview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var titleTV: TextView
    private lateinit var bookTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        titleTV = findViewById(R.id.titleTV)
        bookTV = findViewById(R.id.bookTV)
    }

    @SuppressLint("SetTextI18n")
    fun onToggleClick(view: View) {
        val on = (view as ToggleButton).isChecked
        if (on) {
            val dataBase = DataBase()
            val text = loadBook(dataBase.text)
            bookTV.text = ""
            for (i in text) {
                bookTV.append(i)
            }
        } else {
            bookTV.text = ""
        }
    }

    fun loadBook(text: String): List<String> {
        val list: MutableList<String> = mutableListOf()
        for (i in text) {
            list.add(i.toString())
        }
        return list
    }
}
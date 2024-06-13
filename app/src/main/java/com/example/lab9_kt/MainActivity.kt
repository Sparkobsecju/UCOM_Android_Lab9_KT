package com.example.lab9_kt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val FILE_NAME = "main_settings"
        const val KEY1 = "greeting"
    }

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        editText = findViewById(R.id.editText)
        button1.setOnClickListener { writeToSharedPreference() }
    }

    private fun writeToSharedPreference() {
        val preferences = getSharedPreferences(FILE_NAME, 0)
        val edit = preferences.edit()
        edit.putString(KEY1, editText.text.toString())
        edit.apply()
        Toast.makeText(this, "shared preference 寫入成功", Toast.LENGTH_SHORT).show()
    }
}
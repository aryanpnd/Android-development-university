package com.example.ca1myntralogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var input1 = findViewById<EditText>(R.id.input1)
        var input2 = findViewById<EditText>(R.id.input2)
        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this, input1.text, Toast.LENGTH_SHORT).show()
        }
    }
}
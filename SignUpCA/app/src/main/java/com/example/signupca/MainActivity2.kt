package com.example.signupca

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val name = intent.getStringExtra("name")
        val gender = intent.getStringExtra("gender")
        Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
        val data  = findViewById<TextView>(R.id.data)
        data.text = "Name: $name Gender: $gender"

    }
}
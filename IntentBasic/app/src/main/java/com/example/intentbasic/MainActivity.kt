package com.example.intentbasic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var input1 = findViewById<EditText>(R.id.input1)
        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this, input1.text, Toast.LENGTH_SHORT).show()
            // navigate to main activity 2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
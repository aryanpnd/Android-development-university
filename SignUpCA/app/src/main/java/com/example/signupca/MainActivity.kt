package com.example.signupca

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val gender = findViewById<EditText>(R.id.gender)

        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", name.text.toString())
            intent.putExtra("gender", gender.text.toString())
            startActivity(intent)
            Log.d("MainActivity", "Name: ${name.text}, Gender: ${gender.text}")
        }

    }
}
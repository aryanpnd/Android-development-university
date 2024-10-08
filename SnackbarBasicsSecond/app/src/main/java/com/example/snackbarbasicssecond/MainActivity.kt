package com.example.snackbarbasicssecond

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<MaterialButton>(R.id.startButton)
        val username = findViewById<EditText>(R.id.username)

        loginButton.setOnClickListener {
            val name = username.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, DepartmentSelect::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
                finish()
            } else {
                username.error = "Please enter your name"
            }
        }
    }
}
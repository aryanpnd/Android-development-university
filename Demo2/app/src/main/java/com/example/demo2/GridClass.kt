package com.example.demo2

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GridClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_class)

        var button = findViewById<ImageButton>(R.id.imageButton3)
        button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Information")
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

        }


    }
}
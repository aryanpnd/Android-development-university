package com.example.demo2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var editText = findViewById<EditText>(R.id.editTextText)
        var editText2 = findViewById<EditText>(R.id.editTextText2)
        var button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView)
        var textView2 = findViewById<TextView>(R.id.textView2)

        button.setOnClickListener{
            var a = editText.text.toString()
            var b = editText2.text.toString()
            textView.text="Your name is "+a
            textView2.text="Your number is "+a

            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Information")
                .setMessage("Your name is $a and your number is $b")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

            alertDialog.show()
        }
    }
}
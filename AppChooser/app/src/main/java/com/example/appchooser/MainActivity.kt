package com.example.appchooser

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)

        val shareButton = findViewById<Button>(R.id.share_button)

        shareButton.setOnClickListener {
            val selectedQuotes = StringBuilder()

            if (checkBox1.isChecked) {
                selectedQuotes.append("${checkBox1.text}\n")
            }
            if (checkBox2.isChecked) {
                selectedQuotes.append("${checkBox2.text}\n")
            }
            if (checkBox3.isChecked) {
                selectedQuotes.append("${checkBox3.text}\n")
            }
            if (checkBox4.isChecked) {
                selectedQuotes.append("${checkBox4.text}\n")
            }

            if (selectedQuotes.isEmpty()) {
                selectedQuotes.append("No quotes selected.")
            }

            ShareText(selectedQuotes.toString().trim())
        }
    }

    fun ShareText(message: String) {
        val send: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        val chooser = Intent.createChooser(send, "Share via")
        startActivity(chooser)
    }
}

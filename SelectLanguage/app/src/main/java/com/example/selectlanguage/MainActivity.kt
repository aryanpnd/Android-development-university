package com.example.selectlanguage

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import com.example.selectlanguage.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val openDialogButton = findViewById<Button>(R.id.button)
        openDialogButton.setOnClickListener {
            showLanguageSelectionDialog()
        }
    }

    private fun showLanguageSelectionDialog() {
        // Inflate the custom dialog layout
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_select_language, null)
        val dialog = Dialog(this)
        dialog.setContentView(dialogView)

        // Set click listeners for each language
        val englishTextView = dialogView.findViewById<TextView>(R.id.language_english)
        val spanishTextView = dialogView.findViewById<TextView>(R.id.language_spanish)
        val frenchTextView = dialogView.findViewById<TextView>(R.id.language_french)

        englishTextView.setOnClickListener {
            Toast.makeText(this, "Selected language: English", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        spanishTextView.setOnClickListener {
            Toast.makeText(this, "Selected language: Spanish", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        frenchTextView.setOnClickListener {
            Toast.makeText(this, "Selected language: French", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        // Show the dialog
        dialog.show()
    }
}

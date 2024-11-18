package com.example.activityselectlanguage

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            showLanguageSelectionDialog()
        }

    }
    private fun showLanguageSelectionDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_select_language, null)

        val languages = listOf("English", "Spanish", "French", "German", "Chinese", "Japanese")

        val listView = dialogView.findViewById<ListView>(R.id.languageListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        listView.adapter = adapter

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedLanguage = languages[position]
            Toast.makeText(this, "Selected language: $selectedLanguage", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}
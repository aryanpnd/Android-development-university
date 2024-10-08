package com.example.spinner

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinationSpinner: Spinner = findViewById(R.id.spinner)
        val packageListView: ListView = findViewById(R.id.list_item)
        val destinations = arrayOf("Paris", "London", "New York", "Tokyo", "Delhi")
        val packagesOfParis = arrayOf("Eiffel Tower", "Louvre Museum", "Arc de Triomphe")
        val packagesOfLondon = arrayOf("Big Ben", "Buckingham Palace", "Tower of London")
        val packagesOfNewYork = arrayOf("Statue of Liberty", "Empire State Building", "Central Park")
        val packagesOfTokyo = arrayOf("Tokyo Tower", "Shibuya Crossing", "Akihabara")
        val packagesOfDelhi = arrayOf("Red Fort", "Qutub Minar", "India Gate")

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinationSpinner.adapter = spinnerAdapter

        val initialAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, packagesOfParis)
        packageListView.adapter = initialAdapter

        destinationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedPackages = when (position) {
                    0 -> packagesOfParis
                    1 -> packagesOfLondon
                    2 -> packagesOfNewYork
                    3 -> packagesOfTokyo
                    4 -> packagesOfDelhi
                    else -> emptyArray()
                }
                val listAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, selectedPackages)
                packageListView.adapter = listAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        packageListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedPackage = packageListView.getItemAtPosition(position).toString()
            Toast.makeText(this, "Clicked on: $selectedPackage", Toast.LENGTH_SHORT).show()
        }
    }
}

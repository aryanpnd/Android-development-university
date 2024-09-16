package com.example.checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var submitButton = findViewById<Button>(R.id.button_submit)
        submitButton.setOnClickListener {
            if (findViewById<RadioGroup>(R.id.radioGroupOutlet).checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select your outlet", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (findViewById<RadioGroup>(R.id.radioGroupPizza).checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select your pizza", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            clearRadioButtons()
            clearCheckBoxes()

            Toast.makeText(this, "Your order has been placed successfully", Toast.LENGTH_SHORT).show()
        }

    }

    private fun clearCheckBoxes() {
        var extraCheeseCheckBox = findViewById<CheckBox>(R.id.checkbox_extra_cheese)
        if (extraCheeseCheckBox.isChecked) {
            extraCheeseCheckBox.isChecked = false
        }
    }

    private fun clearRadioButtons() {
        var outletRadioGroup = findViewById<RadioGroup>(R.id.radioGroupOutlet)
        outletRadioGroup.clearCheck()

        var pizzaRadioGroup = findViewById<RadioGroup>(R.id.radioGroupPizza)
        pizzaRadioGroup.clearCheck()
    }

}
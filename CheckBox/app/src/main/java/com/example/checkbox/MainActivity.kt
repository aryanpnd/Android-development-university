package com.example.checkbox

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.button_submit)
        submitButton.setOnClickListener {
            val outletRadioGroup = findViewById<RadioGroup>(R.id.radioGroupOutlet)
            val pizzaRadioGroup = findViewById<RadioGroup>(R.id.radioGroupPizza)

            // Check if outlet and pizza are selected
            if (outletRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select your outlet", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pizzaRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select your pizza", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Get selected outlet
            val selectedOutletId = outletRadioGroup.checkedRadioButtonId
            val selectedOutletButton = findViewById<RadioButton>(selectedOutletId)
            val selectedOutlet = selectedOutletButton.text.toString()

            // Get selected pizza
            val selectedPizzaId = pizzaRadioGroup.checkedRadioButtonId
            val selectedPizzaButton = findViewById<RadioButton>(selectedPizzaId)
            val selectedPizza = selectedPizzaButton.text.toString()

            // Get selected toppings
            val toppings = mutableListOf<String>()
            val toppingCheckBoxIds = listOf(
                R.id.checkbox_mushrooms,
                R.id.checkbox_peppers,
                R.id.checkbox_olives,
                R.id.checkbox_onions
            )
            toppingCheckBoxIds.forEach { id ->
                val checkBox = findViewById<CheckBox>(id)
                if (checkBox.isChecked) {
                    toppings.add(checkBox.text.toString())
                }
            }

            // Prepare the order summary
            val toppingsString = if (toppings.isNotEmpty()) toppings.joinToString(", ") else "None"
            val orderSummary = """
                Outlet: $selectedOutlet
                Pizza: $selectedPizza
                Extra Cheese: ${findViewById<CheckBox>(R.id.checkbox_extra_cheese).isChecked}
                Toppings: $toppingsString
            """.trimIndent()

            // Show the order summary in an alert dialog
            AlertDialog.Builder(this)
                .setTitle("Order Summary")
                .setMessage(orderSummary)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                    clearSelections()
                    Toast.makeText(this, "Your order has been placed successfully", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    private fun clearSelections() {
        // Clear radio buttons
        val outletRadioGroup = findViewById<RadioGroup>(R.id.radioGroupOutlet)
        val pizzaRadioGroup = findViewById<RadioGroup>(R.id.radioGroupPizza)
        outletRadioGroup.clearCheck()
        pizzaRadioGroup.clearCheck()

        // Clear checkboxes
        val checkBoxIds = listOf(
            R.id.checkbox_extra_cheese,
            R.id.checkbox_mushrooms,
            R.id.checkbox_peppers,
            R.id.checkbox_olives,
            R.id.checkbox_onions
        )
        checkBoxIds.forEach { id ->
            val checkBox = findViewById<CheckBox>(id)
            if (checkBox.isChecked) {
                checkBox.isChecked = false
            }
        }
    }
}

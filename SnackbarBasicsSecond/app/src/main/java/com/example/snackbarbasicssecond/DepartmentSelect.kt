package com.example.snackbarbasicssecond

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DepartmentSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department_select)

        val username = intent.getStringExtra("name")
        val welcomeText = findViewById<TextView>(R.id.username)
        welcomeText.text = username

        // Call method to set up click listeners for the cards
        setupCardClickListioner()
    }

    private fun setupCardClickListioner(){
        val card1 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_1)
        val card2 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_2)
        val card3 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_3)
        val card4 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_4)
        val card5 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_5)
        val card6 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_6)
        val card7 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_7)
        val card8 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_8)
        val card9 = findViewById<androidx.cardview.widget.CardView>(R.id.department_image_9)

        // Define the image resource IDs
        val imageResources = listOf(
            R.drawable.department_image_1,
            R.drawable.department_image_2,
            R.drawable.department_image_3,
            R.drawable.department_image_4,
            R.drawable.department_image_5,
            R.drawable.department_image_6,
            R.drawable.department_image_7,
            R.drawable.department_image_8,
            R.drawable.department_image_9
        )

        // Set click listeners for each card
        val cards = listOf(card1, card2, card3, card4, card5, card6, card7, card8, card9)
        for (i in cards.indices) {
            cards[i].setOnClickListener {
                val intent = Intent(this, DepartmentDetailActivity::class.java)
                intent.putExtra("imageResId", imageResources[i]) // Pass the actual image resource ID
                startActivity(intent)
            }
        }
    }
}

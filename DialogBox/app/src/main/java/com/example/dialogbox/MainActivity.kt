package com.example.dialogbox

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val open_dialog = findViewById<Button>(R.id.open_dialog_button)
        val app_closing_timer = findViewById<TextView>(R.id.app_closing_time_text)
        open_dialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Alert")
            dialog.setMessage("Are you sure you want to exit the app?")
            dialog.setPositiveButton("Yes") { _, _ ->
                finish()
            }
            dialog.setNegativeButton("after 5s") { _, _ ->
                for (i in 1..5) {
                    Thread.sleep(1000)
                    app_closing_timer.text = "after ${i*1000} s"
                }
                finish()
            }
            dialog.setNeutralButton("Cancel") { _, _ ->
                // Do nothing
            }
            dialog.setCancelable(false)
            dialog.show()
        }

        val give_rating = findViewById<Button>(R.id.give_rating_button)
        give_rating.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Rating")
            dialog.setMessage("Do you want to rate our app?")
            dialog.setPositiveButton("Yes") { _, _ ->
                val dialog = Dialog(this)

                dialog.show()
            }
        }

    }

}
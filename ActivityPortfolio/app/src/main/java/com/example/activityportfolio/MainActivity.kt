package com.example.activityportfolio

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        when (item.itemId) {
            R.id.email -> {
                sendEmail()
                return true
            }
            R.id.contact -> {
                contactDeveloper()
            }
            R.id.feedback -> {
                feedback()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    fun sendEmail() {
        val intent = android.content.Intent(android.content.Intent.ACTION_SENDTO)
        intent.data = android.net.Uri.parse("mailto:")
        intent.putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf("captainaryan9870@gmail.com"))
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Contacting you from Portfolio")
        startActivity(intent)
    }

    fun contactDeveloper(){
        val intent = android.content.Intent(android.content.Intent.ACTION_DIAL)
        intent.data = android.net.Uri.parse("tel:9999999999")
        startActivity(intent)
        }

    fun feedback(){
        return
    }

}
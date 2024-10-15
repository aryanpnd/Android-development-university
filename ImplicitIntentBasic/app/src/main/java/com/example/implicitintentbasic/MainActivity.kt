package com.example.implicitintentbasic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons
        val buttonURL = findViewById<Button>(R.id.open_url)
        val buttonNavigate = findViewById<Button>(R.id.button_navigate)
        val buttonCamera = findViewById<Button>(R.id.button_camera)
        val buttonCall = findViewById<Button>(R.id.button_call)
        val buttonContacts = findViewById<Button>(R.id.button_contacts)
        val buttonGallery = findViewById<Button>(R.id.button_gallery)
        val buttonDialer = findViewById<Button>(R.id.button_dialer)

        // Register a result launcher for picking images or videos
        val pickMediaLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                val selectedMediaUri: Uri? = result.data?.data
                // Handle the chosen image or video Uri here
            }
        }

        // Open URL
        buttonURL.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }

        // Navigate to a location (example: Google Maps)
        buttonNavigate.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        // Open Camera
        buttonCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // Dial a number
        buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:8910486736"))
            startActivity(intent)
        }

        // View Contacts
        buttonContacts.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }

        // Open native image and video picker with bottom sheet-style UI
        buttonGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/* video/*"
            pickMediaLauncher.launch(intent)
        }

        // Open Dialer
        buttonDialer.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }
    }
}

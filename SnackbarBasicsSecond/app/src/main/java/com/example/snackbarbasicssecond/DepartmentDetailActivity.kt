package com.example.snackbarbasicssecond

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DepartmentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department_detail)

        val imageView = findViewById<ImageView>(R.id.departmentImageView)

        // Get the image resource ID from the intent
        val imageResId = intent.getIntExtra("imageResId", -1)
        if (imageResId != -1) {
            imageView.setImageResource(imageResId) // Set the image resource
        }
    }
}

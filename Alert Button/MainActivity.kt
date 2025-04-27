package com.example.simplealertbutton

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val alertBtn = findViewById<Button>(R.id.alertBtn)

        alertBtn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Basic Alert")
                .setPositiveButton("ok",null)
                .show()

        }

    }
}


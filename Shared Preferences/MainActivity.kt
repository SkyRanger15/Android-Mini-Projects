package com.example.sharedpref

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sharedpref.ui.theme.SharedprefTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val loadButton = findViewById<Button>(R.id.loadButton)
        val displayName = findViewById<TextView>(R.id.displayName)

        val sharePref = getSharedPreferences("mypred",Context.MODE_PRIVATE)


        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val editor = sharePref.edit()
            editor.putString("name_key",name)
            editor.apply()
            Toast.makeText(this, "Name Saved", Toast.LENGTH_SHORT).show()
        }

        loadButton.setOnClickListener{
            val savedName = sharePref.getString("name_key","No Name Found")
            displayName.text = savedName
        }
    }
}


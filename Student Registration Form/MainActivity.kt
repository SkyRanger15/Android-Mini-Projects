package com.example.studregform

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
import com.example.studregform.ui.theme.StudRegFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        val name = findViewById<EditText>(R.id.nameInput)
        val email = findViewById<EditText>(R.id.emailInput)
        val phone = findViewById<EditText>(R.id.phoneInput)
        val register = findViewById<Button>(R.id.registerButton)

        register.setOnClickListener {

            val nameText = name.text.toString().trim()
            val emailText = email.text.toString().trim()
            val phoneText = phone.text.toString().trim()

            if(nameText.isEmpty()||emailText.isEmpty()||phoneText.isEmpty()){
                Toast.makeText(this, "Pls fill all the fields", Toast.LENGTH_SHORT).show()
            }
            else if(!emailText.contains("@") || !emailText.contains(".")){
                Toast.makeText(this, "Pls enter a valid email", Toast.LENGTH_SHORT).show()
            }
            else if(phoneText.length != 10){
                Toast.makeText(this, "Pls enter a valid phone number", Toast.LENGTH_SHORT).show()
            }


            else{
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()
            }
        }

    }
}


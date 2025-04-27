package com.example.multiplicationtableapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.text
import androidx.compose.ui.tooling.preview.Preview
import com.example.multiplicationtableapp.ui.theme.MultiplicationTableAPPTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbereditText = findViewById<EditText>(R.id.numbereditText)
        val calcbutton = findViewById<Button>(R.id.calcbutton)
        val tableview = findViewById<TextView>(R.id.tableview)

        calcbutton.setOnClickListener {
            val numberString = numbereditText.text.toString()

            if (numberString.isEmpty()) {
                tableview.text = "Please enter a number"
                return@setOnClickListener
            }

            val number = numberString.toInt()

            val table = StringBuilder()

            for (i in 1..10){
                table.append("$number X $i = ${number*i}\n")
            }
            tableview.text  = table.toString()


        }


    }
}


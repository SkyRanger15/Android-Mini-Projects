package com.example.tempconvt

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.tempconvt.ui.theme.TempConvtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val celciusInput = findViewById<EditText>(R.id.enterDeg)
        val convertBtn = findViewById<Button>(R.id.convert)
        val fahOutput = findViewById<TextView>(R.id.resultinF)

        convertBtn.setOnClickListener {
            val celciustext = celciusInput.text.toString()

            val cel = celciustext.toFloat()
            val fah = (cel * 9/5) + 32
            fahOutput.text = "$fah °F"


        }

    }
}


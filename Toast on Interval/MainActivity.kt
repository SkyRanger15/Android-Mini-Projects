package com.example.intervaltoast

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
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
import com.example.intervaltoast.ui.theme.IntervalToastTheme

class MainActivity : ComponentActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val interval: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler(Looper.getMainLooper())

        val startToast = findViewById<Button>(R.id.startToast)

        startToast.setOnClickListener {
            runnable = Runnable{
                Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT).show()
                handler.postDelayed(runnable,interval)
            }
        handler.postDelayed(runnable,interval)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}


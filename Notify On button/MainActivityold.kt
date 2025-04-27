package com.example.notifybutton

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notifybutton.ui.theme.NotifyButtonTheme

class MainActivity : ComponentActivity() {

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        createNotificationChannel()

        val buttonNotify = findViewById<Button>(R.id.buttonNotify)

        buttonNotify.setOnClickListener {
            shownotification()
        }
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "channel_id",
                "My Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )



        }
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun shownotification(){
        val notification = NotificationCompat.Builder(this,"channel_id")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Simple Notification")
            .setContentText("This is a notification example.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(this).notify(1,notification)
    }
}


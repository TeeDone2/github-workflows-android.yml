package com.jarvisx.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log

class VoiceHotwordService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        startForeground(1001, ensureChannel())
        Log.i("JarvisX", "VoiceHotwordService started (placeholder). Implement wake-word + VAD here.")
    }

    private fun ensureChannel(): Notification {
        val channelId = "jarvisx_voice"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val chan = NotificationChannel(channelId, "JarvisX Voice", NotificationManager.IMPORTANCE_LOW)
            val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(chan)
        }
        val builder = Notification.Builder(this, channelId)
            .setContentTitle("JarvisX listening")
            .setContentText("Voice wake-word active")
            .setSmallIcon(android.R.drawable.ic_btn_speak_now)
        return builder.build()
    }
}
package com.bluecode.PhraseDaily.presentation.Utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object createNotification {

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Channel"
            val descriptionText = "This is a sample notification channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("notify_channel", name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
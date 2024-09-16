package com.bluecode.PhraseDaily.domain.workers

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bluecode.PhraseDaily.domain.repositories.EnglishRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay


@HiltWorker
    class NotificationsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
     val repository: EnglishRepository
    ) : CoroutineWorker(context, workerParams) {

        override suspend fun doWork(): Result {

            Log.d("NAJIB", "INICIO DE WORKER")
            // Simulating some work
            delay(3000)

            Log.d("NAJIB", repository.getPhrasalVerbs().toString())

            return Result.success()
        }


        // Method to create and show the notification
        @SuppressLint("MissingPermission")
        private fun showNotification() {
            val notificationId = 1
            val channelId = "worker_channel"
            val notificationTitle = "Worker Notification"
            val notificationText = "The worker task is completed."

            // Create a notification channel for API 26+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelId,
                    "Worker Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "Channel for worker notifications"
                }

                // Register the channel with the system
                val notificationManager: NotificationManager =
                    applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }

            // Build the notification
            val builder = NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info) // Use your app icon here
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            // Show the notification
            with(NotificationManagerCompat.from(applicationContext)) {
                notify(notificationId, builder.build())
            }
        }

    }

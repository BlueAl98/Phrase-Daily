package com.bluecode.PhraseDaily.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.bluecode.PhraseDaily.domain.workers.NotificationsWorker
import com.bluecode.PhraseDaily.presentation.navigation.Navigation
import com.bluecode.PhraseDaily.presentation.ui.theme.BaseProyectTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val notificationWorkRequest = OneTimeWorkRequestBuilder<NotificationsWorker>()
        WorkManager.getInstance(this).enqueue(notificationWorkRequest.build())
        setContent {
            BaseProyectTheme {
                Navigation()
            }
        }
    }
}


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
import com.bluecode.PhraseDaily.presentation.Utils.Utils
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import javax.inject.Inject


@HiltWorker
    class NotificationsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
     val repository: EnglishRepository
    ) : CoroutineWorker(context, workerParams) {

        override suspend fun doWork(): Result {

        val lista = repository.getPhrasalVerbs()

       lista.collect{
           Log.d("TAG", "doWork: $it")
       }
     //  Utils.showNotification(applicationContext,
       //    "Daily Phrase", lista[0].phrase_esp + " " + lista[0].phrase_eng)

            return Result.success()
        }



    }

package com.bluecode.PhraseDaily.domain.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bluecode.PhraseDaily.domain.repositories.PhrasalVerbRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
    class NotificationsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
     val repository: PhrasalVerbRepository
    ) : CoroutineWorker(context, workerParams) {

        override suspend fun doWork(): Result {

        val lista = repository.getPhrasalVerbs()

      lista.collect {
          if (it.isNotEmpty()) {
              Log.d("TAG", "doWork: $it")
          }
      }
     //  Utils.showNotification(applicationContext,
       //    "Daily Phrase", lista[0].phrase_esp + " " + lista[0].phrase_eng)

            return Result.success()
        }



    }

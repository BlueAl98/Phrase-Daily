package com.bluecode.PhraseDaily.domain.workers

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bluecode.PhraseDaily.domain.repositories.DataStoreRepository
import com.bluecode.PhraseDaily.domain.repositories.PhrasalVerbRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@HiltWorker
    class NotificationsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
     val repository: PhrasalVerbRepository,
     val dataStoreRepository: DataStoreRepository
    ) : CoroutineWorker(context, workerParams) {

        @RequiresApi(Build.VERSION_CODES.O)
        override suspend fun doWork(): Result {

            val lista = repository.getPhrsalVerByCheck(false)
            val date = dataStoreRepository.getDate().first()
            // Formateador de fecha para convertir la cadena a LocalDate
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            // Fecha actual
            val currentDate = LocalDate.now()


            // Si existe una fecha guardada en DataStore, comparar
            if (!date.isNullOrEmpty()) {
                val savedDate = LocalDate.parse(date, formatter)

                Log.d("Najib", "doWork: $savedDate")
                Log.d("Najib", "doWork: $currentDate")

                // Comparar si la fecha guardada es anterior a la fecha actual
                if (savedDate.isEqual(currentDate)) {
                    Log.d("Najib", "La fecha guardada es anterior a la fecha actual.")

                    // Si la fecha guardada es de otro día, puedes tomar acciones como sobrescribir la fecha
                    dataStoreRepository.saveDate(currentDate.format(formatter))
                } else {
                    Log.d("Najib", "La fecha guardada es de hoy o posterior.")
                }
            } else {
                // Si no hay fecha guardada, guarda la fecha actual
                dataStoreRepository.saveDate(currentDate.format(formatter))
            }



            Log.d("Najib", "Najib: $date")


            // Luego recolectar la lista
            lista.collect { items ->
                if (items.isNotEmpty()) {
                    Log.d("Najib", "doWork: $items")
                }else{
                    Log.d("Najib", "doWork: Lista vacia")
                }
            }


     //  Utils.showNotification(applicationContext,
       //    "Daily Phrase", lista[0].phrase_esp + " " + lista[0].phrase_eng)

            return Result.success()
        }



    }

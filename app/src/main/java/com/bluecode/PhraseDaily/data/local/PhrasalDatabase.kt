package com.bluecode.PhraseDaily.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bluecode.PhraseDaily.data.local.dao.PhrasalVerbDao
import com.bluecode.PhraseDaily.data.local.entities.PhrasalVerbsEntity

@Database(entities = [PhrasalVerbsEntity::class], version = 2)
abstract class PhrasalDatabase : RoomDatabase() {
    abstract fun phrasalVerbDao(): PhrasalVerbDao
}
package com.armand.batikhub.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BatikHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun batikHistoryDao(): BatikHistoryDao
}
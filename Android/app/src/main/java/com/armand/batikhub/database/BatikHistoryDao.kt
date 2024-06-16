package com.armand.batikhub.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BatikHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(batikHistory: BatikHistory)

    @Query("SELECT * FROM batik_history")
    fun getAll(): List<BatikHistory>
}
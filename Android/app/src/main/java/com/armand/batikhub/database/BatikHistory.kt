package com.armand.batikhub.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "batik_history")
data class BatikHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageUri: String,
    val label: String,
    val percentage: Int,
    val date: String,
    val description: String
)
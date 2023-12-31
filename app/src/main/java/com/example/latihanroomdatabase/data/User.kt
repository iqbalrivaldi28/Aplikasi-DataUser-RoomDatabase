package com.example.latihanroomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fisrtName: String,
    val lastName: String,
    val age: Int
)

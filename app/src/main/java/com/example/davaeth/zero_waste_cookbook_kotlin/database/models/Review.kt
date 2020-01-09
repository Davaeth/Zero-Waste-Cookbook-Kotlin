package com.example.davaeth.zero_waste_cookbook_kotlin.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val description: String,
    val rate: Int
)

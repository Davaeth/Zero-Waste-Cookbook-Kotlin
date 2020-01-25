package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "difficulty_levels")
data class DifficultyLevel(
    @PrimaryKey val id: Int,
    val name: String
)
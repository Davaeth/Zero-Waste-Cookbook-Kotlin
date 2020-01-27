package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey val id: Int,
    val name: String,
    val recipeId: Int
)
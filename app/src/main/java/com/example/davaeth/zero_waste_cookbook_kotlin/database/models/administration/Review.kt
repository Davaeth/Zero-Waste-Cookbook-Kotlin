package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey val id: Int,
    val description: String,
    val rate: Int,
    val recipeId: Int,
    val ownerId: Int
)

package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey @NonNull val id: Int = 0,
    val prepTime: Int,
    val title: String,
    val description: String,
    val photoPath: String? = null,
    val rank: Double,
    val creationDate: Date,
    val ownerId: Int,
    val difficultyLevelId: Int,
    val regionId: Int
)
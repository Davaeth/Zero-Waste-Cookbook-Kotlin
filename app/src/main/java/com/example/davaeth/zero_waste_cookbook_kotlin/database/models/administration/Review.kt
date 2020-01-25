package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

@Entity(
    tableName = "reviews",
    foreignKeys = [
        ForeignKey(
            parentColumns = ["id"],
            entity = Recipe::class,
            childColumns = ["recipeId"]
        )
    ]
)
data class Review(
    @PrimaryKey val id: Int,
    val description: String,
    val rate: Int,
    val recipeId: Int,
    val ownerId: Int
)

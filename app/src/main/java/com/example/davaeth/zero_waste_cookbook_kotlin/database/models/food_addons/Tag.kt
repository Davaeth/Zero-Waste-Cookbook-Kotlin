package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

@Entity(
    tableName = "tags",
    foreignKeys = [ForeignKey(
        entity = Recipe::class,
        parentColumns = ["id"],
        childColumns = ["recipe"]
    )]
)
data class Tag(@PrimaryKey val id: Int, val name: String, val recipe: Int)
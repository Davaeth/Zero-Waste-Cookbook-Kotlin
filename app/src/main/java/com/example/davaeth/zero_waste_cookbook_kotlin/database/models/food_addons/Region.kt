package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "regions")
data class Region(
    @PrimaryKey val id: Int,
    val name: String
)
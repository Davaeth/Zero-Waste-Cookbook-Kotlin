package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class Ingredient(@PrimaryKey val id: Int, val name: String)
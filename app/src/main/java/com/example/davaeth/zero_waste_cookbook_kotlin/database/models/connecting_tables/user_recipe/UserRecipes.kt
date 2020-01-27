package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "user_recipes",
    primaryKeys = ["userId", "recipeId"]
)
data class UserRecipes(
    val userId: Int,
    @ColumnInfo(index = true) val recipeId: Int
)
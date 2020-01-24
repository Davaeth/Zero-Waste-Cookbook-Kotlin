package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.recipe_ingredient

import androidx.room.Entity

@Entity(
    tableName = "recipe_ingredients",
    primaryKeys = ["recipeId", "ingredientId"]
)
data class RecipeIngredients(
    val recipeId: Int,
    val ingredientId: Int
)
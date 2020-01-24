package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables

import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.DifficultyLevel

data class DifficultyLevelRecipes(
    @Embedded
    val difficultyLevel: DifficultyLevel,
    @Relation(
        parentColumn = "id",
        entity = Recipe::class,
        entityColumn = "difficultyLevelId"
    )
    val recipes: List<Recipe>
)
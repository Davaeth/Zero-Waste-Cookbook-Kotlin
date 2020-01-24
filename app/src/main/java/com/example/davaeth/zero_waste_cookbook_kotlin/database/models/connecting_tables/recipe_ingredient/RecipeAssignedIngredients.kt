package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.recipe_ingredient

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

data class RecipeAssignedIngredients(
    @Embedded
    val recipe: Recipe,
    @Relation(
        parentColumn = "id",
        entity = Ingredient::class,
        entityColumn = "id",
        associateBy = Junction(
            value = RecipeIngredients::class,
            parentColumn = "recipeId",
            entityColumn = "ingredientId"
        )
    )
    val ingredients: List<Ingredient>
)
package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.recipe_ingredient

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

data class AssignedIngredientRecipes(
    @Embedded
    val ingredient: Ingredient,
    @Relation(
        parentColumn = "id",
        entity = Recipe::class,
        entityColumn = "id",
        associateBy = Junction(
            value = RecipeIngredients::class,
            parentColumn = "ingredientId",
            entityColumn = "recipeId"
        )
    )
    val recipes: List<Recipe>
)
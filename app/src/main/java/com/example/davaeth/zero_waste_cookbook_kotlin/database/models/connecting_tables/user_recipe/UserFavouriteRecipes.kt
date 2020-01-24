package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

data class UserFavouriteRecipes(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entity = Recipe::class,
        entityColumn = "id",
        associateBy = Junction(
            value = UserRecipes::class,
            parentColumn = "userId",
            entityColumn = "recipeId"
        )
    )
    val recipes: List<Recipe>
)
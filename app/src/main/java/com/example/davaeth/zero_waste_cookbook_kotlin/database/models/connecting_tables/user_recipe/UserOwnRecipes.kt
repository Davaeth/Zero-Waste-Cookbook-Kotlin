package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe

import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

data class UserOwnRecipes(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entity = Recipe::class,
        entityColumn = "ownerId"
    )
    val recipes: List<Recipe>
)
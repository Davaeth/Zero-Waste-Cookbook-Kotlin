package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables

import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Tag

data class RecipeTags(
    @Embedded
    val recipe: Recipe,
    @Relation(
        parentColumn = "id",
        entity = Tag::class,
        entityColumn = "recipeId"
    )
    val tags: List<Tag>
)
package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.reviews

import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

data class RecipeReviews(
    @Embedded
    val recipe: Recipe,
    @Relation(
        parentColumn = "id",
        entity = Review::class,
        entityColumn = "recipeId"
    )
    val reviews: List<Review>
)
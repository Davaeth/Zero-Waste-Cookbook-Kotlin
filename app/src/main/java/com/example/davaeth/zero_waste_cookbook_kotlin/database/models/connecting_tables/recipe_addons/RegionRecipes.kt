package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.recipe_addons

import android.graphics.Region
import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

data class RegionRecipes(
    @Embedded
    val region: Region,
    @Relation(
        parentColumn = "id",
        entity = Recipe::class,
        entityColumn = "regionId"
    )
    val recipes: List<Recipe>
)
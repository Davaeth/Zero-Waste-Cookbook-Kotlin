package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.BaseRepository

interface RecipeRepository: BaseRepository<Recipe> {
    val newestRecipes: LiveData<List<Recipe>>
}
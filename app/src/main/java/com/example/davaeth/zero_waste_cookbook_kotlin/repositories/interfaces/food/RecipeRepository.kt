package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.BaseRepository

interface RecipeRepository: BaseRepository<Recipe> {
    val newestRecipes: LiveData<List<Recipe>>
}
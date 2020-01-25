package com.example.davaeth.zero_waste_cookbook_kotlin.repositories

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.RecipeDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) : BaseRepository<Recipe> {
    val newestRecipes: LiveData<List<Recipe>> = recipeDao.getNewestRecipes()

    override fun insert(entity: Recipe) {
        recipeDao.insert(entity)
    }
}
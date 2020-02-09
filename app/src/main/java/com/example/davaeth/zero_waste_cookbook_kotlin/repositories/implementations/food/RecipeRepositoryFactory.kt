package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.RecipeDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.RecipeRepository

class RecipeRepositoryFactory(private val recipeDao: RecipeDao) : RecipeRepository {
    override val newestRecipes: LiveData<List<Recipe>> = recipeDao.getNewestRecipes()
    override val entities: LiveData<List<Recipe>> = recipeDao.getAllRecipes()

    override fun insert(entity: Recipe) {
        recipeDao.insert(entity)
    }
}
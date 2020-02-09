package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.IngredientDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.IngredientRepository

class IngredientRepositoryFactory(private val ingredientDao: IngredientDao) : IngredientRepository {
    override val entities: LiveData<List<Ingredient>> = ingredientDao.getIngredients()

    override fun insert(entity: Ingredient) {
        ingredientDao.insert(entity)
    }
}
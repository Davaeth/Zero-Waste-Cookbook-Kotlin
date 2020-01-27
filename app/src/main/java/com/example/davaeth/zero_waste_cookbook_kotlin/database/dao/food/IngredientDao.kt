package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.BaseDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient

@Dao
interface IngredientDao: BaseDao<Ingredient> {
    @Query("SELECT * FROM ingredients ORDER BY name")
    fun getIngredients(): LiveData<List<Ingredient>>
}
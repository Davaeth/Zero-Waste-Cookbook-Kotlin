package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe

@Dao
interface RecipeDao : BaseDao<Recipe> {
    @Query("SELECT * FROM recipes ORDER BY datetime(creationDate)")
    fun getNewestRecipes(): LiveData<List<Recipe>>
}
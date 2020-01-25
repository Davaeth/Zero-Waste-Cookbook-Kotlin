package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.recipe_addons.DifficultyLevelRecipes

@Dao
interface DifficultyLevelRecipesDao {
    @Query("SELECT * FROM difficulty_levels WHERE name LIKE :difficultyLevelName")
    fun getDifficultyLevelRecipes(difficultyLevelName: String): LiveData<List<DifficultyLevelRecipes>>
}
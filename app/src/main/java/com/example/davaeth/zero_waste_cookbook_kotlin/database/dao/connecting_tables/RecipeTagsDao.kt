package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.RecipeTags

@Dao
interface RecipeTagsDao {
    @Transaction
    @Query("SELECT * FROM recipes WHERE id LIKE :recipeId LIMIT 5")
    fun getRecipeTags(recipeId: Int): LiveData<List<RecipeTags>>
}
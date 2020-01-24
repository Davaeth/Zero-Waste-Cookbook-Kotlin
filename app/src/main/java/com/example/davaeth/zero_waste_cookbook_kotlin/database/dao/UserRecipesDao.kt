package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.FavedRecipeUsers
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserFavouriteRecipes

@Dao
interface UserRecipesDao {
    @Query("SELECT * FROM users")
    fun getUserFavouriteRecipes(): LiveData<List<UserFavouriteRecipes>>

    @Query("SELECT * FROM recipes")
    fun getFavedRecipeUsers(): LiveData<List<FavedRecipeUsers>>
}

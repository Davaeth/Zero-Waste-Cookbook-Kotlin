package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.BaseDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.FavedRecipeUsers
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserFavouriteRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserRecipes

@Dao
interface UserRecipesDao: BaseDao<UserRecipes> {
    @Transaction
    @Query("SELECT * FROM users")
    fun getUserFavouriteRecipes(): LiveData<UserFavouriteRecipes>

    @Transaction
    @Query("SELECT * FROM recipes")
    fun getFavedRecipeUsers(): LiveData<FavedRecipeUsers>
}

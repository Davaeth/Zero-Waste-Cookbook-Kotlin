package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserOwnRecipes

@Dao
interface UserOwnRecipesDao {
    @Query("SELECT * FROM users")
    fun getUserOwnRecipes(): LiveData<List<UserOwnRecipes>>
}
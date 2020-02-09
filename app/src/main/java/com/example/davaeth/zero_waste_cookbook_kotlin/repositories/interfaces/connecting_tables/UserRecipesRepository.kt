package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.FavedRecipeUsers
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserFavouriteRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.BaseRepository

interface UserRecipesRepository: BaseRepository<UserRecipes> {
    val userFavouriteRecipes: LiveData<UserFavouriteRecipes>
    val favedUserRecipes: LiveData<FavedRecipeUsers>
}
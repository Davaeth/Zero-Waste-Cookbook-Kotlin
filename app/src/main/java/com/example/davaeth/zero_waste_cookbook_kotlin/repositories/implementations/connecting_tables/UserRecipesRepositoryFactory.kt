package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.connecting_tables

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.UserRecipesDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.FavedRecipeUsers
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserFavouriteRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables.UserRecipesRepository

class UserRecipesRepositoryFactory(private val userRecipesDao: UserRecipesDao) :
    UserRecipesRepository {
    override val userFavouriteRecipes: LiveData<UserFavouriteRecipes> =
        userRecipesDao.getUserFavouriteRecipes()
    override val favedUserRecipes: LiveData<FavedRecipeUsers> =
        userRecipesDao.getFavedRecipeUsers()

    override val entities: LiveData<List<UserRecipes>>
        get() = TODO("won't be implemented here")

    override fun insert(entity: UserRecipes) {
        userRecipesDao.insert(entity)
    }
}
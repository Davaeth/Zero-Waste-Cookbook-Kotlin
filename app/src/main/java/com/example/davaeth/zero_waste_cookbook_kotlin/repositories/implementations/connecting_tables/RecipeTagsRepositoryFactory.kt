package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.connecting_tables

import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.RecipeTagsDao
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.connecting_tables.RecipeTagsRepository

class RecipeTagsRepositoryFactory(private val recipeTagsDao: RecipeTagsDao) : RecipeTagsRepository {
    override fun getRecipeTags(recipeId: Int) = recipeTagsDao.getRecipeTags(recipeId)
}
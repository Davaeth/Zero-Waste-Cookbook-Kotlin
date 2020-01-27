package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.connecting_tables

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.RecipeTags

interface RecipeTagsRepository {
    fun getRecipeTags(recipeId: Int): LiveData<List<RecipeTags>>
}
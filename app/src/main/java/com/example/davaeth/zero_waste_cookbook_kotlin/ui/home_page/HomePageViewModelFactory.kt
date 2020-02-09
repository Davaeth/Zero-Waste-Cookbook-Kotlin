package com.example.davaeth.zero_waste_cookbook_kotlin.ui.home_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables.RecipeTagsRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.RecipeRepository

class HomePageViewModelFactory(
    private var recipeRepository: RecipeRepository,
    private var recipeTagsRepository: RecipeTagsRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            RecipeRepository::class.java,
            RecipeTagsRepository::class.java
        ).newInstance(recipeRepository, recipeTagsRepository)
}
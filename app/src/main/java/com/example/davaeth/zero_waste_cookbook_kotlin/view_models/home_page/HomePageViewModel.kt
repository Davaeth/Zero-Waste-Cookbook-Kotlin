package com.example.davaeth.zero_waste_cookbook_kotlin.view_models.home_page

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.davaeth.zero_waste_cookbook_kotlin.database.AppDatabase
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.RecipeRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.ReviewRepository
import kotlinx.coroutines.launch

class HomePageViewModel(private val application: Application) : ViewModel() {
    private var reviewRepository: ReviewRepository
    private var recipeRepository: RecipeRepository

    val allReviews: LiveData<List<Review>>
    val newestRecipes: LiveData<List<Recipe>>

    private val database: AppDatabase = AppDatabase.getDatabase(application)

    init {
        val reviewDao = database.reviewDao()
        val recipeDao = database.recipeDao()

        reviewRepository = ReviewRepository(reviewDao)
        recipeRepository = RecipeRepository(recipeDao)

        allReviews = reviewRepository.allReviews
        newestRecipes = recipeRepository.newestRecipes
    }

    fun insertReview(review: Review) = viewModelScope.launch {
        this@HomePageViewModel.reviewRepository.insert(review)
    }

    fun insertRecipe(recipe: Recipe) = viewModelScope.launch {
        this@HomePageViewModel.recipeRepository.insert(recipe)
    }
}
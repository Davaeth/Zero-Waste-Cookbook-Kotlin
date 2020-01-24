package com.example.davaeth.zero_waste_cookbook_kotlin.ui.home_page

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.davaeth.zero_waste_cookbook_kotlin.database.AppDatabase
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review
import com.example.davaeth.zero_waste_cookbook_kotlin.database.repositories.ReviewRepository
import kotlinx.coroutines.launch

class HomePageViewModel(private val application: Application) : ViewModel() {
    private lateinit var repository: ReviewRepository

    private lateinit var allReviews: LiveData<List<Review>>

    init {
        val reviewDao = AppDatabase.getDatabase(application).reviewDao()
        repository = ReviewRepository(reviewDao)
        allReviews = repository.allReviews
    }

    fun insert(review: Review) = viewModelScope.launch {
        repository.insert(review)
    }
}
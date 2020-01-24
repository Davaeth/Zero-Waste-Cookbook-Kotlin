package com.example.davaeth.zero_waste_cookbook_kotlin.database.repositories

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.ReviewDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review

class ReviewRepository(private val reviewDao: ReviewDao) {
    val allReviews: LiveData<List<Review>> = reviewDao.getReviews()

    suspend fun insert(review: Review) {
        reviewDao.insert(review)
    }
}
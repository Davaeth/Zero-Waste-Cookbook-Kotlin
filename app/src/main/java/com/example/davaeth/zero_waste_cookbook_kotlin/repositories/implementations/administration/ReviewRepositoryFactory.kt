package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.administration

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.administration.ReviewDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.administration.ReviewRepository

class ReviewRepositoryFactory(private val reviewDao: ReviewDao): ReviewRepository {
    override val entities: LiveData<List<Review>> = reviewDao.getReviews()

    override fun insert(entity: Review) {
        reviewDao.insert(entity)
    }
}
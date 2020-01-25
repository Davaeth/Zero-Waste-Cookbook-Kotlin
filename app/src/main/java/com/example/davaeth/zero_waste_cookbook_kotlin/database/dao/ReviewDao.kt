package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review

@Dao
interface ReviewDao: BaseDao<Review> {

    @Query("SELECT * from reviews ORDER BY id DESC")
    fun getReviews(): LiveData<List<Review>>
}
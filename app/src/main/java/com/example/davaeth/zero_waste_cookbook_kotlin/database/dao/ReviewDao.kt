package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.room.*
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.Review

@Dao
interface ReviewDao {

    @Query("SELECT * from reviews ORDER BY id DESC")
    fun getReviews(): List<Review>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(review: Review)

    @Delete
    fun delete(review: Review)
}
package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review

@Dao
interface ReviewDao {

    @Query("SELECT * from reviews ORDER BY id DESC")
    fun getReviews(): LiveData<List<Review>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(review: Review)

    @Delete
    fun delete(review: Review)
}
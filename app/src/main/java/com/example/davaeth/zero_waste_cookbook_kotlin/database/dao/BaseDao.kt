package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BaseDao<TEntity> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(entity: TEntity)

    @Delete
    fun delete(review: TEntity)
}
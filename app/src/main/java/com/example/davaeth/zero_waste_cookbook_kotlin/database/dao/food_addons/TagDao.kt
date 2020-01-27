package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.BaseDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Tag

@Dao
interface TagDao : BaseDao<Tag> {
    @Query("SELECT * FROM tags")
    fun getTags(): LiveData<List<Tag>>
}
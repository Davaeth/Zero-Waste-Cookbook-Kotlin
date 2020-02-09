package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.BaseDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region

@Dao
interface RegionDao: BaseDao<Region> {
    @Query("SELECT * FROM regions ORDER BY name")
    fun getRegions(): LiveData<List<Region>>
}
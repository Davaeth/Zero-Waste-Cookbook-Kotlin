package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food_addons

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons.RegionDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food_addons.RegionRepository

class RegionRepositoryFactory(private val regionDao: RegionDao): RegionRepository {
    override val entities: LiveData<List<Region>> = regionDao.getRegions()

    override fun insert(entity: Region) {
        regionDao.insert(entity)
    }
}
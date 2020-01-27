package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food_addons

import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons.TagDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Tag
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food_addons.TagRepository

class TagRepositoryFactory(private val tagDao: TagDao):
    TagRepository{
    override val entities = tagDao.getTags()

    override fun insert(entity: Tag) {
        tagDao.insert(entity)
    }
}
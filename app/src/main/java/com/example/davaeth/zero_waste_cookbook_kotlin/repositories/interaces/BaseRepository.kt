package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces

import androidx.lifecycle.LiveData

interface BaseRepository<TEntity> {
    val entities: LiveData<List<TEntity>>

    fun insert(entity: TEntity)
}
package com.example.davaeth.zero_waste_cookbook_kotlin.repositories

interface BaseRepository<TData> {

    fun insert(entity: TData)
}
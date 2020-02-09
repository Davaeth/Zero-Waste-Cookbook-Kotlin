package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.administration

import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.BaseRepository

interface UserRepository: BaseRepository<User> {
    fun getUserById(userId: Int): User
}
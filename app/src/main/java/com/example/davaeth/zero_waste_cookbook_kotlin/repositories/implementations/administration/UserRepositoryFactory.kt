package com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.administration

import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.administration.UserDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.administration.UserRepository

class UserRepositoryFactory(private val userDao: UserDao) : UserRepository {
    override val entities: LiveData<List<User>> = userDao.getUsers()

    override fun getUserById(userId: Int): User = userDao.getUserById(userId)

    override fun insert(entity: User) {
        userDao.insert(entity)
    }
}
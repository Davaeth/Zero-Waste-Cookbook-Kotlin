package com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.administration

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.BaseDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User

@Dao
interface UserDao: BaseDao<User> {
    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Int): User
}
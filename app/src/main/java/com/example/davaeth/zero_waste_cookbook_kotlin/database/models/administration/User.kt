package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val username: String,
    val roleId: Int
)
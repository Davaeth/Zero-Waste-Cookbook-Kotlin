package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @NonNull val id: Int = 0,
    val username: String,
    val roleId: Int
)
package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    foreignKeys = [ForeignKey(
        entity = Role::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("role")
    )]
)
data class User(
    @PrimaryKey val id: Int, val username: String,
    val role: Int
)
package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            parentColumns = arrayOf("id"),
            entity = Role::class,
            childColumns = arrayOf("roleId")
        )
    ]
)
data class User(
    @PrimaryKey val id: Int,
    val username: String,
    val roleId: Int
)
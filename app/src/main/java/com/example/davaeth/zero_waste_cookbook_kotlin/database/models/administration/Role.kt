package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roles")
data class Role(@PrimaryKey val id: Int, val roleName: String)
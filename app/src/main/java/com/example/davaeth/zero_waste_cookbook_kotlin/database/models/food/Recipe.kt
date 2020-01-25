package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.DifficultyLevel
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region
import java.sql.Date

@Entity(
    tableName = "recipes",
    foreignKeys = [
        ForeignKey(
            parentColumns = ["id"],
            entity = User::class,
            childColumns = ["ownerId"]
        ),
        ForeignKey(
            parentColumns = ["id"],
            entity = DifficultyLevel::class,
            childColumns = ["difficultyLevelId"]
        ),
        ForeignKey(
            parentColumns = ["id"],
            entity = Region::class,
            childColumns = ["regionId"]
        )
    ]
)
data class Recipe(
    @PrimaryKey val id: Int, val prepTime: Int,
    val title: String,
    val description: String,
    val photoPath: String,
    val rank: Double,
    val creationDate: Date,
    val ownerId: Int,
    val difficultyLevelId: Int,
    val regionId: Int
)
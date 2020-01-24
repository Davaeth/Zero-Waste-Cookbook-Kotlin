package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.DifficultyLevels
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region

@Entity(
    tableName = "recipes",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user"]
        ),
        ForeignKey(
            entity = DifficultyLevels::class,
            parentColumns = ["id"],
            childColumns = ["difficultyLevel"]
        ),
        ForeignKey(
            entity = Region::class,
            parentColumns = ["id"],
            childColumns = ["region"]
        )
    ]
)
data class Recipe(
    @PrimaryKey val id: Int, val prepTime: Int,
    val title: String,
    val description: String,
    val photoPath: String,
    val rank: Double,
    val user: Int,
    val difficultyLevel: Int,
    val region: Int
)
package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.reviews

import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User

data class UserReviews(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entity = Review::class,
        entityColumn = "ownerId"
    )
    val reviews: List<Review>
)
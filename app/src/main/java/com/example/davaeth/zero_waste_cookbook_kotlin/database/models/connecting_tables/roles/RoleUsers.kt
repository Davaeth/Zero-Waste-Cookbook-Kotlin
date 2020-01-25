package com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.roles

import androidx.room.Embedded
import androidx.room.Relation
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Role
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User

data class RoleUsers(
    @Embedded
    val role: Role,
    @Relation(
        parentColumn = "id",
        entity = User::class,
        entityColumn = "roleId"
    )
    val users: List<User>
)
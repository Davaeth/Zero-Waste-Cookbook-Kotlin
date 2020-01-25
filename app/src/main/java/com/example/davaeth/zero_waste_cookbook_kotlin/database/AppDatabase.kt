package com.example.davaeth.zero_waste_cookbook_kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.RecipeDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.ReviewDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review

@Database(
    entities = [Review::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reviewDao(): ReviewDao
    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "zero_waste_database"
                ).build()

                this.INSTANCE = instance

                return instance
            }
    }
}
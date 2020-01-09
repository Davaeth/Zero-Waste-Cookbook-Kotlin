package com.example.davaeth.zero_waste_cookbook_kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.ReviewDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.Review

@Database(
    entities = [Review::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ReviewDao(): ReviewDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE != null) {
                return INSTANCE as AppDatabase
            }

            synchronized(this) {
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
}
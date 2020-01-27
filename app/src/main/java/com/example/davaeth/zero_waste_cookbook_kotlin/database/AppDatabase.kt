package com.example.davaeth.zero_waste_cookbook_kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.administration.ReviewDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.DifficultyLevelRecipesDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.RecipeTagsDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.UserOwnRecipesDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.UserRecipesDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.IngredientDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.RecipeDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons.RegionDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons.TagDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Review
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.Role
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.recipe_ingredient.RecipeIngredients
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.DifficultyLevel
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Tag

@Database(
    entities = [
        Review::class,
        Recipe::class,
        Tag::class,
        User::class,
        Role::class,
        Ingredient::class,
        DifficultyLevel::class,
        Region::class,
        RecipeIngredients::class,
        UserRecipes::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    // Administration
    abstract fun reviewDao(): ReviewDao

    // Food
    abstract fun recipeDao(): RecipeDao
    abstract fun ingredientDao(): IngredientDao

    // Food addons
    abstract fun tagDao(): TagDao
    abstract fun regionDao(): RegionDao

    // Connecting tables
    abstract fun recipeTagsDao(): RecipeTagsDao
    abstract fun difficultyLevelRecipesDao(): DifficultyLevelRecipesDao
    abstract fun userOwnRecipesDao(): UserOwnRecipesDao
    abstract fun userRecipesDao(): UserRecipesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "zero_waste_database.db"
                ).build()

                this.INSTANCE = instance

                return instance
            }
    }
}
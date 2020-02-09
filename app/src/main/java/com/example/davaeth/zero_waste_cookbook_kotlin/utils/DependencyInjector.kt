package com.example.davaeth.zero_waste_cookbook_kotlin.utils

import android.content.Context
import com.example.davaeth.zero_waste_cookbook_kotlin.database.AppDatabase
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.administration.UserDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.RecipeTagsDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.UserRecipesDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.IngredientDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.RecipeDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons.RegionDao
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.administration.UserRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.connecting_tables.RecipeTagsRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.connecting_tables.UserRecipesRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food.IngredientRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food.RecipeRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food_addons.RegionRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.administration.UserRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables.RecipeTagsRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables.UserRecipesRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.IngredientRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.RecipeRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food_addons.RegionRepository
import org.kodein.di.Kodein
import org.kodein.di.conf.global
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DependencyInjector {

    companion object {
        fun injectDependencies(context: Context) {
            Kodein.global.addConfig {
                bind<AppDatabase>() with singleton { AppDatabase.getDatabase(context) }

                bind<RecipeTagsDao>() with singleton { instance<AppDatabase>().recipeTagsDao() }
                bind<RecipeTagsRepository>() with provider { RecipeTagsRepositoryFactory(instance()) }

                bind<RecipeDao>() with singleton { instance<AppDatabase>().recipeDao() }
                bind<RecipeRepository>() with provider { RecipeRepositoryFactory(instance()) }

                bind<RegionDao>() with singleton { instance<AppDatabase>().regionDao() }
                bind<RegionRepository>() with provider { RegionRepositoryFactory(instance()) }

                bind<IngredientDao>() with singleton { instance<AppDatabase>().ingredientDao() }
                bind<IngredientRepository>() with provider { IngredientRepositoryFactory(instance()) }

                bind<UserDao>() with singleton { instance<AppDatabase>().userDao() }
                bind<UserRepository>() with provider { UserRepositoryFactory(instance()) }

                bind<UserRecipesDao>() with singleton { instance<AppDatabase>().userRecipesDao() }
                bind<UserRecipesRepository>() with provider { UserRecipesRepositoryFactory(instance()) }
            }
        }
    }
}
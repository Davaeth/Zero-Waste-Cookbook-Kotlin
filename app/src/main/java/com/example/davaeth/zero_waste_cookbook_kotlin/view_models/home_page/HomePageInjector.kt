package com.example.davaeth.zero_waste_cookbook_kotlin.view_models.home_page

import com.example.davaeth.zero_waste_cookbook_kotlin.database.AppDatabase
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.connecting_tables.RecipeTagsDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.RecipeDao
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.connecting_tables.RecipeTagsRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food.RecipeRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.connecting_tables.RecipeTagsRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food.RecipeRepository
import org.kodein.di.conf.ConfigurableKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class HomePageInjector {
    val kodein: ConfigurableKodein = ConfigurableKodein()

    init {
        kodein.addConfig {
            bind<RecipeTagsDao>() with singleton { instance<AppDatabase>().recipeTagsDao() }
            bind<RecipeTagsRepository>() with provider { RecipeTagsRepositoryFactory(instance()) }

            bind<RecipeDao>() with provider { instance<AppDatabase>().recipeDao() }
            bind<RecipeRepository>() with provider { RecipeRepositoryFactory(instance()) }
        }
    }
}

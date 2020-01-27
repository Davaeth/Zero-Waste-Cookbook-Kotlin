package com.example.davaeth.zero_waste_cookbook_kotlin.view_models.search_page

import com.example.davaeth.zero_waste_cookbook_kotlin.database.AppDatabase
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food.IngredientDao
import com.example.davaeth.zero_waste_cookbook_kotlin.database.dao.food_addons.RegionDao
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food.IngredientRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food_addons.RegionRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food.IngredientRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food_addons.RegionRepository
import org.kodein.di.conf.ConfigurableKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class SearchPageInjector {
    val kodein: ConfigurableKodein = ConfigurableKodein()

    init {
        kodein.addConfig {
            bind<RegionDao>() with  provider { instance<AppDatabase>().regionDao() }
            bind<RegionRepository>() with provider { RegionRepositoryFactory(instance()) }

            bind<IngredientDao>() with  provider { instance<AppDatabase>().ingredientDao() }
            bind<IngredientRepository>() with provider { IngredientRepositoryFactory(instance()) }
        }
    }
}
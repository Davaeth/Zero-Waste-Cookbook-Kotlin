package com.example.davaeth.zero_waste_cookbook_kotlin.view_models.search_page

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food.IngredientRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food_addons.RegionRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food.IngredientRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interaces.food_addons.RegionRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

class SearchPageViewModel(
    application: Application,
    private var ingredientRepository: IngredientRepository,
    private var regionRepository: RegionRepository
) : AndroidViewModel(application), KodeinAware {
    override val kodein: Kodein

    val ingredients: LiveData<List<Ingredient>>
    val regions: LiveData<List<Region>>

    init {
        kodein = SearchPageInjector().kodein

        injectDependencies()

        ingredients = ingredientRepository.entities
        regions = regionRepository.entities
    }

    private fun injectDependencies() {
        ingredientRepository = kodein.direct.instance<IngredientRepositoryFactory>()
        regionRepository = kodein.direct.instance<RegionRepositoryFactory>()
    }
}
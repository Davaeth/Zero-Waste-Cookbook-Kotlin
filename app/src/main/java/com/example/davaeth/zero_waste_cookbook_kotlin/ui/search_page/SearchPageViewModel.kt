package com.example.davaeth.zero_waste_cookbook_kotlin.ui.search_page

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Ingredient
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food_addons.Region
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food.IngredientRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.implementations.food_addons.RegionRepositoryFactory
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.IngredientRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food_addons.RegionRepository
import org.kodein.di.conf.KodeinGlobalAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

class SearchPageViewModel(
    application: Application

) : AndroidViewModel(application), KodeinGlobalAware {

    val ingredients: LiveData<List<Ingredient>>
    val regions: LiveData<List<Region>>

    private val ingredientRepository: IngredientRepository
    private val regionRepository: RegionRepository

    init {
        ingredientRepository = kodein.direct.instance<IngredientRepositoryFactory>()
        regionRepository = kodein.direct.instance<RegionRepositoryFactory>()

        ingredients = ingredientRepository.entities
        regions = regionRepository.entities
    }
}
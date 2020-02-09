package com.example.davaeth.zero_waste_cookbook_kotlin.ui.home_page

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables.RecipeTagsRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.food.RecipeRepository
import org.kodein.di.conf.KodeinGlobalAware
import org.kodein.di.direct
import org.kodein.di.generic.instance
import java.util.*

class HomePageViewModel(
    application: Application
) : AndroidViewModel(application), KodeinGlobalAware {

    val newestRecipes: MutableLiveData<List<Recipe>>

    private val recipeRepository: RecipeRepository
    private val recipeTagsRepository: RecipeTagsRepository

    init {
        recipeRepository = kodein.direct.instance()
        recipeTagsRepository = kodein.direct.instance()

        val newestRecipeValues: MutableList<Recipe> = mutableListOf()

        newestRecipeValues.add(
            Recipe(
                prepTime = 20,
                title = "First recipe",
                description = "Best recipe ever!",
                rank = 2.0,
                creationDate = Date(),
                ownerId = 1,
                difficultyLevelId = 2,
                regionId = 13
            )
        )
        newestRecipeValues.add(
            Recipe(
                prepTime = 20,
                title = "Second recipe",
                description = "Best recipe ever!",
                rank = 2.0,
                creationDate = Date(),
                ownerId = 1,
                difficultyLevelId = 2,
                regionId = 13
            )
        )
        newestRecipeValues.add(
            Recipe(
                prepTime = 20,
                title = "Third recipe",
                description = "Best recipe ever!",
                rank = 2.0,
                creationDate = Date(),
                ownerId = 1,
                difficultyLevelId = 2,
                regionId = 13
            )
        )
        newestRecipeValues.add(
            Recipe(
                prepTime = 20,
                title = "Fourth recipe",
                description = "Best recipe ever!",
                rank = 2.0,
                creationDate = Date(),
                ownerId = 1,
                difficultyLevelId = 2,
                regionId = 13
            )
        )
        newestRecipeValues.add(
            Recipe(
                prepTime = 20,
                title = "Fifth recipe",
                description = "Best recipe ever!",
                rank = 2.0,
                creationDate = Date(),
                ownerId = 1,
                difficultyLevelId = 2,
                regionId = 13
            )
        )

        // newestRecipes = recipeRepository.newestRecipes
        newestRecipes = MutableLiveData()
        newestRecipes.value = newestRecipeValues
    }

    fun getRecipeTags(recipeId: Int) = recipeTagsRepository.getRecipeTags(recipeId)

    fun getRecipeTags(): List<String> {
        val tags: MutableList<String> = mutableListOf()

        tags.add("First")
        tags.add("Second")
        tags.add("Third")
        tags.add("Fourth")

        return tags
    }
}
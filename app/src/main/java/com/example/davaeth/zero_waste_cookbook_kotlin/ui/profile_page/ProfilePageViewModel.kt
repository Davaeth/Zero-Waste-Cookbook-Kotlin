package com.example.davaeth.zero_waste_cookbook_kotlin.ui.profile_page

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.administration.User
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.connecting_tables.user_recipe.UserFavouriteRecipes
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.administration.UserRepository
import com.example.davaeth.zero_waste_cookbook_kotlin.repositories.interfaces.connecting_tables.UserRecipesRepository
import org.kodein.di.conf.KodeinGlobalAware
import org.kodein.di.direct
import org.kodein.di.generic.instance
import java.util.*

class ProfilePageViewModel(private val navController: NavController) : ViewModel(),
    KodeinGlobalAware {

    val favouriteRecipes: MutableLiveData<UserFavouriteRecipes>

    private val userRecipesRepository: UserRecipesRepository
    private val userRepository: UserRepository

    init {
        this.userRecipesRepository = kodein.direct.instance()
        this.userRepository = kodein.direct.instance()

        val newestRecipeValues = UserFavouriteRecipes(
            recipes = listOf(
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
            ),
            user = User(
                roleId = 0,
                username = "User"
            )
        )

        this.favouriteRecipes = MutableLiveData()
        this.favouriteRecipes.value = newestRecipeValues

        // this.favouriteRecipes = userRecipesRepository.userFavouriteRecipes
    }

    fun getUserById(userId: Int) = userRepository.getUserById(userId)

    fun getRecipeTags(): List<String> {
        val tags: MutableList<String> = mutableListOf()

        tags.add("First")
        tags.add("Second")
        tags.add("Third")
        tags.add("Fourth")

        return tags
    }

    fun navigateToSettingsPage(v: View?) {
        this.navController.navigate(R.id.action_profilePage_to_settingsPage)
    }
}
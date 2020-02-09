package com.example.davaeth.zero_waste_cookbook_kotlin.ui.profile_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters.RecipesListAdapter
import kotlinx.android.synthetic.main.fragment_profile_page.*

class ProfilePage : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val profilePageViewModel =
            ViewModelProvider(this, ProfilePageViewModelFactory(navController)).get(
                ProfilePageViewModel::class.java
            )

        favourite_recipes.layoutManager = LinearLayoutManager(view.context)
        favourite_recipes.adapter =
            RecipesListAdapter(
                profilePageViewModel.getRecipeTags(),
                profilePageViewModel.favouriteRecipes.value!!.recipes
            )
        favourite_recipes.setHasFixedSize(true)

        settings_button.setOnClickListener { profilePageViewModel.navigateToSettingsPage(it) }
    }
}

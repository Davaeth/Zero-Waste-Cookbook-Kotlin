package com.example.davaeth.zero_waste_cookbook_kotlin.ui.home_page

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
import com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters.RecipeCardTagsAdapter
import com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters.RecipesListAdapter
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.recipe_card.view.*

class HomePage : Fragment() {

    private lateinit var navController: NavController

    private lateinit var homePageViewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        homePageViewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)

        initAdapters(view)
    }

    private fun initAdapters(view: View) {
        recipe_card.tag_list.adapter =
            RecipeCardTagsAdapter(view.context, homePageViewModel.getRecipeTags())

        newest_recipes.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        newest_recipes.adapter =
            RecipesListAdapter(
                homePageViewModel.getRecipeTags(),
                homePageViewModel.newestRecipes.value!!
            )
        newest_recipes.setHasFixedSize(true)
    }
}

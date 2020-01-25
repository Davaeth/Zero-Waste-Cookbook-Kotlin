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
import com.example.davaeth.zero_waste_cookbook_kotlin.view_models.home_page.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.recipe_card.view.*

class HomePage : Fragment() {

    private lateinit var navController: NavController
    private val list = mutableListOf<String>()

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
        // homePageViewModel.allReviews.observe(this, Observer { reviews ->
        //
        // })

        initAdapters(view)
    }

    private fun initAdapters(view: View) {
        list.add("elo")
        list.add("elo2")
        list.add("elo4")
        list.add("elo5")

        recipe_card.tag_list.adapter = RecipeCardTagsAdapter(view.context, list)

        newest_recipes.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        newest_recipes.adapter =
            RecipesListAdapter(
                list
            )
        newest_recipes.setHasFixedSize(true)
    }
}

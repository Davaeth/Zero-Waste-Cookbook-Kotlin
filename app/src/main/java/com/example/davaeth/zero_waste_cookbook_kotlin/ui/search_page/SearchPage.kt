package com.example.davaeth.zero_waste_cookbook_kotlin.ui.search_page


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.ui.search_page.components.adapters.SearchTilesAdapter
import kotlinx.android.synthetic.main.fragment_search_page.*


class SearchPage : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val ingredientsTiles = mutableListOf<String>()

        ingredientsTiles.add("Eggs")
        ingredientsTiles.add("Ham")
        ingredientsTiles.add("Cheese")
        ingredientsTiles.add("Bread")

        regions_tiles.adapter = SearchTilesAdapter(view.context, ingredientsTiles)
        ingredients_tiles.adapter = SearchTilesAdapter(view.context, ingredientsTiles)

    }
}

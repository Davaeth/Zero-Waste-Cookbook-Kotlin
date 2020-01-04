package com.example.davaeth.zero_waste_cookbook_kotlin.pages.home_page


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.pages.home_page.components.adapters.NewestRecipesAdapter
import com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters.RecipeCardTagsAdapter
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.recipe_card.view.*

class HomePage : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initAdapters(view)
    }

    override fun onClick(v: View?) {

    }

    private fun initAdapters(view: View) {
        val list = mutableListOf<String>()

        list.add("elo")
        list.add("elo2")
        list.add("elo4")
        list.add("elo5")

        recipe_card.tag_list.adapter = RecipeCardTagsAdapter(view.context, list)

        newest_recipes.setHasFixedSize(true)
        newest_recipes.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        newest_recipes.adapter = NewestRecipesAdapter(list)
        newest_recipes.visibility = View.VISIBLE
    }

}

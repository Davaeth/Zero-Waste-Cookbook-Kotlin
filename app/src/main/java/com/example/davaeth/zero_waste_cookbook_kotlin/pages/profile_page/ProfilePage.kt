package com.example.davaeth.zero_waste_cookbook_kotlin.pages.profile_page


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        val list = mutableListOf<String>()
        list.add("elo")
        list.add("elo2")
        list.add("elo4")
        list.add("elo5")

        favourite_recipes.layoutManager = LinearLayoutManager(view.context)
        favourite_recipes.adapter =
            RecipesListAdapter(
                list
            )
        favourite_recipes.setHasFixedSize(true)
    }
}

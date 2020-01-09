package com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.adapters.RecipeExpandableAdapter
import com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.add_review_dialog.AddReviewDialog
import com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters.RecipeCardTagsAdapter
import kotlinx.android.synthetic.main.fragment_single_recipe_page.*
import kotlinx.android.synthetic.main.recipe_card.view.*


class SingleRecipePage : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_single_recipe_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val data = mutableMapOf<String, List<String>>()

        val description = mutableListOf<String>()
        val ingredients = mutableListOf<String>()

        description.add("testssssssssssssssssssssssssssssssst")

        ingredients.add("One")
        ingredients.add("Two")
        ingredients.add("Three")
        ingredients.add("Four")

        data["DESCRIPTION"] = description
        data["INGREDIENTS"] = ingredients

        single_recipe_expandables.setAdapter(
            RecipeExpandableAdapter(
                view.context,
                data
            )
        )

        recipe_card_include.tag_list.adapter = RecipeCardTagsAdapter(view.context, ingredients)

        add_review_button.setOnClickListener(View.OnClickListener {
            val addReviewDialog = AddReviewDialog(view.context)

            addReviewDialog.showDialog()
        })

//        recipe_description.setOnGroupExpandListener(this)
//        recipe_description.setOnGroupExpandListener(this)
//
//        recipe_description.setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener {
//            override fun onGroupExpand(groupPosition: Int) {
//                recipe_description.expanded_parent_icon.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp)
//            }
//        })
    }
}

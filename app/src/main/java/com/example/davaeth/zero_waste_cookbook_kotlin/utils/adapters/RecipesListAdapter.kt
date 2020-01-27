package com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.database.models.food.Recipe
import kotlinx.android.synthetic.main.recipe_card.view.*

class RecipesListAdapter(
    private val tags: List<String>,
    private val newestRecipes: LiveData<List<Recipe>>
) :
    RecyclerView.Adapter<RecipesListAdapter.RecipesListViewAdapter>() {

    private lateinit var view: View

    class RecipesListViewAdapter(view: View, tags: List<String>) :
        RecyclerView.ViewHolder(view) {
        init {
            view.tag_list.adapter = RecipeCardTagsAdapter(view.context, tags)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListViewAdapter {
        this.view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)

        return RecipesListViewAdapter(
            view,
            this.tags
        )
    }

    override fun onBindViewHolder(holder: RecipesListViewAdapter, position: Int) {
        this.view.recipe_title.text = this.newestRecipes.value!![position].title
    }

    override fun getItemCount(): Int = 5
}
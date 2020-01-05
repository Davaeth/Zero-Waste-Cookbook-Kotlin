package com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import kotlinx.android.synthetic.main.recipe_card.view.*

class RecipesListAdapter(private val tags: List<String>) : RecyclerView.Adapter<RecipesListAdapter.RecipesListViewAdapter>() {

    class RecipesListViewAdapter(view: View, tags: List<String>) : RecyclerView.ViewHolder(view) {
        init {
            view.tag_list.adapter = RecipeCardTagsAdapter(view.context, tags)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)

        return RecipesListViewAdapter(
            view,
            this.tags
        )
    }

    override fun onBindViewHolder(holder: RecipesListViewAdapter, position: Int) {}

    override fun getItemCount(): Int = 5
}
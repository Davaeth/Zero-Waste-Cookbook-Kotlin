package com.example.davaeth.zero_waste_cookbook_kotlin.pages.home_page.components.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters.RecipeCardTagsAdapter
import kotlinx.android.synthetic.main.recipe_card.view.*

class NewestRecipesAdapter(private val tags: List<String>) : RecyclerView.Adapter<NewestRecipesAdapter.NewestRecipesViewAdapter>() {

    class NewestRecipesViewAdapter(view: View, tags: List<String>) : RecyclerView.ViewHolder(view) {
        init {
            view.tag_list.adapter = RecipeCardTagsAdapter(view.context, tags)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewestRecipesViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)

        return NewestRecipesViewAdapter(view, this.tags)
    }

    override fun onBindViewHolder(holder: NewestRecipesViewAdapter, position: Int) {}

    override fun getItemCount(): Int = 5
}
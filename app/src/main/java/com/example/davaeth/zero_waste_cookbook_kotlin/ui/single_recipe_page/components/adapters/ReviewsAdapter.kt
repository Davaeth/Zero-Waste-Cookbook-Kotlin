package com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ReviewsAdapter(private val username: String, private val description: String, private val rating: Int) : RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder>() {

    class ReviewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
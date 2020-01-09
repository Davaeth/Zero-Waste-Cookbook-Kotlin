package com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.add_review_dialog.components.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import kotlinx.android.synthetic.main.review_star_button.view.*

class NewReviewRatingAdapter(private val context: Context) :
    RecyclerView.Adapter<NewReviewRatingAdapter.NewReviewRatingViewHolder>() {

    private lateinit var singleRateView: View

    class NewReviewRatingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReviewRatingViewHolder {
        this.singleRateView =
            LayoutInflater.from(context).inflate(R.layout.review_star_button, parent, false)

        return NewReviewRatingViewHolder(singleRateView)
    }

    override fun getItemCount(): Int = 5

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: NewReviewRatingViewHolder, position: Int) {
        this.singleRateView.star_button.setOnClickListener(View.OnClickListener {
            it.star_button.setBackgroundResource(R.drawable.ic_star_black_24dp)
        })
    }
}
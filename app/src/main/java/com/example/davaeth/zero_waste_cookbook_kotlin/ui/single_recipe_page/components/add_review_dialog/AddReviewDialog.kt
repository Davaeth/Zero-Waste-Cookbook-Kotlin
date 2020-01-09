package com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.add_review_dialog

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.add_review_dialog.components.adapters.NewReviewRatingAdapter

class AddReviewDialog(private val context: Context) {

    fun showDialog() {
        val dialog = Dialog(context)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.add_review_dialog)

        val ratings = dialog.findViewById(R.id.ratings) as RecyclerView
        val closeButton = dialog.findViewById<ImageButton>(R.id.close_review_close_button)
        val submitButton = dialog.findViewById<Button>(R.id.new_review_submit_button)
        val descriptionField = dialog.findViewById<EditText>(R.id.review_description_edit_field)

        ratings.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ratings.adapter = NewReviewRatingAdapter(context)
        ratings.setHasFixedSize(false)

        closeButton.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
        })

        submitButton.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
        })

        descriptionField.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> true
                else -> false
            }
        })

        dialog.show()
    }
}
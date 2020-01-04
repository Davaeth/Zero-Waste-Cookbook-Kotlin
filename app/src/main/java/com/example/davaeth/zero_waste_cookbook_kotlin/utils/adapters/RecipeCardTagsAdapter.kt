package com.example.davaeth.zero_waste_cookbook_kotlin.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import kotlinx.android.synthetic.main.tag.view.*

class RecipeCardTagsAdapter(private val context: Context, private val tagsNames: List<String>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var singleTag: View

        when (convertView) {
            null -> {
                singleTag = LayoutInflater.from(context).inflate(R.layout.tag, parent, false)
                singleTag.tag_text_field.text = getItem(position)
            }
            else -> {
                singleTag = convertView
            }
        }

        if (position == 0) {
            singleTag.tag_text_field.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_access_time_black_24dp, 0, 0, 0)
        }

        return singleTag
    }

    override fun getItem(position: Int): String = tagsNames[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = tagsNames.size
}

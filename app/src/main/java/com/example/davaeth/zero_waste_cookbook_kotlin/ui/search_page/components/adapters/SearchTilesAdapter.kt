package com.example.davaeth.zero_waste_cookbook_kotlin.ui.search_page.components.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import kotlinx.android.synthetic.main.search_tile.view.*

class SearchTilesAdapter(private val context: Context, private val tiles: List<String>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var searchTile: View

        when (convertView) {
            null -> {
                searchTile =
                    LayoutInflater.from(context).inflate(R.layout.search_tile, parent, false)
                searchTile.tile.text = getItem(position)
            }
            else -> {
                searchTile = convertView
            }
        }

        return searchTile
    }

    override fun getItem(position: Int): String = tiles[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = tiles.size
}
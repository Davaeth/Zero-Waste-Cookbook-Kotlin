package com.example.davaeth.zero_waste_cookbook_kotlin.ui.single_recipe_page.components.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import kotlinx.android.synthetic.main.expanded_item.view.*
import kotlinx.android.synthetic.main.expanded_parent.view.*

class RecipeExpandableAdapter(
    private val context: Context,
    private val content: Map<String, List<String>>
) :
    BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String = content.keys.elementAt(groupPosition)

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = false

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        val parentView: View = when (convertView) {
            null -> {
                LayoutInflater.from(context).inflate(R.layout.expanded_parent, parent, false)
            }
            else -> {
                convertView
            }
        }

        parentView.expanded_parent_text.text = getGroup(groupPosition)
        parentView.expanded_parent_icon.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp)

        return parentView
    }

    override fun getChildrenCount(groupPosition: Int): Int =
        content.getValue(getGroup(groupPosition)).size

    override fun getChild(groupPosition: Int, childPosition: Int): String =
        content.getValue(content.keys.elementAt(groupPosition))[childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childView = when (convertView) {
            null -> {
                LayoutInflater.from(context).inflate(R.layout.expanded_item, parent, false)
            }
            else -> {
                convertView
            }
        }

        childView.expanded_child_text.text = getChild(groupPosition, childPosition)

        return childView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroupCount(): Int = 2
}
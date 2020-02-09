package com.example.davaeth.zero_waste_cookbook_kotlin.ui.settings_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.davaeth.zero_waste_cookbook_kotlin.R
import kotlinx.android.synthetic.main.fragment_settings_page.*

class SettingsPage : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        language_spinner.adapter = ArrayAdapter(
            view.context,
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.languages_values)
        )
    }
}

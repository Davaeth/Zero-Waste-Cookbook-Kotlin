package com.example.davaeth.zero_waste_cookbook_kotlin.ui.profile_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

class ProfilePageViewModelFactory(private val navController: NavController) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            NavController::class.java
        ).newInstance(navController)
}
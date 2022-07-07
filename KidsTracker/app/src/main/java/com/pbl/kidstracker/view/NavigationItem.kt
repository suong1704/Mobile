package com.pbl.kidstracker.view

import com.pbl.kidstracker.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Add : NavigationItem("add", R.drawable.ic_baseline_add_24, "Add")
    object Maps : NavigationItem("maps", R.drawable.ic_maps, "Maps")

}

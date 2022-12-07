package com.example.testing

sealed class NavigationRoutes(val route: String) {
    object Course : NavigationRoutes("course")
    object Contacts : NavigationRoutes("Contacts")
    object Profile : NavigationRoutes("profile")
}


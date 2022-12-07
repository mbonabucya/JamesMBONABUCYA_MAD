package com.example.testing

import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*


object navbaritems {
    val BarItems = listOf(
        barItem(
            title = "Course",
            image = Icons.Filled.Menu,
            route = "course"
        ),
        barItem(
            title = "Contacts",
            image = Icons.Filled.Call,
            route = "contacts"
        ),
        barItem(
            title = "profile",
            image = Icons.Filled.AccountBox,
            route = "profile"
        )

    )
}



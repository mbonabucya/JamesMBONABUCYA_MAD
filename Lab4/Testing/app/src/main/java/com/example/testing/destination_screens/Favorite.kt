package com.example.testing.destination_screens
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.res.stringResource

@Composable
fun Profile() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "",
            tint = Color.Green,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Center)
        )
    }
}
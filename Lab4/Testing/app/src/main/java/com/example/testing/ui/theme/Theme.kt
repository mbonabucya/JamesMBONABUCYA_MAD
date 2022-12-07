package com.example.testing.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = lab4blue,
    primaryVariant = lab4redvariant,
    secondary = lab4dark
)

private val lab4LightColor = lightColors(
    primary = lab4blue,
    primaryVariant = lab4redvariant,
    onPrimary = Color.White,
    secondary = lab4dark
)

@Composable
fun TestingTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        lab4LightColor
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
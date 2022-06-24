package com.uwaisalqadri.shared.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun UnplashTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) UnplashDarkColors else UnplashLightColors,
        typography = MaterialTheme.typography,
        shapes = UnplashShapes,
        content = content
    )
}
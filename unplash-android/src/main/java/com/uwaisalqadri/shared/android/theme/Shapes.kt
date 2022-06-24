package com.uwaisalqadri.shared.android.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val UnplashShapes = Shapes(
    small = RoundedCornerShape(percent = 50),
    medium = RoundedCornerShape(size = Dimesion.SIZE_8),
    large = RoundedCornerShape(size = Dimesion.SIZE_0)
)

object Dimesion {
    val SIZE_200 = 200.dp
    val SIZE_50 = 50.dp
    val SIZE_16 = 16.dp
    val SIZE_8 = 8.dp
    val SIZE_0 = 0.dp
}
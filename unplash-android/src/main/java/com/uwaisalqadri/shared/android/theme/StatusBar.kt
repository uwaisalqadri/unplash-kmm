package com.uwaisalqadri.shared.android.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun setWhiteStatusBar() {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = Color.White
    )
}
package com.uwaisalqadri.shared.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.ramcosta.composedestinations.DestinationsNavHost
import com.uwaisalqadri.shared.android.presentation.NavGraphs
import com.uwaisalqadri.shared.android.theme.UnplashTheme

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnplashTheme {
               DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
package com.uwaisalqadri.shared.android.di

import com.uwaisalqadri.shared.android.presentation.PhotoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { PhotoViewModel(get()) }
}
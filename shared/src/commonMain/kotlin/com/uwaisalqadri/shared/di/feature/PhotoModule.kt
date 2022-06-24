package com.uwaisalqadri.shared.di.feature

import com.uwaisalqadri.shared.data.PhotoDataStore
import com.uwaisalqadri.shared.data.PhotoRepository
import com.uwaisalqadri.shared.data.remote.PhotoApi
import com.uwaisalqadri.shared.data.remote.PhotoApiClient
import com.uwaisalqadri.shared.domain.PhotoInteractor
import com.uwaisalqadri.shared.domain.PhotoUseCase
import org.koin.dsl.module

val photoModule = module {
    single<PhotoApiClient> { PhotoApi(get()) }
    single<PhotoRepository> { PhotoDataStore(get()) }
    single<PhotoUseCase> { PhotoInteractor(get()) }
}
package com.uwaisalqadri.shared.di.feature

import com.uwaisalqadri.shared.data.UnplashDataStore
import com.uwaisalqadri.shared.data.UnplashRepository
import com.uwaisalqadri.shared.data.remote.UnplashApi
import com.uwaisalqadri.shared.data.remote.UnplashApiClient
import com.uwaisalqadri.shared.domain.UnplashInteractor
import com.uwaisalqadri.shared.domain.UnplashUseCase
import org.koin.dsl.module

val unplashModule = module {
    single<UnplashApiClient> { UnplashApi(get()) }
    single<UnplashRepository> { UnplashDataStore(get()) }
    single<UnplashUseCase> { UnplashInteractor(get()) }
}
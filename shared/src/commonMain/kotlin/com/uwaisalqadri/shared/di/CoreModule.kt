package com.uwaisalqadri.shared.di

import com.uwaisalqadri.shared.Configs
import com.uwaisalqadri.shared.data.model.response.ApiException
import com.uwaisalqadri.shared.data.remote.UnplashApi
import com.uwaisalqadri.shared.di.feature.unplashModule
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            remoteModule,
//            localModule,
            unplashModule
        )
    }
}

fun initKoin() = initKoin {} // for iOS

val localModule = module {
//    single { MangaPersistenceContainer(get()) }
//    single { createRealmDatabase() }
}

val remoteModule = module {
    single { UnplashApi(get()) }
    single { createJson() }
    single { createHttpClient(get(), get()) }
}

fun createDatabase(): Realm {
    val configuration = RealmConfiguration.with(schema = setOf(

    ))

    return Realm.open(configuration = configuration)
}

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json) = HttpClient(httpClientEngine) {
    install(ContentNegotiation) {
        json(json = json)
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = Configs.BASE_URL
            parameters.append("client_id", Configs.ACCESS_KEY)
        }
    }

    install(HttpTimeout) {
        this.requestTimeoutMillis = 60000
        this.connectTimeoutMillis = 60000
        this.socketTimeoutMillis = 60000
    }

    HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, _ ->
            when (exception) {
                is ServerResponseException -> {
                    val serverResponseResponse = exception.response
                    val serverResponseExceptionText = serverResponseResponse.bodyAsText()
                    val apiException = json.decodeFromString(ApiException.serializer(), serverResponseExceptionText)
                    throw apiException
                }
                is ClientRequestException -> {
                    val exceptionResponse = exception.response
                    val exceptionResponseText = exceptionResponse.bodyAsText()
                    val apiException = json.decodeFromString(ApiException.serializer(), exceptionResponseText)
                    throw apiException
                }
                else -> {
                    return@handleResponseExceptionWithRequest
                }
            }
        }
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }

}
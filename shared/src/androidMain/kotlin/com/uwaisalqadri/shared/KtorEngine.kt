package com.uwaisalqadri.shared

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.okhttp.*
import org.koin.dsl.module

actual fun ktorEngineModule() = module {
    single { createOkHttpEngine(get()) }
}

fun createOkHttpEngine(context: Context): HttpClient {
    return HttpClient(OkHttp) {
        engine {
            config {
                followRedirects(true)
            }

            addInterceptor(ChuckerInterceptor.Builder(context).build())
        }
    }
}
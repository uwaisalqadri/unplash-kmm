package com.uwaisalqadri.shared.android

import android.app.Application
import co.touchlab.kermit.BuildConfig
import com.uwaisalqadri.shared.android.di.featureModule
import com.uwaisalqadri.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BaseApplication)
            modules(featureModule)
        }
    }
}
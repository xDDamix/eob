package pl.dguziak.eob

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.dguziak.splashscreen.di.splashscreenModule

class EOApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //todo: To check if will need that
            androidContext(this@EOApp)
            modules(listOf(
                splashscreenModule
            ))
        }
    }
}
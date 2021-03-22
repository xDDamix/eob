package pl.dguziak.eob

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.dguziak.data.di.networkRepositoryModule
import pl.dguziak.listscreen.di.listScreenModule
import pl.dguziak.splashscreen.di.splashscreenModule
import pl.dguziak.view.di.viewModule

class EOApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EOApp)
            modules(listOf(
                splashscreenModule,
                viewModule,
                networkRepositoryModule,
                listScreenModule
            ))
        }
    }
}
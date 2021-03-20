package pl.dguziak.splashscreen.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.dguziak.splashscreen.viewmodel.SplashscreenViewModel

val splashscreenModule = module {
    viewModel { SplashscreenViewModel() }
}
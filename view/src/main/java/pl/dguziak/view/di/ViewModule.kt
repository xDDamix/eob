package pl.dguziak.view.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.dguziak.navigateable.NavigateableActivityViewModel

val viewModule = module {
    viewModel { NavigateableActivityViewModel() }
}
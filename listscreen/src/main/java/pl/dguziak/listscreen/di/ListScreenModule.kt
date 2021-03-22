package pl.dguziak.listscreen.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.dguziak.domain.usecase.GetTodosUseCase
import pl.dguziak.listscreen.viewmodel.ListScreenViewModel

val listScreenModule = module {

    viewModel { ListScreenViewModel(get()) }

    single { GetTodosUseCase(get()) }
}
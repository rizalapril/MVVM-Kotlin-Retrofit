package com.mvvm.di

import com.mvvm.data.repository.PokemonRepository
import com.mvvm.data.repository.PokemonRepositoryImpl
import com.mvvm.util.SharedPreferenceUtil
import com.mvvm.util.SharedPreferenceUtilImpl
import com.mvvm.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModule = module {
    //viewmodel
    viewModel {
        // viewmodel for seer map view
        MainViewModel(get(),get(),get())
    }
}

val dataModule = module(createOnStart = true) {
    // shared preference repository
    single<SharedPreferenceUtil> {SharedPreferenceUtilImpl(get())}

    //repository
    single<PokemonRepository> {PokemonRepositoryImpl(get(), get(), get())}
}

val dataSource = listOf(appModule, dataModule, remoteDataSourceModule, localDataSourceModule)
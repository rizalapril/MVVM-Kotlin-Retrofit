package com.mvvm.di

import android.content.Context
import android.content.SharedPreferences
import com.mvvm.data.local.dao.PokemonDao
import org.koin.dsl.module.module

val localDataSourceModule = module {
    single {
        initSharedPreference(get())
    }

    //dao
    single {
        PokemonDao()
    }
}

fun initSharedPreference(context: Context): SharedPreferences {
    return context.getSharedPreferences("pokemon-prefs", Context.MODE_PRIVATE)
}
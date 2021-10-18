package com.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mvvm.data.repository.PokemonRepository
import com.mvvm.util.SharedPreferenceUtil

class MainViewModel(
    private val context: Context,
    private val pokeRepo: PokemonRepository,
    private val sharedPreference: SharedPreferenceUtil
): ViewModel() {

    fun load(){
        pokeRepo.getPokemonList {

        }
    }
}
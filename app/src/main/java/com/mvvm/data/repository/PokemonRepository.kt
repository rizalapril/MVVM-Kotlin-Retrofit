package com.mvvm.data.repository

import android.content.Context
import com.mvvm.data.local.dao.PokemonDao
import com.mvvm.data.remote.api.RemoteDataSource
import com.mvvm.data.remote.model.PokemonResult

interface PokemonRepository {
    fun getPokemonList(callback: (List<PokemonResult>) -> Unit)
}
class PokemonRepositoryImpl(
    private val context: Context,
    private val pokeDao: PokemonDao,
    private val remote: RemoteDataSource
): PokemonRepository{
    override fun getPokemonList(callback: (List<PokemonResult>) -> Unit) {
        remote.fetchPokemon(151, 0){
            if (it!=null){
                //save local
                pokeDao.save()
                callback(it)
            }
        }
    }
}
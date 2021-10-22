package com.mvvm.data.repository

import android.content.Context
import com.mvvm.data.local.dao.PokemonDao
import com.mvvm.data.local.entity.PokemonDataLocal
import com.mvvm.data.remote.api.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

interface PokemonRepository {
    fun getPokemonList(callback: (List<PokemonDataLocal>) -> Unit)
    fun fetchPokemon(callback: (List<PokemonDataLocal>?) -> Unit)
}
class PokemonRepositoryImpl(
    private val context: Context,
    private val pokeDao: PokemonDao,
    private val remote: RemoteDataSource
): PokemonRepository{
    override fun getPokemonList(callback: (List<PokemonDataLocal>) -> Unit) {
        val pokemonList = pokeDao.findAllPokemon()
        callback(pokemonList)
    }

    override fun fetchPokemon(callback: (List<PokemonDataLocal>?) -> Unit) {
        runBlocking {
            launch(Dispatchers.IO) {
                remote.fetchPokemon(151, 0){
                    if (it!=null){
                        //save local
                        pokeDao.save(it)

                        val pokemonList = pokeDao.findAllPokemon()
                        callback(pokemonList)
                    }else{
                        callback(null)
                    }
                }
            }
        }
    }
}
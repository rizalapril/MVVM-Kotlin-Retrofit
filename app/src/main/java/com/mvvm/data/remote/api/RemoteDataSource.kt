package com.mvvm.data.remote.api

import com.mvvm.data.remote.model.Pokemon
import com.mvvm.data.remote.model.PokemonResponse
import com.mvvm.data.remote.model.PokemonResult
import com.mvvm.util.SharedPreferenceUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(
    private val sharedPreference: SharedPreferenceUtil
) {
    suspend fun fetchPokemon(limit: Int, offset: Int, callback: (List<PokemonResult>?) -> Unit){
        ApiClient.getApiInterface()?.getPokemons(limit, offset).let { call ->
            call?.enqueue(object : Callback<PokemonResponse> {
                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    callback(null)
                }

                override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                    if (response.isSuccessful){
                        callback(response?.body()?.results)
                    }else{
                        callback(null)
                    }
                }
            })
        }
    }

    fun getPokemon(id: Int?, callback: (Pokemon?) -> Unit){
        ApiClient.getApiInterface()?.getPokemon(id).let { call ->
            call?.enqueue(object : Callback<Pokemon>{
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    callback(null)
                }

                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if (response.isSuccessful){
                        callback(response.body())
                    }else{
                        callback(null)
                    }
                }
            })
        }
    }
}
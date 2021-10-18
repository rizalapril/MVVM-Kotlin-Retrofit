package com.mvvm.data.remote.api

import com.mvvm.data.remote.model.PokemonResponse
import com.mvvm.data.remote.model.PokemonResult
import com.mvvm.util.SharedPreferenceUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(
    private val sharedPreference: SharedPreferenceUtil
) {
    fun fetchPokemon(limit: Int, offset: Int, callback: (List<PokemonResult>?) -> Unit){
        ApiClient.getApiInterface()?.getPokemons(151, 0).let { call ->
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
}
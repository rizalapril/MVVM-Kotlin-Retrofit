package com.mvvm.data.remote.api

import com.mvvm.data.remote.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceInterface {
    @GET("pokemon/")
    fun getPokemons(@Query("limit") limit: Int?, @Query("offset") offset: Int?): Call<PokemonResponse>?

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int?): Call<Pokemon>?

    @GET("ability/{id}/")
    fun getAbility(@Path("id") id: Int?): Call<Ability>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int?): Call<PokemonSpecies>

    @GET("type/{id}/")
    fun getType(@Path("id") id: Int?): Call<Type>
}
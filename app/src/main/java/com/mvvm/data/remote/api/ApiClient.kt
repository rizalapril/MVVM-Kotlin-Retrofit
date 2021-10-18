package com.mvvm.data.remote.api

import com.mvvm.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var retrofit: Retrofit? = null

    fun getApiInterface(): ServiceInterface? {
        if(retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit?.create(ServiceInterface::class.java)
    }
}
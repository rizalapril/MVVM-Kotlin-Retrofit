package com.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.data.dataclass.NamedApiResource
import com.mvvm.data.dataclass.PokemonData
import com.mvvm.data.dataclass.PokemonList
import com.mvvm.data.dataclass.PokemonType
import com.mvvm.data.local.entity.NamedApiResourceDataLocal
import com.mvvm.data.local.entity.PokemonDataLocal
import com.mvvm.data.local.entity.PokemonTypeDataLocal
import com.mvvm.data.repository.PokemonRepository
import com.mvvm.util.SharedPreferenceUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainViewModel(
    private val context: Context,
    private val pokeRepo: PokemonRepository,
    private val sharedPreference: SharedPreferenceUtil
): ViewModel() {

    val resultPokemon = MutableLiveData<PokemonList>()

    fun load(){
        pokeRepo.getPokemonList { list ->
            if (list.size > 0){
                var dataList = storePokemonToList(list)
                resultPokemon.value = PokemonList(1, dataList)
            }else{
                resultPokemon.value = PokemonList(2, null)

                runBlocking {
                    launch(Dispatchers.Default) {

                        withContext(Dispatchers.IO){
                            var dataList: List<PokemonData>? = null
                            pokeRepo.fetchPokemon {
                                if (it!=null){
                                    dataList = storePokemonToList(it)
                                    resultPokemon.postValue(PokemonList(1, dataList))
                                }else{
                                    resultPokemon.postValue(PokemonList(1, dataList))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun storePokemonToList(list: List<PokemonDataLocal>): List<PokemonData>{
        var dataList = mutableListOf<PokemonData>()
        for (i in list){
            var data = PokemonData()
            data.id = i.id ?: ""
            data.name = i.name ?: ""
            data.url = i.url ?: ""

            var arrType = ArrayList<PokemonType>()
            for (i in i.types) {
                val namedData = NamedApiResource()
                namedData.name = i.type?.name ?: ""
                namedData.url = i.type?.url ?: ""

                val typeData = PokemonType()
                typeData.type = namedData
                typeData.slot = i.slot ?: 0
                arrType.add(typeData)
            }
            data.types = arrType

            dataList.add(data)
        }
        return dataList
    }
}
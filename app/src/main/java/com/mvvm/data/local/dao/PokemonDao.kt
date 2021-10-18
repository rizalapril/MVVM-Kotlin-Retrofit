package com.mvvm.data.local.dao

import com.mvvm.data.local.entity.NamedApiResourceDataLocal
import com.mvvm.data.local.entity.PokemonDataLocal
import com.mvvm.data.local.entity.PokemonTypeDataLocal
import com.mvvm.data.remote.model.PokemonResult
import com.mvvm.data.remote.model.PokemonType
import com.mvvm.util.CommonUtil
import io.realm.Realm

class PokemonDao {
    fun save(data: List<PokemonResult>){
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction { r ->
                for(data_ in data){
                    val newData = PokemonDataLocal()
                    newData.id = CommonUtil.generateUUID()
                    newData.name = data_.name
                    newData.url = data_.url

                    r.insertOrUpdate(newData)
                }
            }
        }
    }

    fun update(id : String, list: List<PokemonType>){
        Realm.getDefaultInstance().use { realm ->
            val data = realm.where(PokemonDataLocal::class.java)
                .equalTo("id", id)
                .findFirst()

            realm.executeTransaction { r ->

                if(data != null) {
                    if (list != null){
                        for (i in list) {
                            val namedData = NamedApiResourceDataLocal()
                            namedData.name = i.type.name
                            namedData.url = i.type.url

                            val typeData = PokemonTypeDataLocal()
                            typeData.type = namedData
                            typeData.slot = i.slot
                            data.types.add(typeData)
                        }
                    }
                }
            }
        }
    }

    fun findAllPokemon(): List<PokemonDataLocal>{
        Realm.getDefaultInstance().use { realm ->
            val data = realm.where(PokemonDataLocal::class.java)
                .findAll()

            var list = mutableListOf<PokemonDataLocal>()
            if(data != null){
                list = realm.copyFromRealm(data)
            }

            return list
        }
    }
}
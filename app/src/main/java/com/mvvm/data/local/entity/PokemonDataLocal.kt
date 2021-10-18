package com.mvvm.data.local.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class PokemonDataLocal: RealmObject() {
    @PrimaryKey
    var id: String? = ""
    var name: String? = ""
    var url: String? = ""
    var types = RealmList<PokemonTypeDataLocal>()
}
package com.mvvm.data.local.entity

import io.realm.RealmObject

open class PokemonTypeDataLocal: RealmObject() {
    var slot: Int? = 0
    var type: NamedApiResourceDataLocal? = null
}
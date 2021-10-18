package com.mvvm.data.local.entity

import io.realm.RealmObject

open class NamedApiResourceDataLocal: RealmObject() {
    var name: String? = ""
    var url: String? = ""
}
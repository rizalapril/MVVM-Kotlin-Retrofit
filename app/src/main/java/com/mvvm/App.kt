package com.mvvm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration 

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        // init realm
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .name("pokemon.realm")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }
}
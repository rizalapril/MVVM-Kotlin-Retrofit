package com.mvvm.util

import android.content.SharedPreferences

interface SharedPreferenceUtil {
    fun put(key: String, value: String)
    fun put(key: String, value: Int)
    fun put(key: String, value: Float)
    fun put(key: String, value: Boolean)
    fun getString(key: String): String
    fun getInt(key: String): Int
    fun getFloat(key: String): Float
    fun getBool(key: String): Boolean
    fun deleteSavedData(key: String)
}

class SharedPreferenceUtilImpl(
    private val sharedPreferences: SharedPreferences
): SharedPreferenceUtil {

    override fun put(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).commit()
    }

    override fun put(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).commit()
    }

    override fun put(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).commit()
    }

    override fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).commit()
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    override fun getFloat(key: String): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    override fun getBool(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    override fun deleteSavedData(key: String) {
        sharedPreferences.edit().remove(key).commit()
    }

}
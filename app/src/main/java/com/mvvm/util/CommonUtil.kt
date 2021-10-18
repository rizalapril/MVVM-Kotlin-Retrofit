package com.mvvm.util

import java.util.*

object CommonUtil {
    fun generateUUID(): String {
        val newUUID = UUID.randomUUID().toString().toLowerCase()
        return newUUID
    }
}
package com.example.jojo1.local.pref

import android.content.Context

class Pref(private val context: Context) {
    private var preferencer = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)

    fun saveUserName(dataName: String) {
        preferencer.edit().putString(PREF_GET_NAME_KEY, dataName).apply()
    }

    fun setUserName(): String {
        val userName = preferencer.getString(PREF_GET_NAME_KEY, null)
        return userName.toString()
    }


    companion object {
        const val PREF_KEY = "pref.key"
        const val PREF_GET_NAME_KEY = "pref.get.name.key"
    }
}
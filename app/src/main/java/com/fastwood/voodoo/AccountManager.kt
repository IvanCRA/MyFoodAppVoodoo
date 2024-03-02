package com.fastwood.voodoo

import android.content.Context
import com.google.gson.Gson

class AccountManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun registerUser(username: String, password: String) {
        val userData = UserData(username, password)
        val gson = Gson()
        val userDataJson = gson.toJson(userData)
        editor.putString(username, userDataJson)
        editor.apply()
    }

    // Проверка существования пользователя
    fun userExists(username: String): Boolean {
        return sharedPreferences.contains(username)
    }

    fun isPasswordCorrect(username: String, password: String): Boolean {
        val userDataJson = sharedPreferences.getString(username, null)
        val gson = Gson()
        val userData = gson.fromJson(userDataJson, UserData::class.java)
        return userData?.password == password
    }
}

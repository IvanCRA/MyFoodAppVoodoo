package com.fastwood.voodoo

import android.content.Context
import com.google.gson.Gson

class CartManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("cart_data", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun registerCart(image: Int, name: String, price: String) {
        val cartData = CartData(image, name, price)
        val gson = Gson()
        val cartDataJson = gson.toJson(cartData)
        editor.putString(name, cartDataJson)
        editor.apply()
    }
}
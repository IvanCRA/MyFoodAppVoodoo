package com.fastwood.voodoo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.fastwood.voodoo.AccountManager
import com.fastwood.voodoo.MainActivity
import com.fastwood.voodoo.R

class RegistrationAct : AppCompatActivity() {

    private lateinit var accountManager: AccountManager
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }

    fun login(view: View) {
        val intent = Intent ( this@RegistrationAct, LoginAct::class.java)
        startActivity(intent)
    }

    fun mainActivity(view: View) {

        username = findViewById(R.id.editText2)
        password = findViewById(R.id.editText3)

        val string_1 = username.text.toString()
        val string_2 = password.text.toString()

        accountManager = AccountManager(this)

        if (accountManager.userExists(string_1) && accountManager.isPasswordCorrect(string_1, string_2)) {
            Toast.makeText(this, "Такой пользователь существует!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ваш аккаунт зарегистрирован!", Toast.LENGTH_SHORT).show()
            accountManager.registerUser(string_1, string_2)
            val intent = Intent ( this@RegistrationAct, LoginAct::class.java)
            startActivity(intent)
        }
    }
}
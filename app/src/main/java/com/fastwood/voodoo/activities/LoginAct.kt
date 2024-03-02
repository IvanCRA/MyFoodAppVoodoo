package com.fastwood.voodoo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.Toast
import com.fastwood.voodoo.AccountManager
import com.fastwood.voodoo.MainActivity
import com.fastwood.voodoo.R

class LoginAct : AppCompatActivity() {

    private lateinit var accountManager: AccountManager
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun register(view: View) {
        val intent = Intent ( this@LoginAct, RegistrationAct::class.java)
        startActivity(intent)
    }

    fun mainActivity(view: View) {

        username = findViewById(R.id.editText2)
        password = findViewById(R.id.editText3)

        val string_1 = username.text.toString()
        val string_2 = password.text.toString()

        accountManager = AccountManager(this)

        // Пример входа
        if (accountManager.userExists(string_1) && accountManager.isPasswordCorrect(string_1, string_2)) {
            // Вход выполнен успешно
            Toast.makeText(this, "Вход выполнен успешно", Toast.LENGTH_SHORT).show()
            val intent = Intent ( this@LoginAct, MainActivity::class.java)
            startActivity(intent)
        } else {
            // Неверное имя пользователя или пароль
            Toast.makeText(this, "Неверное имя пользователя или пароль", Toast.LENGTH_SHORT).show()
        }

    }
}
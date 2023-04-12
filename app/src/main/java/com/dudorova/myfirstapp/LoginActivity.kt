package com.dudorova.myfirstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)

        val button = findViewById<Button>(R.id.ButtonLogIn)
        val editTextEmail = findViewById<EditText>(R.id.EnterEmail)
        val editTextPassword1 = findViewById<EditText>(R.id.EnterPassword)
        val autoLogin = findViewById<CheckBox>(R.id.CheckBox)

        button.setOnClickListener{
            val myLogin = editTextEmail.text.toString()
            val myPassword = editTextPassword1.text.toString()

            if(myLogin == sharedPreferences.getString("login", "none")
                && myPassword == sharedPreferences.getString("password", "none")) {
                sharedPreferences.edit().putBoolean("autoLogin",  autoLogin.isChecked).apply()
                val intent = Intent(this, ContentActivity :: class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Введен неверный логин или пароль", Toast.LENGTH_LONG).show()
            }
        }
    }
}
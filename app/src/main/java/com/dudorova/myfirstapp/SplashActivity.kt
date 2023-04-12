package com.dudorova.myfirstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
        val login = sharedPreferences.getString("login", "none")
        val autoLogin = sharedPreferences.getBoolean("autoLogin", false)

        if (login != "none" && !autoLogin){
            val intent = Intent(this, LoginActivity :: class.java)
            startActivity(intent)
        }

        if (login == "none"){
            val intent = Intent(this, RegistrationActivity :: class.java)
            startActivity(intent)
        }

        if (!login.isNullOrEmpty() && autoLogin){
            val intent = Intent(this, ContentActivity :: class.java)
            startActivity(intent)
        }
    }
}
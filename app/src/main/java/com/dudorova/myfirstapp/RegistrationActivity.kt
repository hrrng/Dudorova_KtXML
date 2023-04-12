package com.dudorova.myfirstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.text.InputType
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val button = findViewById<Button>(R.id.ButtonReg)
        val editTextEmail = findViewById<EditText>(R.id.EnterEmail)
        val editTextPassword1 = findViewById<EditText>(R.id.EnterPassword1)
        val editTextPassword2 = findViewById<EditText>(R.id.EnterPassword2)
        val textView2 = findViewById<TextView>(R.id.WithEmail)
        val textView = findViewById<TextView>(R.id.WithNumber)

        textView2.setOnClickListener {
            textView2.setTextColor(resources.getColor(R.color.green_A700))
            textView.setTextColor(resources.getColor(com.google.android.material.R.color.material_blue_grey_800))
            editTextEmail.setHint("Введите email")
            editTextEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }
        textView.setOnClickListener {
            textView.setTextColor(resources.getColor(R.color.green_A700))
            textView2.setTextColor(resources.getColor(com.google.android.material.R.color.material_blue_grey_800))
            editTextEmail.setHint("Введите номер")
            editTextEmail.inputType = InputType.TYPE_CLASS_PHONE
        }

        button.setOnClickListener {
            val myText = editTextEmail.text.toString()

            if (editTextEmail.inputType == InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS) {
                if (myText.isNotEmpty()
                    && myText.contains("@")
                )
                else {
                    Toast.makeText(this, "Введите корректный email c @", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }

            if(editTextEmail.inputType == InputType.TYPE_CLASS_PHONE) {
                if (myText.isNotEmpty()
                    && myText.contains("+")
                )
                else {
                    Toast.makeText(this, "Введите корректный номер телефона начинающийся с +", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }
            val myText3 = editTextPassword1.text.toString()
            if (myText3.isNotEmpty()
                && myText3.length > 8)
            else {
            Toast.makeText(this, "Минимальная длина пароля 8 символов",Toast.LENGTH_LONG).show()
                return@setOnClickListener
        }
            val myText4 = editTextPassword1.text.toString()
            if (myText4.isNotEmpty()
                && myText4.equals(editTextPassword2.text.toString()))
            else {
                Toast.makeText(this, "Пароли не совпадают",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)

            sharedPreferences.edit().putString("login", myText).apply()
            sharedPreferences.edit().putString("password", myText3).apply()

            val intent = Intent(this, ContentActivity :: class.java)
            startActivity(intent)
        }

    }
}

package com.dudorova.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.text.InputType
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val button = findViewById<Button>(R.id.ButtonReg)
        val editTextEmail = findViewById<EditText>(R.id.EnterEmail)
        val editTextPassword1 = findViewById<EditText>(R.id.EnterPassword1)
        val editTextPassword2 = findViewById<EditText>(R.id.EnterPassword2)
        val textView = findViewById<TextView>(R.id.WithEmail)
        val textView2 = findViewById<TextView>(R.id.WithNumber)
        button.setOnClickListener{
            val myText = editTextEmail.text.toString()
            if (myText.contains("@"))
            else {
                Toast.makeText(this, "Введите корректный email c @",Toast.LENGTH_LONG).show()
            }
            val myText2 = editTextEmail.text.toString()
            if (myText2.contains("+"))
            else {
                Toast.makeText(this, "Введите корректный номер телефона начинающийся с +",Toast.LENGTH_LONG).show()
            }
            val myText3 = editTextPassword1.text.toString().length.toInt()
            if (myText3.coerceAtLeast(8))
            else {
            Toast.makeText(this, "Минимальная длина пароля 8 символов",Toast.LENGTH_LONG).show()
        }
            val myText4 = editTextPassword1.text.toString()
            if (myText4.equals(editTextPassword2.text.toString()))
            else {
                Toast.makeText(this, "Пароли не совпадают",Toast.LENGTH_LONG).show()
            }
        }
        textView.setOnClickListener {
            textView.setTextColor(resources.getColor(R.color.purple_200))
            editTextEmail.setHint("Введите email")
            editTextEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }
        textView2.setOnClickListener {
            textView2.setTextColor(resources.getColor(R.color.purple_200))
            editTextEmail.setHint("Введите номер")
            editTextEmail.inputType = InputType.TYPE_CLASS_PHONE
        }
        editTextPassword1.setOnClickListener{

        }
        editTextPassword2.setOnClickListener{

        }
        }
    }

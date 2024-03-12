package com.example.myfirstapp

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val editName = findViewById<EditText>(R.id.editName)
        val editAddress = findViewById<EditText>(R.id.editAddress)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editSubject = findViewById<EditText>(R.id.editSubject)
        val editMessage = findViewById<EditText>(R.id.editMessage)

        btnSubmit.setOnClickListener {
            val name = editName.text.toString()
            val address = editAddress.text.toString()
            val email = editEmail.text.toString()
            val subject = editSubject.text.toString()
            val message = editMessage.text.toString()

            if (name.isEmpty() || address.isEmpty() || email.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                var emptyFields = "Поля не заполнены: "
                if (name.isEmpty()) emptyFields += "Имя, "
                if (address.isEmpty()) emptyFields += "Адрес, "
                if (email.isEmpty()) emptyFields += "Email, "
                if (subject.isEmpty()) emptyFields += "Тема, "
                if (message.isEmpty()) emptyFields += "Текст сообщения, "
                emptyFields = emptyFields.dropLast(2)
                Toast.makeText(this, emptyFields, Toast.LENGTH_LONG).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Некорректный Email", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Форма успешно отправлена!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
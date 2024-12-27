package com.example.contactsapp

import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        val phoneNumber = intent.getStringExtra("phone_number")

        val messageInput = findViewById<EditText>(R.id.et_message_text)
        val sendButton = findViewById<Button>(R.id.btn_send_message)

        sendButton.setOnClickListener {
            val message = messageInput.text.toString()
            if (message.isNotEmpty() && phoneNumber != null) {
                try {
                    val smsManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        this.getSystemService(SmsManager::class.java)
                    } else {
                        SmsManager.getDefault()
                    }
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null)
                    Toast.makeText(this, "Сообщение отправлено", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "Ошибка отправки сообщения", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
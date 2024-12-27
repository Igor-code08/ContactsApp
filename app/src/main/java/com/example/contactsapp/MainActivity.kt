package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.R.id.recycler_view_contacts

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Настройка RecyclerView
        recyclerView = findViewById(recycler_view_contacts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Пример данных
        val contacts = listOf(
            Contact("John", "Doe", "1234567890", "John Doe", "1234567890"),
            Contact("Jane", "Smith", "0987654321", "Jane Smith", "0987654321")
        )

        val adapter = ContactsAdapter(
            contacts,
            onCallClick = { phone -> /* Действие при нажатии на кнопку вызова */ },
            onMessageClick = { phone -> /* Действие при нажатии на кнопку сообщения */ }
        )
        recyclerView.adapter = adapter
    }
}
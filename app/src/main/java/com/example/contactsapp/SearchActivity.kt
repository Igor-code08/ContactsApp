package com.example.contactsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.databinding.ActivitySearchBinding


class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val allContacts = mutableListOf<Contact>() // Список всех контактов
    private val searchResults = mutableListOf<Contact>() // Результаты поиска

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Настройка Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Настройка RecyclerView
        val adapter = ContactsAdapter(searchResults)
        binding.recyclerViewSearchResults.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSearchResults.adapter = adapter

        // Кнопка "Найти"
        binding.buttonSearch.setOnClickListener {
            val query = binding.editTextSearch.text.toString()
            searchResults.clear()

            if (query.isNotEmpty()) {
                searchResults.addAll(allContacts.filter {
                    it.firstName.contains(query, ignoreCase = true) ||
                            it.lastName.contains(query, ignoreCase = true)
                })
                adapter.notifyDataSetChanged()
            }
        }
    }
}

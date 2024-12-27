package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactsAdapter(
    private val contacts: List<Contact>, // Тип изменен на Contact
    private val onCallClick: (Contact) -> Unit,
    private val onMessageClick: (String) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tv_contact_name)
        val phoneTextView: TextView = itemView.findViewById(R.id.tv_contact_phone)
        val callButton: ImageView = itemView.findViewById(R.id.iv_call)
        val messageButton: ImageView = itemView.findViewById(R.id.iv_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.nameTextView.text = contact.name
        holder.phoneTextView.text = contact.phone

        holder.callButton.setOnClickListener { onCallClick() }
        holder.messageButton.setOnClickListener { onMessageClick(contact.phone) }
    }

    private fun onCallClick() {
    }

    override fun getItemCount(): Int = contacts.size
}
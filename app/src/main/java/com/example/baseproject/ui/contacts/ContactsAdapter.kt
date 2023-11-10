package com.example.baseproject.ui.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.databinding.ItemContactBinding

class ContactsAdapter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mContacts = mutableListOf<Contact>()

    fun updateData(contacts: List<Contact>) {
        this.mContacts.clear()
        this.mContacts.addAll(contacts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount() = mContacts.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ContactViewHolder) {
            val contact = mContacts[holder.adapterPosition]
            holder.bind(contact)
        }
    }

    class ContactViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.tvName.text = contact.name
            binding.tvNumber.text = contact.number
        }
    }
}
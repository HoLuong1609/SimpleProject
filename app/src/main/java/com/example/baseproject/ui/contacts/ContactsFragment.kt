package com.example.baseproject.ui.contacts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseproject.databinding.FragmentContactsBinding
import com.example.baseproject.utils.ContactUtils

class ContactsFragment : Fragment() {

    private var adapter: ContactsAdapter? = null

    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        getContactList()
    }

    private fun initView() {
        adapter = ContactsAdapter(requireContext())
        binding.apply {
            rvContacts.layoutManager = LinearLayoutManager(context)
            rvContacts.setHasFixedSize(true)
            rvContacts.adapter = adapter
        }
    }

    private fun getContactList() {
        val contactList = ContactUtils.getContactList()
        adapter?.updateData(contactList)
        binding.tvNoContacts.isVisible = contactList.isEmpty()
    }

    companion object {

        fun newInstance(): ContactsFragment {
            return ContactsFragment()
        }
    }
}
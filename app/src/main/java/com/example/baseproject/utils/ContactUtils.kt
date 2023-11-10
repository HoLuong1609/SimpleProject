package com.example.baseproject.utils

import com.example.baseproject.ui.contacts.Contact
import kotlin.random.Random

object ContactUtils {

    fun getContactList(): List<Contact> {
        val list = mutableListOf<Contact>()
        list.add(Contact(1, "August", getRandomPhoneNumber()))
        list.add(Contact(2, "Celina Keith", getRandomPhoneNumber()))
        list.add(Contact(3, "David", getRandomPhoneNumber()))
        list.add(Contact(4, "Wade", getRandomPhoneNumber()))
        list.add(Contact(5, "Dave", getRandomPhoneNumber()))
        list.add(Contact(6, "Seth", getRandomPhoneNumber()))
        list.add(Contact(7, "Ivan", getRandomPhoneNumber()))
        list.add(Contact(8, "Riley", getRandomPhoneNumber()))
        list.add(Contact(9, "Gilbert", getRandomPhoneNumber()))
        list.add(Contact(10, "Jorge", getRandomPhoneNumber()))
        list.add(Contact(11, "Dan", getRandomPhoneNumber()))
        list.add(Contact(12, "Brian", getRandomPhoneNumber()))
        list.add(Contact(13, "Roberto", getRandomPhoneNumber()))
        list.add(Contact(14, "Ramon", getRandomPhoneNumber()))
        list.add(Contact(15, "Miles", getRandomPhoneNumber()))
        list.add(Contact(16, "Liam", getRandomPhoneNumber()))
        list.add(Contact(17, "Nathaniel", getRandomPhoneNumber()))
        list.add(Contact(18, "Ethan", getRandomPhoneNumber()))
        list.add(Contact(19, "Lewis", getRandomPhoneNumber()))
        list.add(Contact(20, "Milton", getRandomPhoneNumber()))
        return list
    }

    private fun getRandomPhoneNumber(): String {
        return "09${randomNumber()}${randomNumber()}${randomNumber()}${randomNumber()}${randomNumber()}${randomNumber()}${randomNumber()}${randomNumber()}"
    }

    private fun randomNumber() = Random.nextInt(9)
}
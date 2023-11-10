package com.example.baseproject.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.baseproject.ui.FavoritesFragment
import com.example.baseproject.ui.home.HomeFragment
import com.example.baseproject.ui.SettingsFragment
import com.example.baseproject.ui.contacts.ContactsFragment

class TabPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TAB_HOME -> HomeFragment.newInstance()
            TAB_CONTACTS -> ContactsFragment.newInstance()
            TAB_FAVORITES -> FavoritesFragment.newInstance()
            else -> SettingsFragment.newInstance()
        }
    }

    override fun getItemCount() = 4

    companion object {
        const val TAB_HOME = 0
        const val TAB_CONTACTS = 1
        const val TAB_FAVORITES = 2
        const val TAB_SETTINGS = 3
    }
}
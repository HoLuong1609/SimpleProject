package com.example.baseproject.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.baseproject.R
import com.example.baseproject.databinding.ActivityMainBinding
import com.example.baseproject.prefs.AppSettings
import com.example.baseproject.ui.main.TabPagerAdapter.Companion.TAB_CONTACTS
import com.example.baseproject.ui.main.TabPagerAdapter.Companion.TAB_FAVORITES
import com.example.baseproject.ui.main.TabPagerAdapter.Companion.TAB_HOME
import com.example.baseproject.ui.main.TabPagerAdapter.Companion.TAB_SETTINGS

class MainActivity : AppCompatActivity() {

    private var mPagerAdapter: TabPagerAdapter? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                this@MainActivity.handleOnBackPressed()
            }
        })
        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val itemAdd = menu.findItem(R.id.action_add)
        val itemFilter = menu.findItem(R.id.action_filter)
        when (binding.viewPager.currentItem) {
            TAB_HOME -> {
                itemAdd.isVisible = false
                itemFilter.isVisible = false
            }

            TAB_CONTACTS -> {
                itemAdd.isVisible = false
                itemFilter.isVisible = true
            }

            TAB_FAVORITES -> {
                itemAdd.isVisible = true
                itemFilter.isVisible = false
            }

            TAB_SETTINGS -> {
                itemAdd.isVisible = false
                itemFilter.isVisible = false
            }
        }
        return true
    }

    private fun initView() {
        mPagerAdapter = TabPagerAdapter(this)
        binding.apply {
            viewPager.isUserInputEnabled = false
            viewPager.offscreenPageLimit = 5
            viewPager.adapter = mPagerAdapter
            bottomBar.selectTabAtPosition(AppSettings.tabIndex)
            bottomBar.setOnTabSelectListener { tabId ->
                when (tabId) {
                    R.id.bb_menu_home -> {
                        viewPager.setCurrentItem(TAB_HOME, false)
                        AppSettings.tabIndex = TAB_HOME
                        supportActionBar?.title = getString(R.string.home)
                        invalidateOptionsMenu()
                    }

                    R.id.bb_menu_contacts -> {
                        viewPager.setCurrentItem(TAB_CONTACTS, false)
                        AppSettings.tabIndex = TAB_CONTACTS
                        supportActionBar?.title = getString(R.string.contacts)
                        invalidateOptionsMenu()
                    }

                    R.id.bb_menu_favorites -> {
                        viewPager.setCurrentItem(TAB_FAVORITES, false)
                        AppSettings.tabIndex = TAB_FAVORITES
                        supportActionBar?.title = getString(R.string.favorites)
                        invalidateOptionsMenu()
                    }

                    R.id.bb_menu_settings -> {
                        viewPager.setCurrentItem(TAB_SETTINGS, false)
                        AppSettings.tabIndex = TAB_SETTINGS
                        supportActionBar?.title = getString(R.string.settings)
                        invalidateOptionsMenu()
                    }
                }
            }
        }
    }

    private fun handleOnBackPressed() {
        finish()
    }
}
package com.example.baseproject.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.baseproject.ui.main.TabPagerAdapter.Companion.TAB_HOME

object AppSettings {

    private const val APP_SETTINGS_PREFS_NAME = "base_project_app"
    private lateinit var sharedPreferences: SharedPreferences
    private val LOCK = Any()

    fun init(context: Context) {
        if (!AppSettings::sharedPreferences.isInitialized) {
            synchronized(LOCK) {
                sharedPreferences =
                    context.getSharedPreferences(APP_SETTINGS_PREFS_NAME, Context.MODE_PRIVATE)
            }
        }
    }

    var tabIndex: Int
        set(value) {
            sharedPreferences.edit().apply {
                putInt(TAB_INDEX, value)
                apply()
            }
        }
        get() = sharedPreferences.getInt(TAB_INDEX, TAB_HOME)

    private const val TAB_INDEX = "tab_index"
}
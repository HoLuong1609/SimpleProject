package com.example.baseproject

import androidx.multidex.MultiDexApplication
import com.example.baseproject.prefs.AppSettings

class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AppSettings.init(this)
    }
}
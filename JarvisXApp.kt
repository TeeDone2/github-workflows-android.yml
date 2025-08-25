package com.jarvisx

import android.app.Application
import android.util.Log

class JarvisXApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("JarvisX", "App started")
    }
}
package com.example.uitestingwithhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UnitTestingWithHiltApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
package com.example.uitestingwithhilt

import androidx.annotation.VisibleForTesting
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TestApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        callMe()
    }

    @VisibleForTesting
    internal fun callMe() {

    }

}
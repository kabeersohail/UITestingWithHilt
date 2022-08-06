package com.example.uitestingwithhilt

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
class MainActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun firstTest() {
        Assert.assertEquals(1,1)
    }

}
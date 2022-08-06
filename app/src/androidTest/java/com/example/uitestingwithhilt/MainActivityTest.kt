package com.example.uitestingwithhilt

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun firstTest() {
        Assert.assertEquals(1,1)
    }

}
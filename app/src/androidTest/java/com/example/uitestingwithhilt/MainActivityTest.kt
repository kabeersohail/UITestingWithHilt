package com.example.uitestingwithhilt

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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

    @Test
    fun test_if_main_activity_is_visible() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_activity_layout)).check(matches(isDisplayed()))
    }

}
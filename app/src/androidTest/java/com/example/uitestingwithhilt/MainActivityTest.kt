package com.example.uitestingwithhilt

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun firstTest() {
        Assert.assertEquals(1,1)
    }

    @Test
    fun test_if_main_activity_is_visible() {
        onView(withId(R.id.main_activity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_if_main_activity_text_is_displayed() {
        onView(withId(R.id.main_activity_text)).check(matches(isDisplayed())) // method 1 to determine if text is visible
        onView(withId(R.id.main_activity_text)).check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // // method 2 to determine if text is visible
    }

    @Test
    fun test_if_main_activity_text_matches_as_expected() {
        onView(withId(R.id.main_activity_text)).check(matches(withText(R.string.main_activity)))
    }

}
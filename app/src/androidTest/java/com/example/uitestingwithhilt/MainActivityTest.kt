package com.example.uitestingwithhilt

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.uitestingwithhilt.commandscheduler.Command
import com.example.uitestingwithhilt.commandscheduler.CommandScheduler
import com.example.uitestingwithhilt.states.KioskLockState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Inject
    lateinit var commandScheduler: CommandScheduler

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun firstTest() {
        Assert.assertEquals(1,1)
    }

    @Test
    fun test_if_main_activity_is_visible() {
        onView(withId(R.id.main_activity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_if_main_activity_text_is_displayed()  {
        onView(withId(R.id.main_activity_text)).check(matches(isDisplayed())) // method 1 to determine if text is visible
        onView(withId(R.id.main_activity_text)).check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // // method 2 to determine if text is visible
    }

    @Test
    fun test_if_main_activity_text_matches_as_expected()  {
        onView(withId(R.id.main_activity_text)).check(matches(withText(R.string.main_activity)))
    }

    /**
     * Collection must happen before emission, or else the command will not be collected (used shared flow -> hot flow)
     *
     * But if replay is used, then the collection can happen before emission. replay will be cached based on the size.
     *
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testThatCollectorIsCalled() = runTest {

        activityScenarioRule.scenario.onActivity {

            val jobEmit = this.launch { commandScheduler.emitCommand(Command.KIOSK) }
            advanceUntilIdle()

            val jobCollect = this.launch{ it.obeyCommand(commandScheduler.commandFlow) }
            advanceUntilIdle()

            jobCollect.cancel()
            jobEmit.cancel()

            Assert.assertEquals(it.deviceState.kioskLockState, KioskLockState.Locked)
        }
    }

}
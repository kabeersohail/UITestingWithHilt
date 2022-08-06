package com.example.uitestingwithhilt

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class TestApplicationTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var testApplication: TestApplication

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun verifyIfIsCalledIsCalled() {
//        verify(exactly = 1) { testApplication.isCalled() }
    }

}
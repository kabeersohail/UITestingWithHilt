package com.example.uitestingwithhilt.customtestrunner

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.example.uitestingwithhilt.BaseApplication
import com.example.uitestingwithhilt.TestApplication
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltTestApplication

// A custom runner to set up the instrumented application class for tests.
class CustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}

@CustomTestApplication(BaseApplication::class)
interface MyTestApplication
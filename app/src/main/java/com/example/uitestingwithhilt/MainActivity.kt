package com.example.uitestingwithhilt

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.uitestingwithhilt.commandscheduler.CommandScheduler
import com.example.uitestingwithhilt.states.DeviceState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var commandScheduler: CommandScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @VisibleForTesting
    internal suspend fun obeyCommand() {

    }



}
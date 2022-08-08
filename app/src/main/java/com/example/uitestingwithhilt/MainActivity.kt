package com.example.uitestingwithhilt

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.uitestingwithhilt.commandscheduler.Command
import com.example.uitestingwithhilt.commandscheduler.CommandScheduler
import com.example.uitestingwithhilt.states.DeviceState
import com.example.uitestingwithhilt.states.KioskLockState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val deviceState: DeviceState = DeviceState()

    @Inject lateinit var commandScheduler: CommandScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @VisibleForTesting
    internal suspend fun obeyCommand(commandFlow: SharedFlow<Command>) {
        commandFlow.collect { collectedCommand ->
            when (collectedCommand) {
                Command.KIOSK -> processKiosk()
                Command.UNKIOSK -> processUnkiosk()
                Command.ADMIN_LOCK -> processAdminLock()
                Command.ADMIN_UNLOCK -> processAdminUnlock()
            }
        }
    }

    private fun processKiosk() {
        deviceState.kioskLockState = KioskLockState.Locked
    }

    private fun processUnkiosk() {

    }

    private fun processAdminLock() {

    }

    private fun processAdminUnlock() {

    }

}
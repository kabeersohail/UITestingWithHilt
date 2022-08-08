package com.example.uitestingwithhilt.commandscheduler

import com.example.uitestingwithhilt.states.DeviceState
import com.example.uitestingwithhilt.states.KioskLockState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class CommandScheduler @Inject constructor() {

    val deviceState: DeviceState = DeviceState()

    private val _commandFlow: MutableSharedFlow<Command> = MutableSharedFlow()
    private val commandFlow: SharedFlow<Command> = _commandFlow.asSharedFlow()

    suspend fun emitCommand(command: Command) = _commandFlow.emit(command)

    suspend fun collectCommand() {
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

enum class Command {
    KIOSK,
    UNKIOSK,
    ADMIN_LOCK,
    ADMIN_UNLOCK
}
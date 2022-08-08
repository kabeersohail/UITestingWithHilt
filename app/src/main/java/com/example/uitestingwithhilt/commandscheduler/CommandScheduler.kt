package com.example.uitestingwithhilt.commandscheduler

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class CommandScheduler @Inject constructor() {

    private val _commandFlow: MutableSharedFlow<Command> = MutableSharedFlow(replay = 1)
    val commandFlow: SharedFlow<Command> = _commandFlow.asSharedFlow()

    suspend fun emitCommand(command: Command) = _commandFlow.emit(command)

}

enum class Command {
    KIOSK,
    UNKIOSK,
    ADMIN_LOCK,
    ADMIN_UNLOCK
}
package com.devartiral.android.tempo

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Tick(
    private val context: Context,
    private val tempo: TempoViewModel,
    private val action: () -> Unit
) {
    val color = Color()
    private val sound = Sound(context, tempo)
    private val vibrator = Vibrate(context)

    fun tick() {
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                withContext(Dispatchers.Main) { play() }
                delay(tempo.getBpms())
            }
        }
    }

    fun isDarkMode() = color.isDarkMode()

    private fun play() {
        if (tempo.isPlaying()) {
            action()
            tempo.tick()
            if (tempo.canChangeColor()) color.changeColor()
            if (tempo.canSound()) sound.play()
            if (tempo.canVibrate()) vibrator.vibrate()
        }
    }
}
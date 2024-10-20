package com.devartiral.android.tempo

import android.content.Context
import android.media.MediaPlayer

class Sound(private val context: Context, private val tempo: TempoViewModel) {
    private var strongBeat: MediaPlayer? = null
    private var weakBeat: MediaPlayer? = null

    fun play() {
        initMediaPlayers()
        stopLastBeat()
        if (tempo.isCurrentStrongBeat())
            strongBeat?.start()
        else
            weakBeat?.start()
    }

    private fun initMediaPlayers() {
        if (strongBeat != null && weakBeat != null) return
        strongBeat = MediaPlayer.create(context, R.raw.beat_ring)
        weakBeat = MediaPlayer.create(context, R.raw.beat)
    }

    private fun stopLastBeat() {
        if (strongBeat?.isPlaying == true) {
            strongBeat?.stop()
            strongBeat?.prepare()
        }
        if (weakBeat?.isPlaying == true) {
            weakBeat?.stop()
            weakBeat?.prepare()
        }
    }
}
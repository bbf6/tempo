package com.devartiral.android.tempo

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity

class Vibrate(private val context: Context) {
    fun vibrate() {
        if (Build.VERSION.SDK_INT >= 26)
            (context.getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator).vibrate(
                VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE)
            )
        else
            (context.getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator).vibrate(150)
    }
}
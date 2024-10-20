package com.devartiral.android.tempo

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

class Color {
    private var _isDarkMode: Boolean = false

    fun isDarkMode() = _isDarkMode

    fun changeColor() {
        _isDarkMode = !_isDarkMode
    }
}
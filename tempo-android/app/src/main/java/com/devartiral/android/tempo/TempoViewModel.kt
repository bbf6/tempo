package com.devartiral.android.tempo

data class TempoViewModel(
    private var _isPlaying: Boolean = false,
    private var _canChangeColor: Boolean = true,
    private var _canSound: Boolean = true,
    private var _canVibrate: Boolean = true,
    var bpmSelected: Int = 85,
    private val timeSignatures: List<TimeSignature> = TimeSignature.getList(),
    private var _timeSignatureSelected: TimeSignature = timeSignatures[2],
    private var currentBeat: Int = 4
) {
    fun isPlaying() = _isPlaying
    fun togglePlaying() {
        _isPlaying = !_isPlaying
    }

    fun canChangeColor() = _canChangeColor
    fun toggleCanChangeColor() {
        _canChangeColor = !_canChangeColor
    }

    fun canSound() = _canSound
    fun toggleCanSound() {
        _canSound = !_canSound
    }

    fun canVibrate() = _canVibrate
    fun toggleCanVibrate() {
        _canVibrate = !_canVibrate
    }

    fun getCurrentTimeSignature(): String = _timeSignatureSelected.label
    fun setCurrentTimeSignature(index: Int) {
        _timeSignatureSelected = timeSignatures[index]
    }

    fun getCurrentBeat(): Int = currentBeat
    fun getBeats(): List<Boolean> = _timeSignatureSelected.beats
    fun totalBeats(): Int = getBeats().size
    fun isCurrentStrongBeat(): Boolean = getBeats()[currentBeat]

    fun getBpms(): Long = 60L * 1000 / bpmSelected

    fun tick() {
        currentBeat++
        if (currentBeat >= totalBeats()) currentBeat = 0
    }
}
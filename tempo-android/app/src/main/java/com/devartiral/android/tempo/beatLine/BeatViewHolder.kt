package com.devartiral.android.tempo.beatLine

import android.content.res.ColorStateList
import android.view.View
import android.widget.LinearLayout.LayoutParams
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.devartiral.android.tempo.Color
import com.devartiral.android.tempo.R

class BeatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        const val STRONG_BEAT: Int = 80
        const val SMALL_BEAT: Int = 50
    }

    private val cvBeat: CardView = view.findViewById(R.id.cvBeat)
    private val cvMark: CardView = view.findViewById(R.id.cvMark)

    fun render(isStrongBeat: Boolean, hitCurrentBeat: Boolean, color: Color) {
        setWeakBeat()
        cvMark.visibility = View.INVISIBLE
        if (isStrongBeat) setStrongBeat()
        if (hitCurrentBeat) cvMark.visibility = View.VISIBLE
        if (color.isDarkMode()) {
            cvBeat.backgroundTintList = getDarkTint()
            cvMark.backgroundTintList = getDarkTint()
        } else {
            cvBeat.backgroundTintList = getWhiteTint()
            cvMark.backgroundTintList = getWhiteTint()
        }
    }

    private fun setStrongBeat() {
        val newLayout = LayoutParams(STRONG_BEAT, STRONG_BEAT)
        newLayout.setMargins(8, 0, 0, 0)
        cvBeat.layoutParams = newLayout
    }

    private fun setWeakBeat() {
        val newLayout = LayoutParams(SMALL_BEAT, SMALL_BEAT)
        newLayout.setMargins(8, 10, 0, 0)
        cvBeat.layoutParams = newLayout
    }

    private fun getWhiteColor() = ContextCompat.getColor(cvBeat.context, R.color.white)
    private fun getDarkColor() = ContextCompat.getColor(cvBeat.context, R.color.dark)

    private fun getWhiteTint() = ColorStateList.valueOf(getWhiteColor())
    private fun getDarkTint() = ColorStateList.valueOf(getDarkColor())
}
package com.devartiral.android.tempo.beatLine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devartiral.android.tempo.Color
import com.devartiral.android.tempo.TempoViewModel
import com.devartiral.android.tempo.R

class BeatLineAdapter(val tempo: TempoViewModel, private val color: Color) : RecyclerView.Adapter<BeatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeatViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_beat, parent, false)
        return BeatViewHolder(view)
    }

    override fun getItemCount(): Int = tempo.totalBeats()

    override fun onBindViewHolder(holder: BeatViewHolder, position: Int) {
        val isStrongBeat = tempo.getBeats()[position]
        val hitCurrentBeat = tempo.getCurrentBeat() == position
        holder.render(isStrongBeat, hitCurrentBeat, color)
    }
}
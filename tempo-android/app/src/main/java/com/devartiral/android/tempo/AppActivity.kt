package com.devartiral.android.tempo

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devartiral.android.tempo.beatLine.BeatLineAdapter
import com.google.android.material.slider.RangeSlider

class AppActivity : AppCompatActivity() {
    private lateinit var mainLayout: LinearLayout
    private lateinit var viewBeatMark: CardView
    private lateinit var tvTimeSignature: TextView
    private lateinit var rvBeatLine: RecyclerView
    private lateinit var tvCurrentBpm: TextView
    private lateinit var rsBpm: RangeSlider
    private lateinit var btnPlay: Button
    private lateinit var btnColor: Button
    private lateinit var btnSound: Button
    private lateinit var btnVibrate: Button

    private val tempo = TempoViewModel()
    private val tick = Tick(this, tempo) { render() }
    private lateinit var beatLineAdapter: BeatLineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        initComponents()
        initUI()
        tick.tick()
    }

    private fun initComponents() {
        mainLayout = findViewById(R.id.mainLayout)
        viewBeatMark = findViewById(R.id.viewBeatMark)
        tvTimeSignature = findViewById(R.id.tvTimeSignature)
        rvBeatLine = findViewById(R.id.rvBeatLine)
        tvCurrentBpm = findViewById(R.id.tvCurrentBpm)
        rsBpm = findViewById(R.id.rsBpm)

        tvTimeSignature.text = tempo.getCurrentTimeSignature()
        tvCurrentBpm.text = tempo.bpmSelected.toString() + " BPM"

        btnPlay = findViewById(R.id.btnPlay)
        btnColor = findViewById(R.id.btnColor)
        btnSound = findViewById(R.id.btnSound)
        btnVibrate = findViewById(R.id.btnVibrate)

        rsBpm.setValues(85.0F)
        rsBpm.addOnChangeListener { _, value, _ ->
            tempo.bpmSelected = value.toInt()
            tvCurrentBpm.text = tempo.bpmSelected.toString() + " BPM"
        }

        btnPlay.setOnClickListener {
            tempo.togglePlaying()
            renderBtnPlay()
        }
        btnColor.setOnClickListener {
            tempo.toggleCanChangeColor()
            renderBtnColor()
        }
        btnSound.setOnClickListener {
            tempo.toggleCanSound()
            renderBtnSound()
        }
        btnVibrate.setOnClickListener {
            tempo.toggleCanVibrate()
            renderBtnVibrate()
        }
    }

    private fun initUI() {
        beatLineAdapter = BeatLineAdapter(tempo, tick.color)
        rvBeatLine.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvBeatLine.adapter = beatLineAdapter
        renderBtnPlay()
        renderBtnColor()
        renderBtnSound()
        renderBtnVibrate()
    }

    private fun render() {
        renderMainLayout()
        renderBeatMark()
        renderBeatLine()
        renderBtnPlay()
        renderBtnColor()
        renderBtnSound()
        renderBtnVibrate()
    }

    private fun renderBtnPlay() {
        val icon = if (tempo.isPlaying()) R.drawable.ic_pause else R.drawable.ic_play
        btnPlay.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        setButtonColor(btnPlay)
    }

    private fun renderBtnColor() {
        val icon = if (tempo.canChangeColor()) R.drawable.ic_color_off else R.drawable.ic_color
        btnColor.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        setButtonColor(btnColor)
    }

    private fun renderBtnSound() {
        val icon = if (tempo.canSound()) R.drawable.ic_mute else R.drawable.ic_sound
        btnSound.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        setButtonColor(btnSound)
    }

    private fun renderBtnVibrate() {
        val icon = if (tempo.canVibrate()) R.drawable.ic_vibrate_off else R.drawable.ic_vibrate
        btnVibrate.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        setButtonColor(btnVibrate)
    }

    private fun setButtonColor(button: Button) {
        if (tick.isDarkMode()) {
            button.setBackgroundColor(getWhiteColor())
            button.setCompoundDrawableTintList(getDarkTint())
        } else {
            button.setBackgroundColor(getDarkColor())
            button.setCompoundDrawableTintList(getWhiteTint())
        }
    }

    private fun renderMainLayout() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (tick.isDarkMode()) {
            mainLayout.setBackgroundColor(getDarkColor())
            window.statusBarColor = getDarkColor()
        } else {
            mainLayout.setBackgroundColor(getWhiteColor())
            window.statusBarColor = getWhiteColor()
        }
    }

    private fun renderBeatMark() {
        if (tick.isDarkMode()) {
            viewBeatMark.backgroundTintList = getWhiteTint()
            tvTimeSignature.setTextColor(getDarkColor())
            tvCurrentBpm.setTextColor(getWhiteColor())
        } else {
            viewBeatMark.backgroundTintList = getDarkTint()
            tvTimeSignature.setTextColor(getWhiteColor())
            tvCurrentBpm.setTextColor(getDarkColor())
        }
    }

    private fun renderBeatLine() {
        beatLineAdapter.notifyDataSetChanged()
    }

    private fun getWhiteColor() = ContextCompat.getColor(this, R.color.white)
    private fun getDarkColor() = ContextCompat.getColor(this, R.color.dark)

    private fun getWhiteTint() = ColorStateList.valueOf(getWhiteColor())
    private fun getDarkTint() = ColorStateList.valueOf(getDarkColor())
}
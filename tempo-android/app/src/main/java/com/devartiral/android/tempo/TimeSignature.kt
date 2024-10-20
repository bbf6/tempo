package com.devartiral.android.tempo

data class TimeSignature(val label: String, val beats: List<Boolean>) {
    companion object {
        fun getList() = listOf(
            TimeSignature("2/4", listOf(true, false)),
            TimeSignature("3/4", listOf(true, false, false)),
            TimeSignature("4/4", listOf(true, false, false, false)),
            TimeSignature("2/2", listOf(true, false)),
            TimeSignature("6/8", listOf(true, false, false, true, false, false)),
            TimeSignature(
                "9/8",
                listOf(true, false, false, true, false, false, true, false, false)
            ),
            TimeSignature(
                "12/8",
                listOf(
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    false,
                    false
                )
            ),
            TimeSignature("5/4", listOf(true, false, false, false, false)),
            TimeSignature("7/8", listOf(true, false, false, true, false, false)),
            TimeSignature("5/8", listOf(true, false, false, false, false)),
            TimeSignature("7/4", listOf(true, false, false, false, false, false, false)),
            TimeSignature("3/8", listOf(true, false, false)),
            TimeSignature("4/8", listOf(true, false, false, false)),
            TimeSignature("8/8", listOf(true, false, false, false, false, false, false, false)),
            TimeSignature(
                "11/8",
                listOf(true, false, false, true, false, false, true, false, false, false)
            ),
            TimeSignature(
                "13/8",
                listOf(
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    false
                )
            ),
            TimeSignature(
                "15/16",
                listOf(
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    false,
                    false,
                    false
                )
            )
        )
    }
}
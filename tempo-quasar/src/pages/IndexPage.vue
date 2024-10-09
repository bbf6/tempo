<template lang="pug">
q-page.flex.flex-center.column
  beat-mark
  beat-line
  bpm-selector
  #actions
    color-button
    play-button
    sound-button
time-signature-selector
</template>

<script setup>
import BeatMark from 'src/components/BeatMark'
import BeatLine from 'src/components/BeatLine'
import BpmSelector from 'src/components/BpmSelector'
import TimeSignatureSelector from 'src/components/TimeSignatureSelector'
import ColorButton from 'src/components/ColorButton'
import PlayButton from 'src/components/PlayButton'
import SoundButton from 'src/components/SoundButton'
</script>

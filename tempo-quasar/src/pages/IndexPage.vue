<template lang="pug">
q-page.flex.flex-center.column
  beat-mark
  beat-line
  bpm-selector
  play-button
time-signature-selector
</template>

<script setup>
import BeatMark from 'src/components/BeatMark'
import BeatLine from 'src/components/BeatLine'
import BpmSelector from 'src/components/BpmSelector'
import TimeSignatureSelector from 'src/components/TimeSignatureSelector'
import PlayButton from 'src/components/PlayButton'
</script>

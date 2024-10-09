<template lang="pug">
ul.beat-line
  li(
    v-for="(beat, index) in tempoStore.beats"
    :class="{ big: beat, current: isCurrentBeat(index) }"
  )
</template>

<script setup>
import { useTempoStore } from 'src/stores/tempo'

const tempoStore = useTempoStore()

const isCurrentBeat = index => tempoStore.currentBeat === index
</script>

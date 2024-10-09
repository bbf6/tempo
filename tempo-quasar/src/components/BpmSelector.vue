<template lang="pug">
.bpm-selector
  label="{{ tempoStore.bpmSelected }} BPM"
  q-slider(
    v-model="tempoStore.bpmSelected"
    :color="$q.dark.isActive ? 'white' : 'dark'"
    :min="40"
    :max="208"
  )
</template>

<script setup>
import { useQuasar } from 'quasar'
import { useTempoStore } from 'src/stores/tempo'

const $q = useQuasar()
const tempoStore = useTempoStore()
</script>

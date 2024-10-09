<template lang="pug">
q-dialog(v-model="tempoStore.showTimeSignatureSelector")
  q-card.time-signature-selector
    q-card-section(align="right")
      q-btn(icon="close" flat round dense v-close-popup)
    q-card-section(style="max-height: 500px; overflow: auto")
      q-list(bordered separator)
        q-item(
          v-for="time in tempoStore.timeSignatureLabels"
          clickable
          v-ripple
          :active="isCurrentBeat(time)"
        )
          q-item-section(
            @click="tempoStore.selectTimeSignature(time)"
          )="{{ time }}"
</template>

<script setup>
import { useTempoStore } from 'src/stores/tempo'

const tempoStore = useTempoStore()
const isCurrentBeat = time => tempoStore.timeSignatureSelected.label === time
</script>

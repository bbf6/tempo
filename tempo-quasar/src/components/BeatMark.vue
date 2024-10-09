<template lang="pug">
.beat-mark-container(@click="toggleTimeSignature")
  figure(:class="{ beating: beating }")
  h1="{{ tempoStore.timeSignatureLabel }}"
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useTempoStore } from 'src/stores/tempo'
import { sleep } from 'src/lib/time'

const tempoStore = useTempoStore()
const beating = ref(false)

const toggleTimeSignature = () =>
  tempoStore.showTimeSignatureSelector = !tempoStore.showTimeSignatureSelector

const tick = async () => {
  if (tempoStore.playing) beating.value = !beating.value
  tempoStore.tick()
  await sleep(tempoStore.bpms)
  tick()
}

onMounted(tick)
</script>

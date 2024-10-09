<template lang="pug">
q-btn.q-mt-xl(
  size="lg"
  :icon="icon"
  :color="$q.dark.isActive ? 'white' : 'dark'"
  :text-color="$q.dark.isActive ? 'dark' : 'white'"
  @click="tempoStore.changeVibration = !tempoStore.changeVibration"
)
</template>

<script setup>
import { computed } from 'vue'
import { useQuasar } from 'quasar'
import { useTempoStore } from 'src/stores/tempo'

const $q = useQuasar()
const tempoStore = useTempoStore()

const icon = computed(
  () => tempoStore.changeVibration ? 'app_blocking' : 'vibration'
)
</script>

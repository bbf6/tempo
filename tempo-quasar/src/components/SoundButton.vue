<template lang="pug">
q-btn.q-mt-xl(
  :icon="icon"
  :color="$q.dark.isActive ? 'white' : 'dark'"
  :text-color="$q.dark.isActive ? 'dark' : 'white'"
  @click="tempoStore.mute = !tempoStore.mute"
)
</template>

<script setup>
import { computed } from 'vue'
import { useQuasar } from 'quasar'
import { useTempoStore } from 'src/stores/tempo'

const $q = useQuasar()
const tempoStore = useTempoStore()

const icon = computed(() => tempoStore.mute ? 'volume_off' : 'volume_up')
</script>

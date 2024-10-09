<template lang="pug">
q-btn.q-mt-xl(
  :icon="icon"
  :color="$q.dark.isActive ? 'white' : 'dark'"
  :text-color="$q.dark.isActive ? 'dark' : 'white'"
  @click="tempoStore.playing = !tempoStore.playing"
)
</template>

<script setup>
import { computed } from 'vue'
import { useQuasar } from 'quasar'
import { useTempoStore } from 'src/stores/tempo'

const $q = useQuasar()
const tempoStore = useTempoStore()

const icon = computed(() => tempoStore.playing ? 'pause' : 'play_arrow')
</script>

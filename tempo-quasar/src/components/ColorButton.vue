<template lang="pug">
q-btn.q-mt-xl(
  size="lg"
  :icon="icon"
  :color="$q.dark.isActive ? 'white' : 'dark'"
  :text-color="$q.dark.isActive ? 'dark' : 'white'"
  @click="tempoStore.changeColor = !tempoStore.changeColor"
)
</template>

<script setup>
import { computed } from 'vue'
import { useQuasar } from 'quasar'
import { useTempoStore } from 'src/stores/tempo'

const $q = useQuasar()
const tempoStore = useTempoStore()

const icon = computed(
  () => tempoStore.changeColor ? 'invert_colors_off' : 'invert_colors'
)
</script>

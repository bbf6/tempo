import { defineStore } from 'pinia'
import { Dark } from 'quasar'
import times from 'src/data/timeSignatures'

export const useTempoStore = defineStore('tempo', {
  state: () => ({
    playing: false,
    colorToggled: false,
    bpmSelected: 50,
    timeSignatures: times,
    timeSignatureSelected: times[2],
    currentBeat: 0,
    showTimeSignatureSelector: false
  }),
  getters: {
    timeSignatureLabels (state) {
      return state.timeSignatures.map(time => time.label)
    },
    timeSignatureLabel (state) {
      return state.timeSignatureSelected?.label || ''
    },
    beats (state) {
      return state.timeSignatureSelected?.beats || []
    },
    totalBeats (state) {
      return state.beats.length
    },
    bpms (state) {
      return 60 * 1000 / state.bpmSelected
    }
  },
  actions: {
    selectTimeSignature (time) {
      const timeSignatureFound = this.timeSignatures.find(t => t.label === time)
      this.timeSignatureSelected = timeSignatureFound
      this.currentBeat = 0
      this.showTimeSignatureSelector = false
    },
    tick () {
      if (!this.playing) return
      Dark.toggle()
      this.currentBeat++
      if (this.currentBeat === this.totalBeats)
        this.currentBeat = 0
    }
  }
})

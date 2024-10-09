import { defineStore } from 'pinia'
import { Dark } from 'quasar'
import times from 'src/data/timeSignatures'
import { play } from 'src/lib/sound'

export const useTempoStore = defineStore('tempo', {
  state: () => ({
    playing: false,
    colorToggled: false,
    mute: false,
    bpmSelected: 50,
    timeSignatures: times,
    timeSignatureSelected: times[2],
    currentBeat: 4,
    showTimeSignatureSelector: false
  }),
  getters: {
    timeSignatureLabels (state) {
      return state.timeSignatures.map(time => time.label)
    },
    timeSignatureLabel (state) {
      return state.timeSignatureSelected.label
    },
    beats (state) {
      return state.timeSignatureSelected.beats
    },
    totalBeats (state) {
      return state.beats.length
    },
    isCurrentStrongBeat (state) {
      return state.beats[state.currentBeat]
    },
    bpms (state) {
      return 60 * 1000 / state.bpmSelected
    }
  },
  actions: {
    selectTimeSignature (time) {
      const timeSignatureFound = this.timeSignatures.find(t => t.label === time)
      this.timeSignatureSelected = timeSignatureFound
      this.currentBeat = this.totalBeats
      this.showTimeSignatureSelector = false
    },
    tick () {
      if (!this.playing) return
      Dark.toggle()
      this.currentBeat++
      if (this.currentBeat >= this.totalBeats)
        this.currentBeat = 0
      if (!this.mute) play(this.isCurrentStrongBeat)
    }
  }
})

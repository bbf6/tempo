const getFileName = strong => strong ? 'beat-ring.mp3' : 'beat.mp3'

const play = strong => {
  const fileName = getFileName(strong)
  const audio = new Audio(fileName)
  audio.play()
}

export { play }

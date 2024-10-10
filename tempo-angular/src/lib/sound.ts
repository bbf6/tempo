const getFileName = (strong:boolean):string =>
  strong ? 'beat-ring.mp3' : 'beat.mp3'

const play = (strong:boolean):void => {
  const fileName = getFileName(strong)
  const audio = new Audio(fileName)
  audio.play()
}

export { play };

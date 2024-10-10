const getFileName = (strong:boolean):string =>
  strong ? 'src/assets/beat-ring.mp3' : 'src/assets/beat.mp3'

const play = (strong:boolean):void => {
  const audio = new Audio(getFileName(strong));
  audio.play();
}

export { play };

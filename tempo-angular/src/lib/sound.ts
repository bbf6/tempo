const getFileName = (strong:boolean):string =>
  strong ? 'assets/beat-ring.mp3' : 'assets/beat.mp3'

const play = (strong:boolean):void => {
  const audio = new Audio(getFileName(strong));
  audio.play();
}

export { play };

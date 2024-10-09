const DURATION = 200
const hasVibration = () => 'vibrate' in navigator

const vibrate = async () => {
  if (!hasVibration()) return
  navigator.vibrate(DURATION)
}

export { vibrate }

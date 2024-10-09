import { Capacitor } from '@capacitor/core'
import { Haptics, ImpactStyle } from '@capacitor/haptics'

const DURATION = 200

const isMobile = () => Capacitor.isNativePlatform()
const hasVibration = () => 'vibrate' in navigator

const vibrate = async () => {
  if (!hasVibration()) return
  if (isMobile()) return await Haptics.vibrate({ duration: DURATION })
  navigator.vibrate(DURATION)
}

export { vibrate }

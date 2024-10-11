import { Component, OnInit } from '@angular/core';
import { TempoService } from '../tempo.service';

const ICON_PATH = 'assets/images/'

@Component({
  selector: 'actions',
  templateUrl: './actions.component.html',
  styleUrls: ['./actions.component.scss']
})
export class ActionsComponent  implements OnInit {
  tempo:TempoService;

  constructor(tempo:TempoService) { this.tempo = tempo; }

  ngOnInit() {}

  getPlayIcon():string {
    return this.tempo.isPlaying() ? 'pause' : 'play';
  }

  darkMode():string {
    return this.tempo.isColorToggled() ? '_dark' : ''
  }

  getColorIcon():string {
    return this.tempo.isColorChanging() ?
      `${ICON_PATH}color_toggle_cancel${this.darkMode()}.svg` :
      `${ICON_PATH}color_toggle${this.darkMode()}.svg`;
  }

  getSoundIcon():string {
    return this.tempo.isMuted() ? 'volume-high' : 'volume-mute'
  }

  getVibrationIcon():string {
    return this.tempo.isVibrating() ?
      `${ICON_PATH}vibration_toggle_cancel${this.darkMode()}.svg` :
      `${ICON_PATH}vibration_toggle${this.darkMode()}.svg`;
  }

}

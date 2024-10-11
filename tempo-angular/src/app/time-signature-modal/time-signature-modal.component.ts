import { Component, OnInit } from '@angular/core';
import { OverlayEventDetail } from '@ionic/core/components';
import { TempoService } from '../tempo.service';

@Component({
  selector: 'time-signature-modal',
  templateUrl: './time-signature-modal.component.html',
  styleUrls: ['./time-signature-modal.component.scss'],
})
export class TimeSignatureModalComponent  implements OnInit {
  tempo:TempoService;

  constructor(tempo:TempoService) { this.tempo = tempo; }

  ngOnInit() {}

  getColor(time:string):string {
    return this.tempo.getTimeSignatureLabel() === time ? 'primary' : 'dark';
  }

}

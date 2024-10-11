import { Component, OnInit } from '@angular/core';
import { TempoService } from '../tempo.service';

@Component({
  selector: 'bpm-selector',
  templateUrl: './bpm-selector.component.html',
  styleUrls: ['./bpm-selector.component.scss'],
})
export class BpmSelectorComponent  implements OnInit {
  tempo:TempoService;

  constructor(tempo:TempoService) { this.tempo = tempo; }

  ngOnInit() {}

  changeBpm(event:any):void { this.tempo.setBpm(event.detail.value); }

}

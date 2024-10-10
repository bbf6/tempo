import { Component, OnInit } from '@angular/core';
import { TempoService } from '../tempo.service';

@Component({
  selector: 'beat-line',
  templateUrl: './beat-line.component.html',
  styleUrls: ['./beat-line.component.scss'],
})
export class BeatLineComponent  implements OnInit {
  tempo:TempoService;

  constructor(tempo:TempoService) { this.tempo = tempo; }

  ngOnInit() {}

  isCurrentBeat(index:number):boolean {
    return this.tempo.getCurrentBeat() === index;
  }

}

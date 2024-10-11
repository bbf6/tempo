import { Component, OnInit } from '@angular/core';
import { TempoService } from '../tempo.service';
import { sleep } from 'src/lib/time';

@Component({
  selector: 'beat-mark',
  templateUrl: './beat-mark.component.html',
  styleUrls: ['./beat-mark.component.scss']
})
export class BeatMarkComponent implements OnInit {
  beating:boolean = false;
  tempo:TempoService;

  constructor(tempo:TempoService) { this.tempo = tempo; }

  ngOnInit() { this.tick(); }

  async tick() {
    if (this.tempo.isPlaying()) this.beating = !this.beating;
    this.tempo.tick();
    await sleep(this.tempo.getBpms());
    this.tick();
  }

}

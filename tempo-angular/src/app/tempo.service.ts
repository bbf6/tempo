import { Injectable } from '@angular/core';
import times from 'src/data/timeSignatures';
import { play } from 'src/lib/sound'
import TimeSignature from 'src/interfaces/time.signature'

@Injectable({
  providedIn: 'root'
})
export class TempoService {
  private playing:boolean = false;
  private colorToggled:boolean = false;
  private mute:boolean = false;
  private changeColor:boolean = true;
  private changeVibration:boolean = true;
  private bpmSelected:number = 85;
  private timeSignatures:TimeSignature[] = times;
  private timeSignatureSelected:TimeSignature = times[2];
  private currentBeat:number = 4;
  private showTimeSignatureSelector:boolean = false;

  isPlaying():boolean { return this.playing; }
  togglePlaying():void { this.playing = !this.playing; }

  isColorToggled():boolean { return this.colorToggled; }
  toggleColor():void { this.colorToggled = !this.colorToggled; }

  isMuted():boolean { return this.mute; }
  toggleMute():void { this.mute = !this.mute; }

  getBpm():number { return this.bpmSelected; }
  setBpm(value:number):void { this.bpmSelected = value; }
  getBpms():number { return 60 * 1000 / this.bpmSelected; }

  getTimeSignatures():TimeSignature[] { return this.timeSignatures; }
  getTimeSignaturesLabels():string[] {
    return this.timeSignatures.map(t => t.label);
  }
  getTimeSignatureLabel():string { return this.timeSignatureSelected.label; }

  getBeats():boolean[] { return this.timeSignatureSelected.beats; }
  getTotalBeats():number { return this.getBeats().length; }
  isCurrentStrongBeat():boolean { return this.getBeats()[this.currentBeat]; }
  getCurrentBeat():number { return this.currentBeat; }

  openSignatureSelection():void {
    this.showTimeSignatureSelector = true;
  }

  selectTimeSignature(time:string):void {
    const timeSignatureFound:TimeSignature = this.timeSignatures
      .find(t => t.label === time) || this.timeSignatures[0];
    this.timeSignatureSelected = timeSignatureFound;
    this.currentBeat = this.getTotalBeats();
    this.showTimeSignatureSelector = false;
  }

  async tick():Promise<void> {
    if (!this.playing) return;
    // if (this.changeColor) Dark.toggle()
    this.currentBeat++;
    if (this.currentBeat >= this.getTotalBeats())
      this.currentBeat = 0;
    if (!this.mute) play(this.isCurrentStrongBeat());
  }
}

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { AppComponent } from './app.component';
import { BeatMarkComponent } from './beat-mark/beat-mark.component';
import { BeatLineComponent } from './beat-line/beat-line.component';
import { BpmSelectorComponent } from './bpm-selector/bpm-selector.component';
import { ActionsComponent } from './actions/actions.component';
import { TimeSignatureModalComponent } from './time-signature-modal/time-signature-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    BeatMarkComponent,
    BeatLineComponent,
    BpmSelectorComponent,
    ActionsComponent,
    TimeSignatureModalComponent
  ],
  imports: [BrowserModule, IonicModule.forRoot()],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}

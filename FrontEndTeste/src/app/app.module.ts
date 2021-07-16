import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { OrdemServicoService } from './services/ordem-servico.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OrdemServicoComponent } from './components/ordem-servico-component/ordem-servico.component';

@NgModule({
  declarations: [
    AppComponent,
    OrdemServicoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [HttpClient,],
  bootstrap: [AppComponent]
})
export class AppModule { }

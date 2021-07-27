import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ServiceOrderService } from './services/service-order.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OrdemServicoComponent } from './components/ordem-servico-component/ordem-servico.component';
import { ListagemComponent } from './components/ordem-servico-component/listagem/listagem.component';
import { FormularioComponent } from './components/ordem-servico-component/formulario/formulario.component';

@NgModule({
  declarations: [
    AppComponent,
    OrdemServicoComponent,
    ListagemComponent,
    FormularioComponent
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

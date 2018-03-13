import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {WelcomeService} from "./welcome/welcome.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";



@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [WelcomeService, HttpClient, ],
  bootstrap: [AppComponent]
})
export class AppModule { }

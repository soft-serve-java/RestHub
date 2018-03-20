import { BrowserModule } from '@angular/platform-browser';
import { NgModule, InjectionToken } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {WelcomeService} from "./services/welcome.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { AppService } from './services/app.service';
import { environment } from '../environments/environment';
import { CookComponent } from './cook/cook.component';
import { WaiterTablesComponent } from './waiter/waiter-tables/waiter-tables.component';
import {WaiterService} from "./services/waiter.service";
import { WaiterOdrerComponent } from './waiter/waiter-odrer/waiter-odrer.component';
import {OrderService} from "./services/order.service";

export const API_URL = new InjectionToken<string>('apiUrl');
export const SOCKET_URL = new InjectionToken<string>('socketUrl');

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CookComponent,
    WelcomeComponent,
    WaiterTablesComponent,
    WaiterOdrerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [WelcomeService,WaiterService , OrderService, HttpClient, AppService, {provide: "API_URL", useValue: environment.apiUrl},
    {provide: "SOCKET_URL", useValue: environment.socketUrl}],
  bootstrap: [AppComponent]
})
export class AppModule { }

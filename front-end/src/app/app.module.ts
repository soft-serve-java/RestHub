import { BrowserModule } from '@angular/platform-browser';
import { NgModule, InjectionToken } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {WelcomeService} from "./services/welcome.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { AppService } from './services/app.service';
import { environment } from '../environments/environment';
import { MenuComponent } from './menu/menu.component';
import { MenuService } from './services/menu.service';
import { StorageServiceModule} from 'angular-webstorage-service';
import { DishPageComponent } from './dish-page/dish-page.component';

export const API_URL = new InjectionToken<string>('apiUrl');

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    MenuComponent,
    DishPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    StorageServiceModule
  ],
  providers: [WelcomeService, HttpClient, AppService, MenuService,
     {provide: "API_URL", useValue: environment.apiUrl}
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

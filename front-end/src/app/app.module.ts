import { BrowserModule } from '@angular/platform-browser';
import { NgModule, InjectionToken } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {WelcomeService} from "./services/welcome.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { AppService } from './services/app.service';
import { environment } from '../environments/environment';
import {AdminComponent} from "./admin/admin.component";
import {AdminUserComponent} from "./admin-user/admin-user.component";
import {AdminUserService} from "./services/admin-user.service";
import {AdminDishComponent} from "./admin-dish/admin-dish.component";
import {AdminDishService} from "./services/admin-dish.service";

export const API_URL = new InjectionToken<string>('apiUrl');

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    AdminComponent,
    AdminUserComponent,
    AdminDishComponent,
    WelcomeComponent,
    WelcomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
  ],
  providers: [WelcomeService, HttpClient, AppService, AdminUserService, AdminDishService,
     {provide: "API_URL", useValue: environment.apiUrl}
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

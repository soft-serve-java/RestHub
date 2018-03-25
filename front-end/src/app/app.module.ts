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
import {CommonModule} from "@angular/common";
import { OrderComponent } from './order/order.component';
import { CookComponent } from './cook/cook.component';
import { WaiterTablesComponent } from './waiter/waiter-tables/waiter-tables.component';
import {WaiterService} from "./services/waiter.service";
import { WaiterOdrerComponent } from './waiter/waiter-odrer/waiter-odrer.component';
import {OrderService} from "./services/order.service";
import {StatusService} from "./services/status.service";
import { HeaderComponent } from './layout/parts/header/header.component';
import { FooterComponent } from './layout/parts/footer/footer.component';
import { AdminComponent } from './layout/admin/admin.component';
import { WaiterComponent } from './layout/waiter/waiter.component';
import { UserComponent } from './layout/user/user.component';
import { WaiterHeaderComponent } from './layout/parts/waiter-header/waiter-header.component';
import { AdminHeaderComponent } from './layout/parts/admin-header/admin-header.component';

export const API_URL = new InjectionToken<string>('apiUrl');
export const SOCKET_URL = new InjectionToken<string>('socketUrl');

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CookComponent,
    WelcomeComponent,
    WaiterTablesComponent,
    WaiterOdrerComponent,
    WelcomeComponent,
    MenuComponent,
    DishPageComponent,
    OrderComponent,
    HeaderComponent,
    FooterComponent,
    AdminComponent,
    WaiterComponent,
    UserComponent,
    WaiterHeaderComponent,
    AdminHeaderComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    StorageServiceModule
  ],
  providers: [WelcomeService, WaiterService, MenuService, StatusService, OrderService, HttpClient, AppService, {provide: "API_URL", useValue: environment.apiUrl},
    {provide: "SOCKET_URL", useValue: environment.socketUrl}],
  bootstrap: [AppComponent]
})
export class AppModule { }

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
import { WaiterTablesComponent } from './waiter-tables/waiter-tables.component';
import {WaiterService} from "./services/waiter.service";
import {AdminUserService} from "./services/admin-user.service";
import { DishPageComponent } from './dish-page/dish-page.component';
import {AdminDishComponent} from "./admin-dish/admin-dish.component";
import {AdminDishService} from "./services/admin-dish.service";
import { AdminCategoryComponent } from './admin-category/admin-category.component';
import {AdminCategoryService} from "./services/admin-category.service";
import { AdminCategoryAddComponent } from './admin-category-add/admin-category-add.component';
import {AdminCategoryAddService} from "./services/admin-category-add.service";
import {FormsModule} from "@angular/forms";
import { AdminOrderComponent } from './admin-order/admin-order.component';
import { AdminOrderService } from './services/admin-order.service';
import { AdminLtComponent} from './layouts/admin/';
export const API_URL = new InjectionToken<string>('apiUrl');

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    AdminComponent,
    AdminUserComponent,
    AdminDishComponent,
    WelcomeComponent,
    WaiterTablesComponent,
    WelcomeComponent,
    DishPageComponent,
    AdminCategoryComponent,
    AdminCategoryAddComponent,
    AdminOrderComponent,
    AdminLtComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    FormsModule,
  ],
  providers: [WelcomeService, HttpClient,AdminOrderService, AppService, AdminUserService, AdminDishService, AdminCategoryService, AdminCategoryAddService,
     {provide: "API_URL", useValue: environment.apiUrl}
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

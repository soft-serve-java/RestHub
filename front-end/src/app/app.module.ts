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
import { LoginComponent } from './login/login.component';
import {AuthService} from "./services/auth.service";
import {FormsModule} from "@angular/forms";
import {JwtHelperService} from "@auth0/angular-jwt";
import {AuthGuardService} from "./services/auth-guard.service";
import { RegistrationComponent } from './registration/registration.component';
import {OrderStorageService} from "./services/order-storage.service";

export const API_URL = new InjectionToken<string>('apiUrl');
export const SOCKET_URL = new InjectionToken<string>('socketUrl');
export const LOGIN_URL = new InjectionToken<string>('loginUrl');

@NgModule({
  declarations: [
    AppComponent,
    CookComponent,
    WaiterTablesComponent,
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
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    FormsModule,
  ],
  providers: [WelcomeService, HttpClient,AdminOrderService, AppService, AdminUserService, AdminDishService, AdminCategoryService, AdminCategoryAddService,
     {provide: "API_URL", useValue: environment.apiUrl}
    ],
  ],
  providers: [WelcomeService, WaiterService,OrderStorageService, MenuService, StatusService, AuthGuardService, AuthService , OrderService, HttpClient, AppService, {provide: "API_URL", useValue: environment.apiUrl},
    {provide: "SOCKET_URL", useValue: environment.socketUrl},{provide: "LOGIN_URL", useValue: environment.loginUrl}],
  bootstrap: [AppComponent]
})
export class AppModule { }

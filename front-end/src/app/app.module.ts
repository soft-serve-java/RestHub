import { BrowserModule } from '@angular/platform-browser';
import { NgModule, InjectionToken } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {WelcomeService} from "./services/welcome.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { AppService } from './services/app.service';
import { environment } from '../environments/environment';
import {AdminUserComponent} from "./admin/admin-user/admin-user.component";
import {AdminUserService} from "./services/admin-user.service";
import { DishPageComponent } from './dish-page/dish-page.component';
import {AdminDishComponent} from "./admin/admin-dish/admin-dish.component";
import {AdminDishService} from "./services/admin-dish.service";
import { AdminCategoryComponent } from './admin/admin-category/admin-category.component';
import {AdminCategoryService} from "./services/admin-category.service";
import { AdminCategoryAddComponent } from './admin/admin-category-add/admin-category-add.component';
import { AdminOrderComponent } from './admin/admin-order/admin-order.component';
import { AdminOrderService } from './services/admin-order.service';
import {CommonModule} from "@angular/common";
import { CookComponent } from './cook/cook.component';
import {OrderService} from "./services/order.service";
import {StatusService} from "./services/status.service";
import {AuthService} from "./services/auth.service";
import {FormsModule} from "@angular/forms";
import {AuthGuardService} from "./services/auth-guard.service";
import {OrderStorageService} from "./services/order-storage.service";
import {AdminComponent} from "./layout/admin/admin.component";
import {MenuService} from "./services/menu.service";
import {WaiterTablesComponent} from "./waiter/waiter-tables/waiter-tables.component";
import {WaiterService} from "./services/waiter.service";
import {UserComponent} from "./layout/user/user.component";
import {OrderComponent} from "./order/order.component";
import {MenuComponent} from "./menu/menu.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {WaiterComponent} from "./layout/waiter/waiter.component";
import {WaiterOdrerComponent} from "./waiter/waiter-odrer/waiter-odrer.component";
import {AdminHeaderComponent} from "./layout/parts/admin-header/admin-header.component";
import {WaiterHeaderComponent} from "./layout/parts/waiter-header/waiter-header.component";
import {HeaderComponent} from "./layout/parts/header/header.component";
import {FooterComponent} from "./layout/parts/footer/footer.component";
import {StorageServiceModule} from "angular-webstorage-service";
import {AdminDishAddComponent} from "./admin/admin-dish-add/admin-dish-add.component";
import {AdminDishEditComponent} from "./admin/admin-dish-edit/admin-dish-edit.component";
import {AdminCategoryEditComponent} from "./admin/admin-category-edit/admin-category-edit.component";
import {AdminUserEditComponent} from "./admin/admin-user-edit/admin-user-edit.component";
import {AdminOrderEditComponent} from "./admin/admin-order-edit/admin-order-edit.component";
import {AdminRoleComponent} from "./admin/admin-role/admin-role.component";
import {AdminStatusComponent} from "./admin/admin-status/admin-status.component";
import { AdminTableComponent } from './admin/admin-table/admin-table.component';
import {TableStorageService} from "./services/table-storage.service";
import { TokenConfermeComponent } from './token-conferme/token-conferme.component';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import {StaticticService} from "./services/statictic.service";
import {
  MatButtonModule, MatCardModule, MatDialogModule, MatFormFieldModule,
  MatInputModule
} from '@angular/material';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { WishComponent } from './wish/wish.component';

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
    AdminDishAddComponent,
    AdminDishEditComponent,
    WelcomeComponent,
    WaiterTablesComponent,
    WelcomeComponent,
    DishPageComponent,
    AdminCategoryComponent,
    AdminCategoryAddComponent,
    AdminCategoryEditComponent,
    AdminUserEditComponent,
    AdminOrderComponent,
    UserComponent,
    OrderComponent,
    MenuComponent,
    LoginComponent,
    RegistrationComponent,
    WaiterComponent,
    WaiterOdrerComponent,
    AdminHeaderComponent,
    WaiterHeaderComponent,
    HeaderComponent,
    FooterComponent,
    AdminOrderEditComponent,
    AdminRoleComponent,
    AdminStatusComponent,
    TokenConfermeComponent,
    AdminTableComponent,
    WishComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    StorageServiceModule,
    FormsModule,
    ChartsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [WelcomeService, WaiterService, TableStorageService,StaticticService, OrderStorageService, AdminCategoryService, AdminDishService, AdminOrderService, AdminUserService, OrderStorageService, MenuService, StatusService, AuthGuardService, AuthService , OrderService, HttpClient, AppService, {provide: "API_URL", useValue: environment.apiUrl}, {provide: "SOCKET_URL", useValue: environment.socketUrl},{provide: "LOGIN_URL", useValue: environment.loginUrl}],
  bootstrap: [AppComponent],
  entryComponents: [WishComponent]
})
export class AppModule { }

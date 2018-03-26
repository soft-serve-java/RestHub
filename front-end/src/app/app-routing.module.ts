import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';

import {CookComponent} from "./cook/cook.component";
import {WaiterTablesComponent} from "./waiter/waiter-tables/waiter-tables.component";
import {WaiterOdrerComponent} from "./waiter/waiter-odrer/waiter-odrer.component";
import {LoginComponent} from "./login/login.component";
import {
  AuthGuardService as AuthGuard
} from './services/auth-guard.service';
import {RegisterComponent} from "angular-stormpath";
import {RegistrationComponent} from "./registration/registration.component";
import {USER_ROUTES} from "./layout/user/user.routes";
import {UserComponent} from "./layout/user/user.component";
import {WaiterComponent} from "./layout/waiter/waiter.component";
import {WAITER_ROUTES} from "./layout/waiter/waiter.routes";
import {ADMIN_ROUTES} from "./layout/admin/admin.routes";
import {AdminComponent} from "./layout/admin/admin.component";

const routes: Routes = [
  {path: '', component: UserComponent, data: {title: 'Welcome to RestHub!'}, children: USER_ROUTES},
  {path: '', component: WaiterComponent, data: {title: 'Hi, Waiter | RestHub'}, children: WAITER_ROUTES},
  {path: '', component: AdminComponent, data: {title: 'Hi, Admin | RestHub'}, children: ADMIN_ROUTES},
  {path: 'cook', component: CookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

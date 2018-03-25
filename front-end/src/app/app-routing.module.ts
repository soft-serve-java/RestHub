import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {WaiterTablesComponent} from "./waiter/waiter-tables/waiter-tables.component";
import {WaiterOdrerComponent} from "./waiter/waiter-odrer/waiter-odrer.component";
import {LoginComponent} from "./login/login.component";
import {
  AuthGuardService as AuthGuard
} from './services/auth-guard.service';
import {RegisterComponent} from "angular-stormpath";
import {RegistrationComponent} from "./registration/registration.component";

const routes: Routes = [
  {path: '', component: WelcomeComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'waiter/tables', component: WaiterTablesComponent, canActivate: [AuthGuard] },
  {path: 'waiter/order/:id', component: WaiterOdrerComponent},
  {path:'login', component:LoginComponent},
  {path:'registration', component:RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

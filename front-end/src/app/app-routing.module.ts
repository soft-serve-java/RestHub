import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {WaiterTablesComponent} from "./waiter/waiter-tables/waiter-tables.component";
import {WaiterOdrerComponent} from "./waiter/waiter-odrer/waiter-odrer.component";
import {LoginComponent} from "./login/login.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'waiter/tables', component: WaiterTablesComponent},
  {path: 'waiter/order/:id', component: WaiterOdrerComponent},
  {path:'login', component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

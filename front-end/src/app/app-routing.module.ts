import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {CookComponent} from "./cook/cook.component";
import {WaiterTablesComponent} from "./waiter/waiter-tables/waiter-tables.component";
import {WaiterOdrerComponent} from "./waiter/waiter-odrer/waiter-odrer.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'cook', component: CookComponent}
  {path: 'welcome', component: WelcomeComponent},
  {path: 'waiter/tables', component: WaiterTablesComponent},
  {path: 'waiter/order/:id', component: WaiterOdrerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

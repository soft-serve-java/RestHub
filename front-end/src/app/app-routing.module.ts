import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { MenuComponent } from './menu/menu.component';
import {DishPageComponent} from "./dish-page/dish-page.component";
import {OrderComponent} from "./order/order.component";

import {CookComponent} from "./cook/cook.component";
import {WaiterTablesComponent} from "./waiter/waiter-tables/waiter-tables.component";
import {WaiterOdrerComponent} from "./waiter/waiter-odrer/waiter-odrer.component";

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'menu/:category/:page', component: MenuComponent},
  {path: 'menu/:category', component: MenuComponent},
  {path: 'dish/:id', component: DishPageComponent},
  {path: 'order', component: OrderComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'cook', component: CookComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'waiter/tables', component: WaiterTablesComponent},
  {path: 'waiter/order/:id', component: WaiterOdrerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

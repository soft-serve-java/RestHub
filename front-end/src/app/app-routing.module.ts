import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { MenuComponent } from './menu/menu.component';
import {DishPageComponent} from "./dish-page/dish-page.component";
import {OrderComponent} from "./order/order.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'menu/:category/:page', component: MenuComponent},
  {path: 'menu/:category', component: MenuComponent},
  {path: 'dish/:id', component: DishPageComponent},
  {path: 'order', component: OrderComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

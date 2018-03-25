import {Routes} from "@angular/router";
import {DishPageComponent} from "../../dish-page/dish-page.component";
import {MenuComponent} from "../../menu/menu.component";
import {OrderComponent} from "../../order/order.component";
import {WelcomeComponent} from "../../welcome/welcome.component";


export const USER_ROUTES: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'menu/:category/:page', component: MenuComponent},
  {path: 'menu/:category', component: MenuComponent},
  {path: 'dish/:id', component: DishPageComponent},
  {path: 'order', component: OrderComponent},
];

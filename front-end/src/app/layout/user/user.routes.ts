import {Routes} from "@angular/router";
import {DishPageComponent} from "../../dish-page/dish-page.component";
import {MenuComponent} from "../../menu/menu.component";
import {OrderComponent} from "../../order/order.component";
import {WelcomeComponent} from "../../welcome/welcome.component";
import {LoginComponent} from "../../login/login.component";
import {RegistrationComponent} from "../../registration/registration.component";
import {CookComponent} from "../../cook/cook.component";
//import {TokenConfermeComponent} from "../../token-conferme/token-conferme.component";


export const USER_ROUTES: Routes = [
  {path: '', component: WelcomeComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'menu/:category/:page', component: MenuComponent},
  {path: 'menu/:category', component: MenuComponent},
  {path: 'dish/:id', component: DishPageComponent},
  {path: 'order', component: OrderComponent},
  {path:'login', component:LoginComponent},
  {path:'registration', component:RegistrationComponent},
  //{path:'confirm/:token', component: TokenConfermeComponent},

  // for the cook
  {path: 'cook', component: CookComponent},
  {path: 'cook/:id', component: CookComponent}
];

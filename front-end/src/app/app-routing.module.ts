import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {USER_ROUTES} from "./layout/user/user.routes";
import {UserComponent} from "./layout/user/user.component";
import {WaiterComponent} from "./layout/waiter/waiter.component";
import {WAITER_ROUTES} from "./layout/waiter/waiter.routes";
import {ADMIN_ROUTES} from "./layout/admin/admin.routes";
import {AdminComponent} from "./layout/admin/admin.component";
//import {TokenConfermeComponent} from "./token-conferme/token-conferme.component";

const routes: Routes = [
  {path: '', component: UserComponent, data: {title: 'Welcome to RestHub!'}, children: USER_ROUTES},
  {path: '', component: WaiterComponent, data: {title: 'Hi, Waiter | RestHub'}, children: WAITER_ROUTES},
  {path: 'admin', component: AdminComponent, data: {title: 'Hi, Admin | RestHub'}, children: ADMIN_ROUTES},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

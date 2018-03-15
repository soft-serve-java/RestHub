import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {AdminComponent} from "./admin/admin.component";
import {AdminUserComponent} from "./admin-user/admin-user.component";
import {WaiterTablesComponent} from "./waiter-tables/waiter-tables.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'admin/user/all', component: AdminUserComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'waiter', component: WaiterTablesComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

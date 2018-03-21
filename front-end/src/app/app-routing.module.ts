import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {AdminComponent} from "./admin/admin.component";
import {AdminUserComponent} from "./admin-user/admin-user.component";
import {WaiterTablesComponent} from "./waiter-tables/waiter-tables.component";
import {AdminDishComponent} from "./admin-dish/admin-dish.component";
import {AdminCategoryComponent} from "./admin-category/admin-category.component";
import {AdminCategoryAddComponent} from "./admin-category-add/admin-category-add.component";
import {AdminOrderComponent} from "./admin-order/admin-order.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'admin/user/all', component: AdminUserComponent},
  {path: 'waiter', component: WaiterTablesComponent},
  {path: 'admin/dish/all', component: AdminDishComponent},
  {path: 'admin/category/all', component: AdminCategoryComponent},
  {path: 'admin/category/add', component: AdminCategoryAddComponent},
  {path: 'admin/category/edit/:id', component: AdminCategoryAddComponent},
  {path: 'waiter', component: WaiterTablesComponent},
  {path: 'admin/order', component: AdminOrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {AdminComponent} from "./Administrator/admin/admin.component";
import {AdminUserComponent} from "./Administrator/admin-user/admin-user.component";
import {WaiterTablesComponent} from "./waiter-tables/waiter-tables.component";
import {AdminDishComponent} from "./Administrator/admin-dish/admin-dish.component";
import {AdminCategoryComponent} from "./Administrator/admin-category/admin-category.component";
import {AdminCategoryAddComponent} from "./Administrator/admin-category-add/admin-category-add.component";
import {AdminDishAddComponent} from "./Administrator/admin-dish-add/admin-dish-add.component";
import {AdminUserEditComponent} from "./Administrator/admin-user-edit/admin-user-edit.component";
import {AdminCategoryEditComponent} from "./Administrator/admin-category-edit/admin-category-edit.component";
import {AdminDishEditComponent} from "./Administrator/admin-dish-edit/admin-dish-edit.component";

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'waiter', component: WaiterTablesComponent},
  {path: 'admin/user/all', component: AdminUserComponent},
  {path: 'admin/user/edit/:id', component: AdminUserEditComponent},
  {path: 'admin/dish/all', component: AdminDishComponent},
  {path: 'admin/dish/add', component: AdminDishAddComponent},
  {path: 'admin/dish/edit/:id', component: AdminDishEditComponent},
  {path: 'admin/category/all', component: AdminCategoryComponent},
  {path: 'admin/category/add', component: AdminCategoryAddComponent},
  {path: 'admin/category/edit/:id', component: AdminCategoryEditComponent},
  {path: 'waiter', component: WaiterTablesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

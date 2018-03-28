import {AdminCategoryComponent} from "../../admin-category/admin-category.component";
import {AdminDishComponent} from "../../admin-dish/admin-dish.component";
import {AdminUserComponent} from "../../admin-user/admin-user.component";
import {AdminCategoryAddComponent} from "../../admin-category-add/admin-category-add.component";
import {AdminOrderComponent} from "../../admin-order/admin-order.component";
import {AdminUserEditComponent} from "../../admin-user-edit/admin-user-edit.component";
import {AdminDishAddComponent} from "../../admin-dish-add/admin-dish-add.component";
import {AdminDishEditComponent} from "../../admin-dish-edit/admin-dish-edit.component";
import {AdminCategoryEditComponent} from "../../admin-category-edit/admin-category-edit.component";

export const ADMIN_ROUTES = [
  {path: 'user/all', component: AdminUserComponent},
  {path: 'user/edit/:id', component: AdminUserEditComponent},
  {path: 'dish/all', component: AdminDishComponent},
  {path: 'dish/add', component: AdminDishAddComponent},
  {path: 'dish/edit/:id', component: AdminDishEditComponent},
  {path: 'category/all', component: AdminCategoryComponent},
  {path: 'category/add', component: AdminCategoryAddComponent},
  {path: 'category/add', component: AdminCategoryAddComponent},
  {path: 'category/edit/:id', component: AdminCategoryEditComponent},
  {path: 'order/all', component: AdminOrderComponent}
];

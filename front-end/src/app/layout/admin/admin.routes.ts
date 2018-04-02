import {AdminUserComponent} from "../../admin/admin-user/admin-user.component";
import {AdminUserEditComponent} from "../../admin/admin-user-edit/admin-user-edit.component";
import {AdminDishComponent} from "../../admin/admin-dish/admin-dish.component";
import {AdminDishAddComponent} from "../../admin/admin-dish-add/admin-dish-add.component";
import {AdminDishEditComponent} from "../../admin/admin-dish-edit/admin-dish-edit.component";
import {AdminCategoryComponent} from "../../admin/admin-category/admin-category.component";
import {AdminCategoryAddComponent} from "../../admin/admin-category-add/admin-category-add.component";
import {AdminCategoryEditComponent} from "../../admin/admin-category-edit/admin-category-edit.component";
import {AdminOrderComponent} from "../../admin/admin-order/admin-order.component";
import {AdminRoleComponent} from "../../admin/admin-role/admin-role.component";
import {AdminOrderEditComponent} from "../../admin/admin-order-edit/admin-order-edit.component";
import {AdminStatusComponent} from "../../admin/admin-status/admin-status.component";
import {AdminTableComponent} from "../../admin/admin-table/admin-table.component";

export const ADMIN_ROUTES = [
  {path: 'user/all', component: AdminUserComponent},
  {path: 'user/edit/:id', component: AdminUserEditComponent},
  {path: 'dish/all', component: AdminDishComponent},
  {path: 'dish/add', component: AdminDishAddComponent},
  {path: 'dish/edit/:id', component: AdminDishEditComponent},
  {path: 'category/all', component: AdminCategoryComponent},
  {path: 'category/add', component: AdminCategoryAddComponent},
  {path: 'category/edit/:id', component: AdminCategoryEditComponent},
  {path: 'order/all', component: AdminOrderComponent},
  {path: 'category/edit/:id', component: AdminCategoryAddComponent},
  {path: 'order/all', component: AdminOrderComponent},
  {path: 'order/edit/:id', component: AdminOrderEditComponent},
  {path: 'role/all', component: AdminRoleComponent},
  {path: 'status/all', component: AdminStatusComponent},
  {path: 'table', component: AdminTableComponent}
];

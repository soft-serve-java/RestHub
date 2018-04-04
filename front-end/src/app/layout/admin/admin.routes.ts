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
import {AuthGuardService as AuthGuard} from "../../services/auth-guard.service";

export const ADMIN_ROUTES = [
  {path: 'user/all', component: AdminUserComponent, canActivate: [AuthGuard]},
  {path: 'user/edit/:id', component: AdminUserEditComponent, canActivate: [AuthGuard]},
  {path: 'dish/all', component: AdminDishComponent, canActivate: [AuthGuard]},
  {path: 'dish/add', component: AdminDishAddComponent, canActivate: [AuthGuard]},
  {path: 'dish/edit/:id', component: AdminDishEditComponent, canActivate: [AuthGuard]},
  {path: 'category/all', component: AdminCategoryComponent, canActivate: [AuthGuard]},
  {path: 'category/add', component: AdminCategoryAddComponent, canActivate: [AuthGuard]},
  {path: 'category/edit/:id', component: AdminCategoryEditComponent, canActivate: [AuthGuard]},
  {path: 'order/all', component: AdminOrderComponent, canActivate: [AuthGuard]},
  {path: 'category/edit/:id', component: AdminCategoryAddComponent, canActivate: [AuthGuard]},
  {path: 'order/all', component: AdminOrderComponent, canActivate: [AuthGuard]},
  {path: 'order/edit/:id', component: AdminOrderEditComponent, canActivate: [AuthGuard]},
  {path: 'role/all', component: AdminRoleComponent, canActivate: [AuthGuard]},
  {path: 'status/all', component: AdminStatusComponent, canActivate: [AuthGuard]},
  {path: 'table', component: AdminTableComponent, canActivate: [AuthGuard]}
];

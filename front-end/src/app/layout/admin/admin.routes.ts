import {AdminCategoryComponent} from "../../admin-category/admin-category.component";
import {AdminDishComponent} from "../../admin-dish/admin-dish.component";
import {AdminUserComponent} from "../../admin-user/admin-user.component";
import {AdminCategoryAddComponent} from "../../admin-category-add/admin-category-add.component";
import {AdminOrderComponent} from "../../admin-order/admin-order.component";
import {AdminOrderEditComponent} from "../../admin-order-edit/admin-order-edit.component";
import {AdminRoleComponent} from "../../admin-role/admin-role.component";
import {AdminStatusComponent} from "../../admin-status/admin-status.component";

export const ADMIN_ROUTES = [
  {path: 'user/all', component: AdminUserComponent},
  {path: 'dish/all', component: AdminDishComponent},
  {path: 'category/all', component: AdminCategoryComponent},
  {path: 'category/add', component: AdminCategoryAddComponent},
  {path: 'category/edit/:id', component: AdminCategoryAddComponent},
  {path: 'order/all', component: AdminOrderComponent},
  {path: 'order/edit/:id', component: AdminOrderEditComponent},
  {path: 'role/all', component: AdminRoleComponent},
  {path: 'status/all', component: AdminStatusComponent}
];

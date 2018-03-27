import {WaiterOdrerComponent} from "../../waiter/waiter-odrer/waiter-odrer.component";
import {WaiterTablesComponent} from "../../waiter/waiter-tables/waiter-tables.component";
import {AuthGuardService as AuthGuard} from "../../services/auth-guard.service";

export const WAITER_ROUTES = [
  {path: 'waiter/tables', component: WaiterTablesComponent, canActivate: [AuthGuard]},
  {path: 'waiter/order/:id', component: WaiterOdrerComponent, canActivate: [AuthGuard]}
];

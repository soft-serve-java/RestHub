import {WaiterOdrerComponent} from "../../waiter/waiter-odrer/waiter-odrer.component";
import {WaiterTablesComponent} from "../../waiter/waiter-tables/waiter-tables.component";

export const WAITER_ROUTES = [
  {path: 'waiter/tables', component: WaiterTablesComponent},
  {path: 'waiter/order/:id', component: WaiterOdrerComponent}
];

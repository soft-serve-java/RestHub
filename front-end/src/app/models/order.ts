import {Data} from "@angular/router";
import {User} from "./user";
import {OrderedDish} from "./orderedDish";
import {Timestamp} from "rxjs/Rx";

export class Order {
  id: number;
  time:Data;
  user: User;
  tablenumber: number;
  closed: boolean;
  orrderedFood: Array<OrderedDish>;
  waiter: User;
}

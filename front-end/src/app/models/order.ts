import {Data} from "@angular/router";
import {User} from "./user";
import {OrderedDish} from "./orderedDish";

export class Order {
   id: number;
   time: Data;
   user: User;
   tablenumber: number;
   closed: boolean;
   orrderedFood: OrderedDish;
   waiter: object;
}

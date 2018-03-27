import {User} from "./user";
import {OrderedDish} from "./orderedDish";

export class Order {
  id: number;
  time:Date;
  user: User;
  tablenumber: number;
  closed: boolean;
  orderedFood: Array<OrderedDish>;
  waiter: User;
}

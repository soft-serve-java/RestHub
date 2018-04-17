import {User} from "./user";
import {OrderedDish} from "./orderedDish";

export class Order {
  id: number;
  time: Date;
  user: User;
  tablenumber: number;
  closed: boolean;
  orderedFood: Array<OrderedDish>;
  waiter: User;
  wish: string;

  public toString(): String {
    return "Order: id:" + this.id + ", time: " + this.time + ", user: " + this.user + ", closed: " +
    this.closed + ", orderedFood: " + this.orderedFood + ", waiter: " + this.waiter +
    ", wish: " + this.wish;
  }
}

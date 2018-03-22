import {User} from "./user";
import {OrderedDish} from "./orderedDish";

export class Order {
   id: number;
  private time: Date;
  private user: User;
  private tablenumber: number;
  private closed: boolean;
  private orrderedFood: OrderedDish;
  private waiter: object;
}

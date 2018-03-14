import {Data} from "@angular/router";
import {User} from "./user";
import {OrderedDish} from "./orderedDish";

export class Order {
  private id: number;
  private time: Data;
  private user: User;
  private tablenumber: number;
  private closed: boolean;
  private orrderedFood: OrderedDish;
  private waiter: object;
}

import {Dish} from "./dish";
import {Status} from "./status";

export class OrderedDish {

  constructor(dish: Dish, status: Status, quantity: number) {
    this.dish = dish;
    this.status = status;
    this.quantity = quantity;
  }

  id: number;
  dish: Dish;
  status: Status;
  quantity: number;
}

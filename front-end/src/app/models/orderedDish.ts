import {Dish} from "./dish";
import {Status} from "./status";
import {Order} from "./order";

export class OrderedDish {

  constructor(dish: Dish, status: Status, quantity: number) {
    this.dish = dish;
    this.status = status;
    this.quantity = quantity;
  }

  id: number;
  dish: Dish

  status: Status;
  quantity: number;
  order: Order;

  public setOrder(order: Order){
    this.order = order;
  }

  public toString(): String{
    return "OrderedDish: id" + this.id + ", dish: " + this.dish.toString() + ", status: " + this.status
    + ", quantity: " + this.quantity + ", order: " + this.order;
  }
}

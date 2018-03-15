import {Dish} from "./dish";
import {Status} from "./status";

export class OrderedDish {
  private id: number;
  private dish: Dish
  private status: Status
  private quantity: number;
}

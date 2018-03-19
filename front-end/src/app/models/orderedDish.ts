import {Dish} from "./dish";
import {Status} from "./status";

export class OrderedDish {
  id: number;
  dish: Dish;
  status: Status;
  quantity: number;
}

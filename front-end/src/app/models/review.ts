import {Data} from "@angular/router";
import {User} from "./user";
import {OrderedDish} from "./orderedDish";
import {Dish} from "./dish";

export class Review {
  private id: number;
  private commentText: String;
  private date: Data;
  private approved: boolean;
  private dish: Dish;
  private user: User;
}

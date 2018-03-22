import {Data} from "@angular/router";
import {User} from "./user";
import {OrderedDish} from "./orderedDish";
import {Dish} from "./dish";

export class Review {
   id: number;
   commentText: String;
   date: Data;
   approved: boolean;
   dish: Dish;
   user: User;
}

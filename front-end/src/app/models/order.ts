import {Data} from "@angular/router";
import {User} from "./user";
import {OrderedDish} from "./orderedDish";
import DateTimeFormat = Intl.DateTimeFormat;
import {DatePipe} from "@angular/common";
import {DateFormatter} from "@angular/common/src/pipes/deprecated/intl";
import {Timestamp} from "rxjs/Rx";

export class Order {
  private id: number;
  private time: Date;
  private user: User;
  private tablenumber: number;
  private closed: boolean;
  private orrderedFood: OrderedDish;
  private waiter: object;
}

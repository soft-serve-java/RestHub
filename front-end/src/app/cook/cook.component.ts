import {Component, OnInit} from "@angular/core";
import {OrderedDish} from "../models/orderedDish";
import {CookService} from "../services/cook.service";

@Component({
  selector: 'app-cook',
  templateUrl: './cook.component.html',
  providers: [CookService],
  styleUrls: ['./cook.component.css']
})
export class CookComponent implements OnInit {
  orderedDishes: Array<OrderedDish>;

  constructor(private cookService: CookService) {
  }

  showOrderedDishes(): void {
    this.cookService.getOrderedDishes().subscribe(orderedDishes => this.orderedDishes = orderedDishes);
  }

  ngOnInit() {
    this.showOrderedDishes();
  }

}
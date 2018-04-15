import {OrderedDish} from "../models/orderedDish";
import {CookService} from "../services/cook.service";
import {Order} from "../models/order";
import {Component, OnInit} from "@angular/core";

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
    this.cookService.getOrderedDishes().subscribe(orderedDishes => {this.orderedDishes = orderedDishes;
      for(let i = 0; i < this.orderedDishes.length; i++){
        this.cookService.getOrderByOrderedDishId(this.orderedDishes[i].id).then(o => {this.orderedDishes[i].order = o});
      }});
  }

  getOrderByOrderedDishId(id: number): Order{
    let order: Order;
     this.cookService.getOrderByOrderedDishId(id).then(o => {order = o});
     return order;
  }

  ngOnInit() {
    this.showOrderedDishes();
  }

  update(orderedDish: OrderedDish) {
    this.cookService.updateOrderedDish(orderedDish.id).then(orderedDishes => {this.orderedDishes = orderedDishes;
      this.showOrderedDishes();});

  }

  done(orderedDish:OrderedDish){
    this.cookService.updateOrderedDish(orderedDish.id).then(orderedDishes => {this.orderedDishes = this.orderedDishes.filter(od => od != orderedDish);
    this.showOrderedDishes()});
  }

}

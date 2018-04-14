import {Component, OnInit} from "@angular/core";
import {OrderedDish} from "../models/orderedDish";
import {CookService} from "../services/cook.service";
import {Order} from "../models/order";

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

  showOrdersOrderedDishes(): void {
    this.cookService.getOrderedDishes().subscribe(orderedDishes => {this.orderedDishes = orderedDishes; console.log(this.orderedDishes.length);
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
    this.showOrdersOrderedDishes();
  }

  update(orderedDish: OrderedDish) {
    this.cookService.updateOrderedDish(orderedDish.id).then(orderedDishes => this.orderedDishes = orderedDishes);
  }

  done(orderedDish:OrderedDish){
    this.cookService.updateOrderedDish(orderedDish.id).then(orderedDishes => this.orderedDishes = this.orderedDishes.filter(od => od != orderedDish));
  }

}

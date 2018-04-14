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
  //orders: Array<Order>;
  //ordersOrederedDishesMap: Map<Order, OrderedDish>;

  constructor(private cookService: CookService) {
  }

 /* showOrdersOrderedDishes(): void {
    this.cookService.getOrderedDishes().subscribe(orderedDishes => this.ordersOrederedDishesMap = orderedDishes);
  }*/

  // create there method getOrderByOrederedDishId and just use it


  showOrdersOrderedDishes(): void {
    this.cookService.getOrderedDishes().subscribe(orderedDishes => this.orderedDishes = orderedDishes);
  }

  getOrderByOrderedDishId(id: number): Order{
    return
    //return Array.from(this.ordersOrederedDishesMap.keys());
  }

  ngOnInit() {
    this.showOrdersOrderedDishes();
  }

 /* getOrders(): Array<Order>{
    return Array.from(this.ordersOrederedDishesMap.keys());
  }

  getOrderedDishes(): Array<OrderedDish>{
    return Array.from(this.ordersOrederedDishesMap.values());
  }
  */
  update(orderedDish: OrderedDish) {
    this.cookService.updateOrderedDish(orderedDish.id).then(orderedDishes => this.orderedDishes = orderedDishes);
  }

  done(orderedDish:OrderedDish){
    this.cookService.updateOrderedDish(orderedDish.id).then(orderedDishes => this.orderedDishes = this.orderedDishes.filter(od => od != orderedDish));
  }

}

import {Component, Inject, OnInit} from '@angular/core';
import {Dish} from "../models/dish";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {OrderedDish} from "../models/orderedDish";
import {StatusService} from "../services/status.service";
import {OrderService} from "../services/order.service";
import {Order} from "../models/order";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  private dishes: Dish[];

  private newOrderedDishes = [];

  private orderMap: any;

  private newOrder: Order;

  private orderedDishes = [];

  private tableNumber = 1;

  constructor(@Inject(SESSION_STORAGE) private storage: WebStorageService,
              private statusService: StatusService,
              private orderService: OrderService) {
    this.statusService.saveStatusesToLocalStorage();
    this.getDishes();
    this.checkOrderByTableNumber();
  }

  ngOnInit() {
  }

  getDishes(){
    this.dishes = this.storage.get("orderDishes");
    this.orderMap = this.storage.get("orderMap");
    this.dishesToOrderedDishes();
  }

  dishesToOrderedDishes(){
    let temp = this.orderMap;
    let array = [];
    let statusPreparing = this.statusService.getPreparingStatus();
    this.dishes.forEach(function(dish){
      let orderedDish;
      orderedDish = new OrderedDish(dish, statusPreparing, temp.find(e => e.key == dish.id).value);
      array.push(orderedDish);
    });
    this.newOrderedDishes = array;
  }

  submitOrder(){
    this.orderService.createOrder(this.newOrderedDishes).then(res =>{
      this.newOrder = res;
      this.getOrderedDishFromOrder();
    } );
  }

  //Fix the method. Check if null and then add to storage.
  getOrderedDishFromOrder(){
    if (this.newOrder != null){
      this.storage.set("orderedDish", this.newOrder.orderedFood);
      this.orderedDishes = this.newOrder.orderedFood;
    }
  }

  checkOrderByTableNumber(){
    this.orderService.getOrderDetails(this.tableNumber).then(res => {
      this.newOrder = res;
      this.storage.set("orderedDish", this.newOrder.orderedFood);
      this.orderedDishes = this.newOrder.orderedFood;
    });
  }

}

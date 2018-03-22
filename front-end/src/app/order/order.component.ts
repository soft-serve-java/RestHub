import {Component, Inject, OnInit} from '@angular/core';
import {Dish} from "../models/dish";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {OrderedDish} from "../models/orderedDish";
import {Status} from "../models/status";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  private dishes: Dish[];

  private orderedDishes = [];

  private orderMap: any;

  constructor(@Inject(SESSION_STORAGE) private storage: WebStorageService) {
    this.getDishes();
  }

  ngOnInit() {
  }

  getDishes(){
    this.dishes = this.storage.get("orderDishes");
    this.orderMap = this.storage.get("orderMap");
    console.log(this.dishes);
    console.log(this.orderMap);
    this.dishesToOrderedDishes();
  }

  dishesToOrderedDishes(){
    let temp = this.orderMap;
    let array = [];
    this.dishes.forEach(function(dish){
      let orderedDish;
      orderedDish = new OrderedDish(dish, new Status(), temp.find(e => e.key == dish.id).value);
      array.push(orderedDish);
    });
    this.orderedDishes = array;
  }



}

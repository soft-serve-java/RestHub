import {Component, Inject, OnInit} from '@angular/core';
import {OrderedDish} from "../models/orderedDish";
import {StatusService} from "../services/status.service";
import {OrderService} from "../services/order.service";
import {Order} from "../models/order";
import {Status} from "../models/status";
import {OrderStorageService} from "../services/order-storage.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  private dishes = [];

  private newOrderedDishes = [];

  private orderMap: any;

  private newOrder: Order;

  private orderedDishes = [];


  constructor(private route: ActivatedRoute,
              private statusService: StatusService,
              private orderService: OrderService,
              private orderStorageService: OrderStorageService) {
    this.statusService.saveStatusesToLocalStorage();
    this.getDishes();
    this.checkOrderByTableNumber();
    console.log(this.dishes);
  }

  ngOnInit() {
  }

  getDishes(){
    this.dishes = this.orderStorageService.orderDishes;
    this.orderMap = this.orderStorageService.orderMap;
    this.dishesToOrderedDishes();
  }

  dishesToOrderedDishes(){
    let temp = this.orderMap;
    let array = [];
    let preparingStatus = this.statusService.getPreparingStatus();
    if(this.dishes == null) return;
    this.dishes.forEach(function(dish){
      let orderedDish;
      orderedDish = new OrderedDish(dish, preparingStatus, temp.find(e => e.key == dish.id).value);
      array.push(orderedDish);
    });
    this.newOrderedDishes = array;
  }

  submitOrder(){
    this.orderService.createOrder(this.newOrderedDishes).then(res =>{
      this.newOrder = res;
      this.getOrderedDishFromOrder();
      this.cleanUpAfterSubmission();
      this.orderedDishes = res.orderedFood;
    } );
  }

  submitOne(orderedDish: OrderedDish){
    this.orderService.submitOne(orderedDish).then(res=>{
      this.newOrder = res;
      this.remove(orderedDish);
      this.orderedDishes = res.orderedFood;
    })
  }

  getOrderedDishFromOrder(){
    if (this.newOrder != null){
      this.orderStorageService.orderDishes = this.newOrder.orderedFood;
      this.orderedDishes = this.newOrder.orderedFood;
    }
  }

  checkOrderByTableNumber(){
    this.orderService.getOrderDetailsByTable().then(res => {
      this.newOrder = res;
      this.orderedDishes = this.newOrder.orderedFood;
    });
  }

  remove(orderItem: OrderedDish){
    this.newOrderedDishes.splice(this.newOrderedDishes.indexOf(orderItem), 1);

    let temp = this.orderStorageService.orderMap;

    temp.map(function(elem, index, array){
        if(elem.key == orderItem.dish.id){
          array.splice(index, 1);
        }
    });
    this.orderStorageService.orderMap = temp;

    temp = this.orderStorageService.orderDishes;
    console.log(this.orderStorageService.orderDishes);
    temp.map(function(elem, index, array){
      if(elem.id == orderItem.dish.id){
        array.splice(index, 1);
      }
    });
    this.orderStorageService.orderDishes = temp;

  }

  getTotalAmount(): number{
    let totalAmount = 0;
    this.newOrderedDishes.forEach(item => totalAmount += item.dish.price * item.quantity);
    this.orderedDishes.forEach(item => totalAmount += item.dish.price * item.quantity);
    return totalAmount;
  }

  incrementQuantity(orderedDish: OrderedDish){
    orderedDish.quantity++;
    let temp = this.orderStorageService.orderMap;
    temp.map(elem => {
      if (elem.key == orderedDish.dish.id){
        elem.value++;
      }
    });
    this.orderStorageService.orderMap = temp;
  }

  decrementQuantity(orderedDish: OrderedDish){
    orderedDish.quantity--;
    let temp = this.orderStorageService.orderMap;
    temp.map(elem => {
      if (elem.key == orderedDish.dish.id){
        elem.value--;
      }
    });
    this.orderStorageService.orderMap = temp;
  }

  getClassByStatus(status: Status):string{
    if(status.name == 'preparing') return 'table-info';
    if(status.name == 'cooking')   return 'table-warning';
    if(status.name == 'delivery')  return 'table-success';
    return '';
  }

  isDiabledByQuantity(orderItem: OrderedDish):boolean{
    return orderItem.quantity <= 1;
  }

  isDisabledByNewOrderedDishes():boolean{
    return this.newOrderedDishes.length < 1;
  }

  private cleanUpAfterSubmission(){
    this.orderStorageService.removeStorage();
    this.dishes = [];
    this.orderMap = [];
    this.newOrderedDishes = [];
  }

}

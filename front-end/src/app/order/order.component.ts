import {Component, OnInit} from '@angular/core';
import {OrderedDish} from "../models/orderedDish";
import {StatusService} from "../services/status.service";
import {OrderService} from "../services/order.service";
import {Order} from "../models/order";
import {Status} from "../models/status";
import {OrderStorageService} from "../services/order-storage.service";
import {ActivatedRoute} from "@angular/router";
import {MatDialog} from '@angular/material';
import {WishComponent} from "../wish/wish.component";

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
              private orderStorageService: OrderStorageService,
              public dialog: MatDialog,
              /* @Inject(MAT_DIALOG_DATA) public data: any*/) {
    this.statusService.saveStatusesToLocalStorage();
    this.getDishes();
    this.checkOrderByTableNumber();
    console.log(this.dishes);
  }

  ngOnInit() {
  }

  getDishes() {
    this.dishes = this.orderStorageService.orderDishes;
    this.orderMap = this.orderStorageService.orderMap;
    this.dishesToOrderedDishes();
  }

  dishesToOrderedDishes() {
    let temp = this.orderMap;
    let array = [];
    let preparingStatus = this.statusService.getPreparingStatus();
    if (this.dishes == null) return;
    this.dishes.forEach(function (dish) {
      let orderedDish;
      orderedDish = new OrderedDish(dish, preparingStatus, temp.find(e => e.key == dish.id).value);
      array.push(orderedDish);
    });
    this.newOrderedDishes = array;
  }

  submitOrder() {
    this.orderService.createOrder(this.newOrderedDishes).then(res => {
      this.newOrder = res;
      this.getOrderedDishFromOrder();
      this.cleanUpAfterSubmission();
      this.orderedDishes = res.orderedFood;

      console.log("this.newOrder = " + this.newOrder.toString());

      // try to set order to every ordered dish
      /*  let i: number;

        console.log('order wish= ' + this.newOrder.wish);

        for (i = 0; i < this.orderedDishes.length; i++) {

          console.log(this.orderedDishes[i]);

          this.orderedDishes[i].order = this.newOrder;

          console.log('set order:' + this.orderedDishes[i].order.toString());
        }
  */
      // console.log('all: ' + this.getOrderedDishFromOrder());
    });
  }

  // on submit send ordered food to wish component
  // on ok on wish component set all ordered food the same wish

  submitOne(orderedDish: OrderedDish) {
    this.orderService.submitOne(orderedDish).then(res => {
      this.newOrder = res;
      this.remove(orderedDish);
      this.orderedDishes = res.orderedFood;
    })
  }

  getOrderedDishFromOrder() {
    if (this.newOrder != null) {
      this.orderStorageService.orderDishes = this.newOrder.orderedFood;
      this.orderedDishes = this.newOrder.orderedFood;
    }
  }

  checkOrderByTableNumber() {
    this.orderService.getOrderDetailsByTable().then(res => {
      this.newOrder = res;
      this.orderedDishes = this.newOrder.orderedFood;
    });
  }

  remove(orderItem: OrderedDish) {
    this.newOrderedDishes.splice(this.newOrderedDishes.indexOf(orderItem), 1);

    let temp = this.orderStorageService.orderMap;

    temp.map(function (elem, index, array) {
      if (elem.key == orderItem.dish.id) {
        array.splice(index, 1);
      }
    });
    this.orderStorageService.orderMap = temp;

    temp = this.orderStorageService.orderDishes;
    console.log(this.orderStorageService.orderDishes);
    temp.map(function (elem, index, array) {
      if (elem.id == orderItem.dish.id) {
        array.splice(index, 1);
      }
    });
    this.orderStorageService.orderDishes = temp;

  }

  getTotalAmount(): number {
    let totalAmount = 0;
    this.newOrderedDishes.forEach(item => totalAmount += item.dish.price * item.quantity);
    this.orderedDishes.forEach(item => totalAmount += item.dish.price * item.quantity);
    return totalAmount;
  }

  incrementQuantity(orderedDish: OrderedDish) {
    orderedDish.quantity++;
    let temp = this.orderStorageService.orderMap;
    temp.map(elem => {
      if (elem.key == orderedDish.dish.id) {
        elem.value++;
      }
    });
    this.orderStorageService.orderMap = temp;
  }

  decrementQuantity(orderedDish: OrderedDish) {
    orderedDish.quantity--;
    let temp = this.orderStorageService.orderMap;
    temp.map(elem => {
      if (elem.key == orderedDish.dish.id) {
        elem.value--;
      }
    });
    this.orderStorageService.orderMap = temp;
  }

  getClassByStatus(status: Status): string {
    if (status.name == 'preparing') return 'table-info';
    if (status.name == 'cooking') return 'table-warning';
    if (status.name == 'delivery') return 'table-success';
    return '';
  }

  isDiabledByQuantity(orderItem: OrderedDish): boolean {
    return orderItem.quantity <= 1;
  }

  isDisabledByNewOrderedDishes(): boolean {
    return this.newOrderedDishes.length < 1;
  }

  private cleanUpAfterSubmission() {
    this.orderStorageService.removeStorage();
    this.dishes = [];
    this.orderMap = [];
    this.newOrderedDishes = [];
  }

  showWishPopup() {
    console.log('showWishPopup()');

    if(this.newOrder == null){
      let dialogRef = this.dialog.open(WishComponent);

      dialogRef.componentInstance.onOk.subscribe(result => {
        console.log('result = ' + result);

        this.orderService.addWishToOrder(this.newOrder.id, result).then(order => this.newOrder = order);
      });
    }

    else if(!this.orderService.getOrderWish(this.newOrder.id).then(a=> {
        if (a === null){
          let dialogRef = this.dialog.open(WishComponent);

          dialogRef.componentInstance.onOk.subscribe(result => {
            console.log('result = ' + result);

            this.orderService.addWishToOrder(this.newOrder.id, result).then(order => this.newOrder = order);
          });
        }
      })){

    }
  }
}

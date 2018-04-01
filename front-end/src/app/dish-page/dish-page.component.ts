import { Component, OnInit } from '@angular/core';
import {Dish} from "../models/dish";
import {ActivatedRoute} from "@angular/router";
import {MenuService} from "../services/menu.service";
import {OrderStorageService} from "../services/order-storage.service";

@Component({
  selector: 'app-dish-page',
  templateUrl: './dish-page.component.html'
})
export class DishPageComponent implements OnInit {

  private dish: Dish;
  private populars: Dish[];
  private quantityInOrder: number;

  constructor(private route: ActivatedRoute,
              private menuService: MenuService,
              private orderStorageService: OrderStorageService) {
    route.params.subscribe(params => {
      this.loadDishById(params['id']);
    });
  }

  ngOnInit() {
  }

  loadDishById(dishId: number) {
    this.menuService.getDishById(dishId).then(res => {this.dish = res; this.getQuantity();});
    this.menuService.getDishPopulars(dishId).then(res => this.populars = res);
  }

  addToOrder() {
    let temp = this.orderStorageService.orderMap;
    let dish = this.dish;
    if (!temp.some(elem => elem.key == dish.id)) {
      temp.push({key: dish.id, value: 0});
      let dishes = this.orderStorageService.orderDishes;
      dishes.push(dish);
      this.orderStorageService.orderDishes = dishes;
    }
    temp.find(function (val) {
      if (val.key == dish.id) {
        val.value += 1;
      }
    });

    this.orderStorageService.orderMap = temp;
    this.quantityInOrder++;
  }

  getQuantity() {
    let dish = this.dish;
    let quant = 0;
    this.orderStorageService.orderMap.find(function (val) {
      if (dish.id == val.key) {quant = val.value}
    });
    this.quantityInOrder = quant;
  }
}

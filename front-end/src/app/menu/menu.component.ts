import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import {MenuService} from '../services/menu.service';
import {Dish} from '../models/dish'
import {OrderStorageService} from "../services/order-storage.service";


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html'
})
export class MenuComponent implements OnInit {
  private category: string;
  private dishes: Dish[];
  private maxPage: number;
  private currPage: number;
  private numbers: number[];
  private asc: boolean;

  private data: any = [];

  constructor(private route: ActivatedRoute,
              private menuService: MenuService,
              private orderStorageService: OrderStorageService) {
    this.setSession();
    route.params.subscribe( params => {
                                            this.category = params['category'];
                                            this.currPage = Number(params['page']);

                                            if (params['tag']){
                                              this.getDishesByTag(params['tag'])
                                            } else{
                                              this.getDishes();
                                            }

                                            this.data = this.orderStorageService.orderMap;
                                          });
    }

  ngOnInit() {
  }

  getDishes() {
    if (!this.currPage) {
      this.currPage = 1;
    }
    this.menuService.getDishesByCategory(this.category, this.currPage).then(res => {
      this.dishes = res.body;

      this.maxPage = Number(res.headers.get('last'));
      this.numbers = Array(this.maxPage).fill(1).map((x,i)=>i+1);
    });
  }

  getDishesByTag(tagName: string) {
    if (!this.currPage) {
      this.currPage = 1;
    }
    this.menuService.getDishesByTagName(tagName, this.currPage).then(res=> {
      this.dishes = res.body;
      this.maxPage = Number(res.headers.get('last'));
      this.numbers = Array(this.maxPage).fill(1).map((x,i)=>i+1);
    });
  }

  addToOrder(dish: Dish){
    let temp = this.orderStorageService.orderMap;

    if (!temp.some(elem => elem.key == dish.id)){
      temp.push({key: dish.id, value:0});
      let dishes = this.orderStorageService.orderDishes;
      dishes.push(dish);
      this.orderStorageService.orderDishes = dishes;
    }
    temp.find(function(val){
        if (val.key == dish.id){
          val.value += 1;
        }
    });

    this.orderStorageService.orderMap = temp;
    this.data = temp;
  }

  checkIfDishInOrder(dish: Dish): boolean{
    return this.data.some(e => e.key === dish.id);
  }

  getDishQuantityInOrder(dish: Dish): Object{
    return this.data.find(function(val){
      if (val.key == dish.id) return val;
      });
  }

  searchByName(name: string){
    this.menuService.getDishByName(name).then(res => this.dishes = res);
  }

  private setSession(){
    if (this.orderStorageService.orderMap == null){
      this.orderStorageService.orderMap = [];
      this.orderStorageService.orderDishes = [];
    }
  }

  sortByKey(array, key, asc) {
    return array.sort(function (a, b) {
      var x = a[key];
      var y = b[key];
      if(asc){
        return ((x < y) ? 1 : ((x > y) ? -1 : 0));
      }
      else {
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
      }
    });
  }

  sortByPrice() {
    this.dishes = this.sortByKey(this.dishes, 'price', this.asc);
    this.asc = !this.asc;
  }

  sortByCalories(){
    this.dishes = this.sortByKey(this.dishes, 'calories', this.asc);
    this.asc = !this.asc;
  }

  sortByPreparingTime(){
    this.dishes = this.sortByKey(this.dishes, 'preparingtime', this.asc);
    this.asc = !this.asc;
  }

}

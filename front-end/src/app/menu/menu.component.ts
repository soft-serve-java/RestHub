import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Data} from "@angular/router";

import {MenuService} from '../services/menu.service';
import {Dish} from '../models/dish'
import {OrderStorageService} from "../services/order-storage.service";
import {Tag} from "../models/tag";


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
  private currentTime: number;
  breakfast:Tag = new Tag("breakfast");
  dateNow = new Date();

  private data:any = [];

  constructor(private route: ActivatedRoute,
              private menuService: MenuService,
              private orderStorageService: OrderStorageService) {
    this.setSession();
    route.params.subscribe( params => {
                                            this.category = params['category'];
                                            this.currPage = Number(params['page']);
                                            this.getDishes();
                                            this.data = this.orderStorageService.orderMap;
                                          });
    }

  ngOnInit() {
    this.getDishes();
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




  addToOrder(dish: Dish){
    console.log(dish.tags.indexOf(new Tag( 'breakfast')));
    //if(dish.tags.indexOf(new Tag( 'breakfast')) && new Date().getHours()<19){
    if(dish.tags.indexOf(new Tag( 'breakfast')) && this.dateNow.getHours() > 8 && this.dateNow.getHours() < 19 ) {
      console.log("return");
      return;
    }

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



}

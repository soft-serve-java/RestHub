import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import {MenuService} from '../services/menu.service';
import {Dish} from '../models/dish'
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  private category: string;
  private dishes: Dish[];
  private maxPage: number;
  private currPage: number;
  private numbers: number[];

  private data:any = [];

  constructor(@Inject(SESSION_STORAGE) private storage: WebStorageService,
              private route: ActivatedRoute, public menuService: MenuService) {
    this.setSession();
    route.params.subscribe( params => {
                                            this.category = params['category'];
                                            this.currPage = Number(params['page']);
                                            this.getDishes();
                                            this.data = this.storage.get("orderMap");
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
    let temp = this.storage.get("orderMap");

    if (!temp.some(elem => elem.key == dish.id)){
      temp.push({key: dish.id, value:0});
      let dishes = this.storage.get("orderDishes");
      dishes.push(dish);
      this.storage.set("orderDishes", dishes);
    }
    temp.find(function(val){
        if (val.key == dish.id){
          val.value += 1;
        }
    });

    this.storage.set("orderMap", temp);
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
    if (this.storage.get("orderMap") == null){
      this.storage.set("orderMap", []);
      this.storage.set("orderDishes", [])
    }
  }

}

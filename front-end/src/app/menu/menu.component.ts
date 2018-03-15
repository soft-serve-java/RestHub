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
    route.params.subscribe( params => {
                                            this.category = params['category'];
                                            this.currPage = Number(params['page']);
                                            console.log(Number(params['page']));
                                            this.getDishes()
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

  addToOrder(dishId: number){
    let temp = this.storage.get("orderMap");
    temp.push({dish: dishId, quantity: 1});
    this.storage.set("orderMap", temp);
    this.data = temp;
  }

}

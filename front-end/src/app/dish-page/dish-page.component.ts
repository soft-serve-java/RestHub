import { Component, OnInit } from '@angular/core';
import {Dish} from "../models/dish";
import {ActivatedRoute} from "@angular/router";
import {MenuService} from "../services/menu.service";

@Component({
  selector: 'app-dish-page',
  templateUrl: './dish-page.component.html',
  styleUrls: ['./dish-page.component.css']
})
export class DishPageComponent implements OnInit {

  private dish: Dish;
  private populars: Dish[];

  constructor(private route: ActivatedRoute, public menuService: MenuService) {
    route.params.subscribe( params => {
      this.loadDishById(params['id'])
    });
  }

  ngOnInit() {
  }

  loadDishById(dishId: number){
    this.menuService.getDishById(dishId).then(res => this.dish = res);
    this.menuService.getDishPopulars(dishId).then(res => this.populars = res);
  }

}

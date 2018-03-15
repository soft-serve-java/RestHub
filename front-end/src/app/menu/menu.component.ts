import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import {MenuService} from '../services/menu.service';
import {Dish} from '../models/dish'
import { HttpResponse } from '@angular/common/http';
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

  constructor(private route: ActivatedRoute, public menuService: MenuService) {
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

}

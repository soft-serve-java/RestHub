import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {AdminCategoryService} from "../services/admin-category.service";
import {Dish} from "../models/dish";
import {AdminDishService} from "../services/admin-dish.service";


@Component({
  selector: 'app-admin-dish-add',
  templateUrl: './admin-dish-add.component.html',
  styleUrls: ['./admin-dish-add.component.css']
})
export class AdminDishAddComponent implements OnInit {

  category: Category[];
  dish = new Dish();

  constructor(public adminCategoryService: AdminCategoryService,
              public adminDishService: AdminDishService) {this.getCategory()}

  ngOnInit() {
    this.getCategory();
  }

  getCategory() {
    this.adminCategoryService.getCategory().then(res => this.category = res)
  }

  addDish(){
    this.adminDishService
      .addDish(this.dish)
      .then();
  }

  editDish(){
    this.adminDishService
      .editDish(this.dish)
      .then();
  }
}

///<reference path="../services/admin-dish.service.ts"/>
import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {AdminCategoryService} from "../services/admin-category.service";
import {Dish} from "../models/dish";
import {AdminCategoryAddService} from "../services/admin-category-add.service";
import {AdminDishService} from "../services/admin-dish.service";
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-admin-dish-add',
  templateUrl: './admin-dish-add.component.html',
  styleUrls: ['./admin-dish-add.component.css']
})
export class AdminDishAddComponent implements OnInit {

  name: String;
  description: String;
  category: Category;
  weight: number;
  calories: number;
  preparingtime: number;
  price: number;

  adminDishService: AdminDishService;
  dish = new Dish();

  constructor(public adminCategoryService: AdminCategoryService) {this.getCategory()}

  ngOnInit() {
    this.getCategory();
  }

  getCategory() {
    this.adminCategoryService.getCategory().then(res => this.category = res)
  }


  // + this.category, не принимает т.к. он является массивом.
  addDish(){
    this.adminDishService
      .addDish(this.name, this.description, this.calories, this.category, this.weight,  this.preparingtime, this.price)
      this.name = '';
      this.description = '';
      this.weight = 0;
      this.calories = 0;
      this.preparingtime = 0;
      this.price = 0;
  }
}

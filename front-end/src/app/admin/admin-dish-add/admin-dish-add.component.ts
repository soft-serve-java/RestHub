import { Component, OnInit } from '@angular/core';
import {Category} from "../../models/category";
import {AdminCategoryService} from "../../services/admin-category.service";
import {Dish} from "../../models/dish";
import {AdminDishService} from "../../services/admin-dish.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-admin-dish-add',
  templateUrl: './admin-dish-add.component.html',
  styleUrls: ['./admin-dish-add.component.css']
})
export class AdminDishAddComponent implements OnInit {

  category: Category[];

  categ: string;

  id: number;
  name: string;
  description: string;
  weight: number;
  calories: number;
  preparingtime: number;
  price: number;
  categor: Category;

  dish = new Dish();

  constructor(public adminCategoryService: AdminCategoryService,
              public adminDishService: AdminDishService,
              public router: Router) {
    this.getCategory();
  }

  ngOnInit() {
    this.getCategory();
  }

  getCategory() {
    this.adminCategoryService.getCategory()
      .then(res => this.category = res)
  }

  addDish(){
    this.adminDishService
      .addDish(this.name, this.description, this.weight, this.categor, this. calories, this.preparingtime, this.price)
      .then(res => {this.router.navigate(['admin/dish/all'])});
  }
}

import { Component, OnInit } from '@angular/core';
import {Category} from "../../models/category";
import {AdminCategoryService} from "../../services/admin-category.service";
import {Dish} from "../../models/dish";
import {AdminDishService} from "../../services/admin-dish.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Tag} from "../../models/tag";


@Component({
  selector: 'app-admin-dish-add',
  templateUrl: './admin-dish-add.component.html',
  styleUrls: ['./admin-dish-add.component.css']
})
export class AdminDishAddComponent implements OnInit {

  category: Category[];

  id: number;
  name: string;
  description: string;
  weight: number;
  calories: number;
  preparingtime: number;
  price: number;
  categor: Category;
  tags = [];

  dish = new Dish();

  inputTag = "";
  categoryName = "";

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
    this.categor = this.category.find(cat => cat.name === this.categoryName);

    this.adminDishService
      .addDish(this.name, this.description, this.weight, this.categor, this. calories, this.preparingtime, this.price, this.tags)
      .then(res => {this.router.navigate(['admin/dish/all'])});
  }

  addTag(){
    if (!this.tags.some(t => t.title === this.inputTag)){
      let tag = new Tag(this.inputTag);
      this.tags.push(tag);
      this.inputTag = '';
    }
  }

  removeTag(text){
    this.tags.map(function(val, index, array){
      if (val.title === text){
        array.splice(index, 1);
      }
    });
  }
}

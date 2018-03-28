import { Component, OnInit } from '@angular/core';
import {AdminDishService} from "../services/admin-dish.service";
import {Dish} from "../models/dish";
import {AdminCategoryService} from "../services/admin-category.service";
import {Category} from "../models/category";

@Component({
  selector: 'app-admin-category',
  templateUrl: './admin-category.component.html',
  styleUrls: ['./admin-category.component.css']
})
export class AdminCategoryComponent implements OnInit {
  category: Category[];

  constructor(public adminCategoryService: AdminCategoryService){}

  ngOnInit(){
    this.adminCategoryService.getCategory().then(res => this.category = res)
  }

  deleteCategory(cat: Category){
    this.adminCategoryService.deleteCategory(cat.id).then(res=> this.category.splice(this.category.indexOf(cat), 1))
  }
}

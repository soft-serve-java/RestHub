import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {AdminCategoryService} from "../services/admin-category.service";

@Component({
  selector: 'app-admin-category-add',
  templateUrl: './admin-category-add.component.html',
  styleUrls: ['./admin-category-add.component.css']
})
export class AdminCategoryAddComponent implements OnInit {

  category: Category;
  categoryName: String;

  constructor(public adminCategoryService: AdminCategoryService){}

  ngOnInit(){
  }

  addCategory(){
    this.adminCategoryService
      .addCategory(this.categoryName),
      this.categoryName = '';
  }

    editCategory(){
    this.adminCategoryService
      .editCategory(this.category.id, this.category.name)
      .then()
  }
}

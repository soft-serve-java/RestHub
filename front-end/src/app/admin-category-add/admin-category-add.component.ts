import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {AdminCategoryAddService} from "../services/admin-category-add.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-admin-category-add',
  templateUrl: './admin-category-add.component.html',
  styleUrls: ['./admin-category-add.component.css']
})
export class AdminCategoryAddComponent implements OnInit {

  category: Category[];
  categoryName: String;

  constructor(public adminCategoryAddService: AdminCategoryAddService){}

  ngOnInit(){
    //this.adminCategoryAddService.getCategory().then(res => this.category = res)
  }

//  ngRouter получить id

  addCategory(){
    this.adminCategoryAddService
      .addCategory(this.categoryName),
      this.categoryName = '';
  }

  editCategory(){
    this.adminCategoryAddService
      .editCategory(this.category),
      this.category
  }
}

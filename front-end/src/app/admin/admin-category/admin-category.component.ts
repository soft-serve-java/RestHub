import { Component, OnInit } from '@angular/core';
import {Category} from "../../models/category";
import {AdminCategoryService} from "../../services/admin-category.service";

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

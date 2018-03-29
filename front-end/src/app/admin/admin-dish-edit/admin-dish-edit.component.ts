import { Component, OnInit } from '@angular/core';
import {AdminDishService} from "../../services/admin-dish.service";
import {AdminCategoryService} from "../../services/admin-category.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Category} from "../../models/category";
import {Dish} from "../../models/dish";

@Component({
  selector: 'app-admin-dish-edit',
  templateUrl: './admin-dish-edit.component.html',
  styleUrls: ['./admin-dish-edit.component.css']
})
export class AdminDishEditComponent implements OnInit {

  category: Category[];
  dish: Dish;

  constructor(  public route: ActivatedRoute,
                public adminCategoryService: AdminCategoryService,
                public adminDishService: AdminDishService,
                public router: Router) {
    this.getCategory();
  }

  ngOnInit() {
    this.getCategory();
    this.route.params.subscribe( params => {this.loadDishById(params['id'])
    });
  }

  getCategory() {
    this.adminCategoryService.getCategory()
      .then(res => this.category = res)
  }

  loadDishById(id: number){
    this.adminDishService.getDishById(id).then(res => this.dish = res);
  }

  editDish(){
    this.adminDishService
      .editDish(this.dish)
      .then(res => {this.router.navigate(['admin/dish/all'])});
  }
}

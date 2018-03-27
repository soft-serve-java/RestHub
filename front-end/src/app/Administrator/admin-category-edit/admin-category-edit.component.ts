import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AdminCategoryService} from "../../services/admin-category.service";
import {Category} from "../../models/category";

@Component({
  selector: 'app-admin-category-edit',
  templateUrl: './admin-category-edit.component.html',
  styleUrls: ['./admin-category-edit.component.css']
})
export class AdminCategoryEditComponent implements OnInit {

  category: Category;
  name: string;
  id: number;

  constructor(public route: ActivatedRoute,
              public adminCategoryService: AdminCategoryService,
              public router: Router){
  }

  ngOnInit() {
    this.route.params.subscribe( params => {
      this.loadCategoryById(params['id'])
    });
  }

  loadCategoryById(id: number){
    this.adminCategoryService.getCategoryById(id).then(res => this.category = res);
  }

  editCategory(){
    this.adminCategoryService
      .editCategory(this.category)
      .then(res => {this.router.navigate(['admin/category/all'])})
  }
}

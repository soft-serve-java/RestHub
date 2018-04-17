import { Component, OnInit } from '@angular/core';
import {Category} from "../../models/category";
import {AdminCategoryService} from "../../services/admin-category.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-category-add',
  templateUrl: './admin-category-add.component.html',
  styleUrls: ['./admin-category-add.component.css']
})
export class AdminCategoryAddComponent implements OnInit {

  name: string;

  constructor(public route: ActivatedRoute,
              public adminCategoryService: AdminCategoryService,
              public router: Router){
  }

  ngOnInit(){
  }

  addCategory(){
    this.adminCategoryService
      .addCategory(this.name)
      .then(res => {this.router.navigate(['admin/category/all'])});
  }
}

import { Component, OnInit } from '@angular/core';
import {AdminCategoryService} from "../services/admin-category.service";
import {Category} from "../models/category";
import {User} from "../models/user";
import {Role} from "../models/role";
import {AdminRoleService} from "../services/admin-role.service";
import {AdminUserService} from "../services/admin-user.service";

@Component({
  selector: 'app-admin-user-edit',
  templateUrl: './admin-user-edit.component.html',
  styleUrls: ['./admin-user-edit.component.css']
})
export class AdminUserEditComponent implements OnInit {

  adminUserService: AdminUserService;
  //adminRoleService: AdminRoleService;
  role: Role[];
  user= new User;
  category: Category;



  //необходимо чтобы этот конструктор работал для вывода ролей в выпадающем меню, но с конструктором страница вообще не загружается.
  constructor(public adminRoleService: AdminRoleService) {this.getRole()}


  ngOnInit() {
    this.getRole()
  }

  getRole() {
    this.adminRoleService.getRole().then(res => this.role = res)
  }

  editUser(){

  }
}

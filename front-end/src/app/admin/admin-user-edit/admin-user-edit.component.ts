import { Component, OnInit } from '@angular/core';
import {AdminCategoryService} from "../../services/admin-category.service";
import {Category} from "../../models/category";
import {User} from "../../models/user";
import {Role} from "../../models/role";
import {AdminRoleService} from "../../services/admin-role.service";
import {AdminUserService} from "../../services/admin-user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-user-edit',
  templateUrl: './admin-user-edit.component.html',
  styleUrls: ['./admin-user-edit.component.css']
})
export class AdminUserEditComponent implements OnInit {

  role: Role[];
  user: User;

  constructor(public route: ActivatedRoute,
              public adminUserService: AdminUserService,
              public adminRoleService: AdminRoleService,
              public router: Router) {
    this.getRole();
  }

  ngOnInit() {
    this.getRole();
    this.route.params.subscribe( params => {
      this.loadUserById(params['id'])
    });
  }

  loadUserById(id: number){
    this.adminUserService.getUserById(id).then(res => this.user = res);
  }

  getRole() {
    this.adminRoleService.getRole().then(res => this.role = res)
  }

  editUser(){
  this.adminUserService
    .editUser(this.user)
    .then(res => {this.router.navigate(['admin/user/all'])})
  }
}

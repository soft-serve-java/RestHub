import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {AdminUserService} from "../services/admin-user.service";

@Component({
  selector: 'wfm-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.scss']
})
export class AdminUserComponent implements OnInit {

  constructor(public adminUserServise: AdminUserService) {}


  ngOnInit() {
    this.adminUserServise.getUsers().then(res => this.user = res)
  }

  user: User[];




//user = [{id:1, email: 'df@d.as', name: 'admin'}, {id:2, email: 'df@d.as', name: 'user'}]

}

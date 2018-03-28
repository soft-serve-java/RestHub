import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import {AdminUserService} from "../../services/admin-user.service";
import { ActivatedRoute, Params } from '@angular/router';


@Component({
  selector: 'wfm-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.scss']
})
export class AdminUserComponent implements OnInit {
  user: User[];

  constructor(public adminUserServise: AdminUserService,
  //            private route: ActivatedRoute
  ) {}


  //id: string;

  ngOnInit() {
    this.adminUserServise.getUsers().then(res => this.user = res);
    //this.id = this.route.snapshot.params['id'];
  }

  deleteUser(user: User){
    this.adminUserServise.deleteUser(user.id).then(res => this.user.splice(this.user.indexOf(user), 1))
  }
}

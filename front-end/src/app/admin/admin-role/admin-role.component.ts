import { Component, OnInit } from '@angular/core';
import {AdminOrderService} from "../../services/admin-order.service";
import {Order} from "../../models/order";
import {Role} from "../../models/role";

@Component({
  selector: 'app-admin-role',
  templateUrl: './admin-role.component.html',
  styleUrls: ['./admin-role.component.css']
})
export class AdminRoleComponent implements OnInit {

  constructor(public adminOrderService: AdminOrderService) { }

  ngOnInit() {
    this.adminOrderService.getRoles().then(res => this.roles = res)
  }
  roles: Role[];
}

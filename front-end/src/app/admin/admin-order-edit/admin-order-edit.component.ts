import { Component, OnInit } from '@angular/core';
import {Order} from "../../models/order";
import {AdminOrderService} from "../../services/admin-order.service";

@Component({
  selector: 'app-admin-order-edit',
  templateUrl: './admin-order-edit.component.html',
  styleUrls: ['./admin-order-edit.component.css']
})
export class AdminOrderEditComponent implements OnInit {

  constructor(public adminOrderService: AdminOrderService) { }

  ngOnInit() {

  }

  getOrder(id: number){
    this.adminOrderService.getOrder(id).then(res => this.order = res)
  }

  save(order: Order){
    this.adminOrderService.save(order).then(res => this.order = res)
  }
order:Order;
}

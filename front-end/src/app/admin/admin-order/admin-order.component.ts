import { Component, OnInit } from '@angular/core';
import {AdminOrderService} from "../../services/admin-order.service"
import {Order} from "../../models/order";

@Component({
  selector: 'app-admin-order',
  templateUrl: './admin-order.component.html',
  styleUrls: ['./admin-order.component.css']
})
export class AdminOrderComponent implements OnInit {

  constructor(public adminOrderService: AdminOrderService) { }

  deleteOrder(ord: Order){
    this.adminOrderService.deleteOrder(ord.id).then(res=> this.order.splice(this.order.indexOf(ord), 1))
  }

  ngOnInit() {
    this.adminOrderService.getOrders().then(res => this.order = res)
  }

  editOrder(ord: Order){
    this.adminOrderService.getOrder(ord.id).then(res => this.ordr = res)
  }
  ordr: Order;
  order: Order[];
}

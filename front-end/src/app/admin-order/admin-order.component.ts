import { Component, OnInit } from '@angular/core';
import {AdminOrderService} from "../services/admin-order.service";
import {Order} from "../models/order";

@Component({
  selector: 'app-admin-order',
  templateUrl: './admin-order.component.html',
  styleUrls: ['./admin-order.component.css']
})
export class AdminOrderComponent implements OnInit {

  constructor(public adminOrderService: AdminOrderService) { }

  ngOnInit() {
    this.adminOrderService.getOrder().then(res => this.order = res)
  }

  deleteOrder(ord: Order){
    this.adminOrderService.deleteOrder(ord.id).then(res=> this.order.splice(this.order.indexOf(ord), 1))
  }

  order: Order[];
}

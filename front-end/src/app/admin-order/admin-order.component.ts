import { Component, OnInit } from '@angular/core';
import {AdminOrderService} from "../services/admin-order.service";
import {Order} from "../models/order";

@Component({
  selector: 'app-admin-order',
  templateUrl: './admin-order.component.html',
  styleUrls: ['./admin-order.component.css']
})
export class AdminOrderComponent implements OnInit {

  constructor(public adminOrderServise: AdminOrderService) { }

  ngOnInit() {
    this.adminOrderServise.getOrder().then(res => this.order = res)
  }

  order: Order[];



}

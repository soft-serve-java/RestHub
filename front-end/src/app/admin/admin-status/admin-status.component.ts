import { Component, OnInit } from '@angular/core';
import {Status} from "../../models/status";
import {AdminOrderService} from "../../services/admin-order.service";

@Component({
  selector: 'app-admin-status',
  templateUrl: './admin-status.component.html',
  styleUrls: ['./admin-status.component.css']
})
export class AdminStatusComponent implements OnInit {

  constructor(public adminOrderService: AdminOrderService) { }

  ngOnInit() {
    this.adminOrderService.getStatuses().then(res => this.statuses = res)
  }
statuses: Status[];
}

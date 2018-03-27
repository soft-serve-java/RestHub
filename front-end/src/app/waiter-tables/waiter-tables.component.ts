import { Component, OnInit } from '@angular/core';
import {WaiterService} from "../services/waiter.service";
import {Tables} from "../models/tables";

@Component({
  selector: 'app-waiter-tables',
  templateUrl: './waiter-tables.component.html',
  styleUrls: ['./waiter-tables.component.css']
})
export class WaiterTablesComponent implements OnInit {
  tables:Array<Tables>;
  quantityOfTables:number = 8;
  constructor(public waiterService:WaiterService) { }

  ngOnInit() {
    this.waiterService.getTablesWhithStatus().subscribe(res=>{this.tables = res;});
  }

  isOnDelivery(i: number):boolean {
    return true;
  }
  hasNullWaiter(i: number):boolean {
    return true;
  }

  isCalling(currentTable: number) {

  }
}

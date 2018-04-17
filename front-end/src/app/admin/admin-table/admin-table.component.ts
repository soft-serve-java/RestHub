import {Component, Inject, OnInit} from '@angular/core';
import {WaiterService} from "../../services/waiter.service";
import {LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {TableStorageService} from "../../services/table-storage.service";

@Component({
  selector: 'app-admin-table',
  templateUrl: './admin-table.component.html'
})
export class AdminTableComponent implements OnInit {

  private tables: number[];

  private chosenTable: number;

  private message;

  constructor(private waiterService: WaiterService,
              private tableStorageService: TableStorageService) {
    this.getTablesQuantity();
    this.checkChosenTable();
  }

  ngOnInit() {
  }

  getTablesQuantity(){
    this.waiterService.getTablesCount().then(
      res =>  this.tables = Array(res).fill(1).map((x,i)=>i+1));
  }

  setTable(){
    this.tableStorageService.table = this.chosenTable;
    this.message = "Table number of this device is set to " + this.chosenTable;
  }

  checkChosenTable(){
    this.chosenTable = this.tableStorageService.table;
    if (this.chosenTable ==undefined){
      this.chosenTable = 0;
    }
  }

}

import {Component, Inject, OnInit} from '@angular/core';
import {WaiterService} from "../../services/waiter.service";
import {Tables} from "../../models/tables";
import {Client, Frame, Message} from "stompjs";
import * as stompjs from 'stompjs';
import * as SockJS from "sockjs-client";

@Component({
  selector: 'app-waiter-tables',
  templateUrl: './waiter-tables.component.html',
  styleUrls: ['./waiter-tables.component.css']
})
export class WaiterTablesComponent implements OnInit {
  tables:Tables[];
  quantityOfTables:Array<number>;
  stompClient: Client;

  constructor(@Inject('SOCKET_URL') private socketUrl, public waiterService:WaiterService) { }

  ngOnInit() {
    this.waiterService.getTablesCount().then(res => this.quantityOfTables = Array.from(new Array(res), (x,i) => i+1));
    this.initializeWebSocketConnection();
  }
  initializeWebSocketConnection():void{
    const socket = new SockJS(this.socketUrl) as WebSocket;
    this.stompClient = stompjs.over(socket);
    this.stompClient.connect('', '', (frame: Frame) => {
      this.stompClient.subscribe('/waiter/tables',
        res => {this.tables = JSON.parse(res.body);});
    });
  }

  isOnDelivery(table: number):boolean {
    for(let i=0; i<this.tables.length; i++) {
      if(this.tables[i].currentTable == table && (this.tables[i].tableStatus == "IS_ON_DELIVERY")) {
        return true;
      }
    }
    return false

  }

  hasNullWaiter(table: number):boolean {
    for(let i=0; i<this.tables.length; i++) {
      if(this.tables[i].currentTable == table && (this.tables[i].tableStatus == "HAS_NULL_WAITER")) {
        return true;
      }
    }
    return false
  }

  isCalling(table: number):boolean {
    for(let i=0; i<this.tables.length; i++) {
      if(this.tables[i].currentTable == table && (this.tables[i].tableStatus == "CALLING_WAITER")) {
        return true;
      }
    }
    return false
  }
  isOfCurrentWaiter(table: number):boolean {
    for(let i=0; i<this.tables.length; i++) {
      if(this.tables[i].currentTable == table &&
        (this.tables[i].tableStatus == "HAS_WAITER" &&
          this.tables[i].currentWaiter.username==localStorage.getItem("username"))) {
        return true;
      }
    }
    return false
  }
  isOfOtherWaiter(table:number):boolean{
    for(let i=0; i<this.tables.length; i++) {
      if(this.tables[i].currentTable == table &&
        (this.tables[i].tableStatus == "HAS_WAITER" &&
          this.tables[i].currentWaiter.username!=localStorage.getItem("username"))) {
        return true;
      }
    }
    return false
  }
  doPOSTonGettingTable(table:number){
    this.waiterService.doPOSTonGettingTable(table).then(res => console.log(res));
  }
  doPOSTonCloseCalling(table:number){
    this.waiterService.doPOSTonCloseCalling(table).then(res => console.log(res));
  }

}

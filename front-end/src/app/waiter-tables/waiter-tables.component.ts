import {Component, Inject, OnInit} from '@angular/core';
import {WaiterService} from "../services/waiter.service";
import {Tables} from "../models/tables";
import {Client, Frame, Message} from "stompjs";
import * as stompjs from 'stompjs';
import * as SockJS from "sockjs-client";
import {$} from "protractor";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-waiter-tables',
  templateUrl: './waiter-tables.component.html',
  styleUrls: ['./waiter-tables.component.css']
})
export class WaiterTablesComponent implements OnInit {
  tables:Array<Tables>;
  quantityOfTables:Array<number>;
  stompClient: Client;

  constructor(@Inject('SOCKET_URL') private apiUrl, public waiterService:WaiterService) { }

  ngOnInit() {
   // this.waiterService.getTablesWhithStatus().then(res=>{this.tables = res;});
    this.initializeWebSocketConnection();
    this.waiterService.getTablesCount().then(res => this.quantityOfTables = Array.from(new Array(res), (x,i) => i+1));
  }
  initializeWebSocketConnection():void{
    const socket = new SockJS(this.apiUrl) as WebSocket;
    this.stompClient = stompjs.over(socket);
    this.stompClient.connect('', '', (frame: Frame) => {
      this.stompClient.subscribe('/waiter/tables',
        res => {this.tables = res.body;});
    });
  }

  isOnDelivery(table: number):boolean {
    console.log(this.tables)
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
    console.log("asdasd")
    for(let i=0; i<this.tables.length; i++) {
      console.log(i);
      if(this.tables[i].currentTable == table && (this.tables[i].tableStatus == "CALLING_WAITER")) {
        console.log(this.tables[i]);
        return true;
      }
    }
    return false
  }

}

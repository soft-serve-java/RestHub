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
  initializeWebSocketConnection(){
    const socket = new SockJS(this.apiUrl) as WebSocket;
    this.stompClient = stompjs.over(socket);
    let that = this;
    this.stompClient.connect('', '', '', (frame: Frame) => {
      this.stompClient.subscribe('/waiter/tables',
        (res: Array<Tables>) => {this.tables = res;});
    });
  }

  ngOnInit() {
   // this.waiterService.getTablesWhithStatus().then(res=>{this.tables = res;});
    this.initializeWebSocketConnection();
    this.waiterService.getTablesCount().then(res => this.quantityOfTables = Array.from(new Array(res), (x,i) => i+1));
  }

  isOnDelivery(i: number):boolean {
    return true;
  }
  hasNullWaiter(i: number):boolean {
    return true;
  }

  isCalling(currentTable: number):boolean {
    return true;
  }
}

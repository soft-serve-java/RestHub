import {Component, Inject, OnInit} from '@angular/core';
import {Client, Frame, Message} from "stompjs";
import * as stompjs from 'stompjs';
import * as SockJS from "sockjs-client";
import {Order} from "../../models/order";
import {ActivatedRoute} from "@angular/router";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-waiter-odrer',
  templateUrl: './waiter-odrer.component.html',
  styleUrls: ['./waiter-odrer.component.css']
})
export class WaiterOdrerComponent implements OnInit {
  stompClient: Client;
  order:Order;

  constructor(@Inject('SOCKET_URL') private socketUrl, private route: ActivatedRoute,  private orderService:OrderService ) { }
  id: number;
  private sub: any;
  showDialog:boolean;
  totalAmount:number;
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    this.orderService.getOrderDetails(this.id).then(
      (res:Order)=>{this.order=res; console.log(this.order);});
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection():void{
    const socket = new SockJS(this.socketUrl) as WebSocket;
    this.stompClient = stompjs.over(socket);
    this.stompClient.connect('', '', (frame: Frame) => {
      this.stompClient.subscribe('/user/'+this.id+'/oreder-updates',
        res => {res = res.body; this.order = JSON.parse(res);});
    });
  }
}

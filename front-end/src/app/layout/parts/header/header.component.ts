import {Component, Inject, OnInit} from '@angular/core';
import {Category} from "../../../models/category";
import {AppService} from "../../../services/app.service";
import {AuthService} from "../../../services/auth.service";
import {Client, Frame, Message} from "stompjs";
import * as stompjs from 'stompjs';
import * as SockJS from "sockjs-client";
import {User} from "../../../models/user";
import {TableStorageService} from "../../../services/table-storage.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private categories: Array<Category>;
  private tableNumber: number;
  private search: string;

  constructor(@Inject('SOCKET_URL') private socketUrl,
              public appService: AppService,public authService:AuthService,
              private tableStorageSerivce: TableStorageService) {
    this.getCategories();
    this.getTableNumber()
  }
  stompClient: Client;
  showDialog:boolean;
  waiter:User;

  ngOnInit() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection():void{
    const socket = new SockJS(this.socketUrl) as WebSocket;
    this.stompClient = stompjs.over(socket);
    this.stompClient.connect('', '', (frame: Frame) => {
      this.stompClient.subscribe('/user/'+1+'/callBackInfo',
        res => {this.showDialog = true});
    });
  }

  getCategories(){
     this.appService.getCategories().then(res=> this.categories = res);
  }
  isAuthenticated():boolean {
    return this.authService.isAuthenticated();
  }
  logout(){
    this.authService.logout();
  }
  doPOSTonCallWaiter(tableNumber:number) {
    this.appService.doPOSTonCallWaiter(tableNumber);
    console.log(1);
  }

  getTableNumber(){
    this.tableNumber = this.tableStorageSerivce.table;
  }


}

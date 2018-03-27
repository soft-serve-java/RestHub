import {Inject, Injectable} from '@angular/core';
import {Order} from "../models/order";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {OrderedDish} from "../models/orderedDish";

@Injectable()
export class OrderService {

  constructor(@Inject('API_URL') private apiUrl: string, private http:HttpClient) { }

  public getOrderDetails(id:number):Promise<Order>{
    return this.http.get<Order>(this.apiUrl + 'order/table/'+id).toPromise();
  }

  createOrder(orderDishes: OrderedDish[]):Promise<Order>{
    let item = localStorage.getItem('token');
    let tokenHeader = '';
    let authHeader = '';
    if (item != null){
      tokenHeader = 'Bearer ' + item;
      authHeader = 'Authorization';
    }

    return this.http.post<Order>(this.apiUrl + "order", orderDishes,
      {headers: new HttpHeaders({
              authHeader:  tokenHeader,
             })}).toPromise();
  }

  submitOne(orderedDish: OrderedDish): Promise<Order>{
    let item = localStorage.getItem('token');
    let tokenHeader = '';
    let authHeader = '';
    if (item != null){
      tokenHeader = 'Bearer ' + item;
      authHeader = 'Authorization';
    }

    return this.http.post<Order>(this.apiUrl + "order/submitOne", orderedDish,
      {headers: new HttpHeaders({
          authHeader:  tokenHeader,
        })}).toPromise();
  }
}

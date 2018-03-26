import {Inject, Injectable} from '@angular/core';
import {Order} from "../models/order";
import {HttpClient} from "@angular/common/http";
import {OrderedDish} from "../models/orderedDish";

@Injectable()
export class OrderService {

  constructor(@Inject('API_URL') private apiUrl: string, private http:HttpClient) { }

  public getOrderDetails(id:number):Promise<Order>{
    return this.http.get<Order>(this.apiUrl + 'order/table/'+id).toPromise();
  }

  createOrder(orderDishes: OrderedDish[]):Promise<Order>{
    return this.http.post<Order>(this.apiUrl + "order", orderDishes).toPromise();
  }

}

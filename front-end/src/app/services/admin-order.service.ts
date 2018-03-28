import {Inject, Injectable} from '@angular/core';
import {Order} from "../models/order";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {OrderedDish} from "../models/orderedDish";
import * as url from "url";
import {Role} from "../models/role";
import {Status} from "../models/status";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};
@Injectable()
export class AdminOrderService {

  constructor(@Inject('API_URL') private orderApi: string, private http:HttpClient){}

  getOrders(): Promise<Order[]>{
    return this.http.get<Order[]>(this.orderApi + "admin/order/all").toPromise();
  }

  getOrder(id:number):Promise<Order>{
    return this.http.get<Order>(this.orderApi + "admin/order/"+id).toPromise();
  }

  deleteOrder(id:number):Promise<any>{
    return this.http
      .delete(this.orderApi + "admin/order/delete/" + id )
      .toPromise()
      .then();
  }

  save(order:Order){
    return this.http.post<Order>(this.orderApi+"admin/order/save", httpOptions).toPromise();
  }
  getRoles(): Promise<Role[]>{
    return this.http.get<Role[]>(this.orderApi + "admin/role/all").toPromise();
  }
  getStatuses(): Promise<Status[]>{
    return this.http.get<Status[]>(this.orderApi + "admin/status/all").toPromise();
  }

}

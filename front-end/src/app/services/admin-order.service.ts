import {Inject, Injectable} from '@angular/core';
import {Order} from "../models/order";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AdminOrderService {

  constructor(@Inject('API_URL') private orderApi: string, private http:HttpClient){}

  getOrder(): Promise<Order[]>{
    return this.http.get<Order[]>(this.orderApi + "admin/order").toPromise();
  }

  deleteOrder(id:number):Promise<any>{
    return this.http
      .delete(this.orderApi + "admin/order/delete/" + id )
      .toPromise()
      .then()
  }
}

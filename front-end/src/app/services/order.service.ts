import {Inject, Injectable} from '@angular/core';
import {Order} from "../models/order";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class OrderService {

  constructor(@Inject('API_URL') private apiUrl: string, private http:HttpClient) { }

  public getOrderDetails(id:number):Promise<Order>{
    return this.http.get<Order>(this.apiUrl + 'order/'+id).toPromise();
  }

}

import {Inject, Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {OrderedDish} from "../models/orderedDish";
import 'rxjs/add/operator/map';
import {logging} from "selenium-webdriver";
import {Order} from "../models/order";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class CookService {
  orderedDishesUrl = 'http://localhost:8080/api/cook';

  constructor(@Inject('API_URL') private api: string,private http: HttpClient) {
  }

  /*getOrderedDishes(): Observable<Map<Order, OrderedDish>> {
    let map : Observable<Map<Order, OrderedDish>> = this.http.get<Map<Order, OrderedDish>>(this.orderedDishesUrl);
    console.log("map = " + map.map(x => {
      x.forEach(function (item, key, mapObj) {
        console.log(item.toString()+" ");
      });
    }));
    return this.http.get<Map<Order, OrderedDish>>(this.orderedDishesUrl).toPromise();
  }*/

  getOrderedDishes(): Observable<OrderedDish[]> {
    return this.http.get<OrderedDish[]>(this.orderedDishesUrl);
  }
  /*getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.orderedDishesUrl+'/orders');
  }*/

  getOrderByOrderedDishId(id: number): Promise<Order>{
    const url = `${this.orderedDishesUrl}/get/${id}`;
    return this.http.get<Order>(url, httpOptions).toPromise();
  }

  updateOrderedDish(id: number) : Promise<OrderedDish[]> {
    const url = `${this.orderedDishesUrl}/${id}`;
    return this.http.post<OrderedDish[]>(url, httpOptions).toPromise();
  }

}

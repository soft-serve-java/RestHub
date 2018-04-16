import {Inject, Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {OrderedDish} from "../models/orderedDish";
import 'rxjs/add/operator/map';
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

  getOrderedDishes(): Observable<OrderedDish[]> {
    return this.http.get<OrderedDish[]>(this.orderedDishesUrl);
  }

  getOrderByOrderedDishId(id: number): Promise<Order>{
    const url = `${this.orderedDishesUrl}/get/${id}`;
    return this.http.get<Order>(url, httpOptions).toPromise();
  }

  updateOrderedDish(id: number) : Promise<OrderedDish[]> {
    const url = `${this.orderedDishesUrl}/${id}`;
    return this.http.post<OrderedDish[]>(url, httpOptions).toPromise();
  }

}

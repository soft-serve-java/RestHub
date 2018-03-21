import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {OrderedDish} from "../models/orderedDish";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class CookService {
  orderedDishesUrl = 'http://localhost:8080/api/cook';

  constructor(private http: HttpClient) {
  }

  getOrderedDishes(): Observable<OrderedDish[]> {
    return this.http.get<OrderedDish[]>(this.orderedDishesUrl);
  }

  updateOrderedDish(orderedDish: OrderedDish) : Observable<OrderedDish> {
    // transfer id
    let updateOrderedDishUrl = 'http://localhost:8080/api/cook?id={updatedOrderedDish}';
    httpOptions.headers.set('Authorization', 'my-new-auth-token');
    return this.http.put<OrderedDish>(this.orderedDishesUrl, orderedDish, httpOptions);
  }

}

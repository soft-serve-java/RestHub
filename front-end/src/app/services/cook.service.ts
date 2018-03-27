import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {OrderedDish} from "../models/orderedDish";
import {reject, resolve} from "q";

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

  updateOrderedDish(id: number) : Promise<OrderedDish[]> {
    console.log(id);
    const url = `${this.orderedDishesUrl}/${id}`;
    return this.http.post<OrderedDish[]>(url, httpOptions).toPromise();
  }

}

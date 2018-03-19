import { Component, OnInit } from '@angular/core';
import {OrderedDish} from "../models/orderedDish";
import {Observable} from 'rxjs/Observable';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-cook',
  template: `
    <p>
      cook work!
    </p>
  `,
  styleUrls: ['./cook.component.css']
})
export class CookComponent implements OnInit {
   orderedDishes: Array<OrderedDish>;

  constructor(private http: HttpClient) { }

  /*getOrderedDishes(): Observable<OrderedDish[]>{
   return this.http.get('orderedDishes.json')
  }*/

  ngOnInit() {
    //this.getOrderedDishes();
  }

}

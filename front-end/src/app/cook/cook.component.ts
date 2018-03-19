import { Component, OnInit } from '@angular/core';
import {OrderedDish} from "../models/orderedDish";

@Component({
  selector: 'app-cook',
  template: `
    <p>
      cook works!
    </p>
  `,
  styleUrls: ['./cook.component.css']
})
export class CookComponent implements OnInit {
  orderedDishes: Array<OrderedDish>;

  constructor() { }

  ngOnInit() {
  }

}

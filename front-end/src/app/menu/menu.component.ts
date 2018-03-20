import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Dish} from "../models/dish";


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  category:string;
  menuItems:Array<Dish>;
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.category = params['category']);

  }

}

import { Component, OnInit } from '@angular/core';
import {Category} from "../../../models/category";
import {AppService} from "../../../services/app.service";

@Component({
  selector: 'app-waiter-header',
  templateUrl: './waiter-header.component.html',
  styleUrls: ['./waiter-header.component.css']
})
export class WaiterHeaderComponent implements OnInit {

  categories: Category[];

  constructor(public appService: AppService) { this.getCategories()}

  ngOnInit() {
  }

  getCategories(){
    this.categories = this.appService.getCategories();
  }

}

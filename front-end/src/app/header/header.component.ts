import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {AppService} from "../services/app.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private categories: Array<Category>;


  constructor(public appService: AppService) {this.getCategories()}

  ngOnInit() {
  }

  getCategories(){
    this.appService.getCategories().then(res => this.categories = res);
  }

}

import { Component, OnInit } from '@angular/core';
import {Category} from "../../../models/category";
import {AppService} from "../../../services/app.service";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-waiter-header',
  templateUrl: './waiter-header.component.html',
  styleUrls: ['./waiter-header.component.css']
})
export class WaiterHeaderComponent implements OnInit {

  categories: Category[];

  constructor(public appService: AppService, public authService:AuthService) { this.getCategories()}

  ngOnInit() {
  }

  getCategories(){
     this.appService.getCategories().then(res=> this.categories = res);
  }
  isAuthenticated():boolean {
    return this.authService.isAuthenticated();
  }
  logout(){
    this.authService.logout();
  }


}

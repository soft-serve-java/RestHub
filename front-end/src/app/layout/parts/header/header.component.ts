import { Component, OnInit } from '@angular/core';
import {Category} from "../../../models/category";
import {AppService} from "../../../services/app.service";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private categories: Array<Category>;


  constructor(public appService: AppService,public authService:AuthService) {this.getCategories()}

  ngOnInit() {
  }

  getCategories(){
    this.categories = this.appService.getCategories();
  }
  isAuthenticated():boolean {
    return this.authService.isAuthenticated();
  }
  logout(){
    this.authService.logout();
  }
  doPOSTonCallWaiter(tableNumber:number) {
    this.appService.doPOSTonCallWaiter(tableNumber);
    console.log(1);
  }


}

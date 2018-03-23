import { Component } from '@angular/core';
import { AppService } from './services/app.service';
import {Category} from "./models/category";
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  categories: Array<Category>;

  constructor(public appService: AppService, public authService:AuthService) { }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(){
    this.appService.getCategories().subscribe(res => this.categories = res);
  }
  doPOSTonCallWaiter(tableNumber:number) {
    this.appService.doPOSTonCallWaiter(tableNumber);
    console.log(tableNumber);
  }
  isAuthenticated():boolean {
    return this.authService.isAuthenticated();
  }
  logout(){
    this.authService.logout();
  }
}

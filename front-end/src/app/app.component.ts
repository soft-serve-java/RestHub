import { Component } from '@angular/core';
import { AppService } from './services/app.service';
import {Category} from "./models/category";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  categories: Array<Category>;

  constructor(public appService: AppService) { }

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
}

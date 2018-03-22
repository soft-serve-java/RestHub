import { Component } from '@angular/core';
import { AppService } from './services/app.service';
import { Category } from './models/Category';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private categories: Array<Category>;

  constructor(public appService: AppService) { this.getCategories();}

  ngOnInit() {
  }

  getCategories(){
    this.appService.getCategories().then(res => this.categories = res)
  }

}

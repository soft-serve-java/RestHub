import { Component, OnInit } from '@angular/core';
import {Dish} from "../../models/dish";
import {AdminDishService} from "../../services/admin-dish.service";
import {User} from "../../models/user";

@Component({
  selector: 'wfm-admin-dish',
  templateUrl: './admin-dish.component.html',
  styleUrls: ['./admin-dish.component.css']
})
export class AdminDishComponent implements OnInit {

  dish: Dish[];

  constructor(public adminDishService: AdminDishService){}

  ngOnInit(){
    this.adminDishService.getDish().then(res => this.dish = res)
  }

  deleteDish(dish: Dish){
    this.adminDishService.deleteDish(dish.id).then(res => this.dish.splice(this.dish.indexOf(dish), 1))
  }
}

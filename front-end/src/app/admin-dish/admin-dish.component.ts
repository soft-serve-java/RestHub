import { Component, OnInit } from '@angular/core';
import {Dish} from "../models/dish";
import {AdminDishService} from "../services/admin-dish.service";

@Component({
  selector: 'wfm-admin-dish',
  templateUrl: './admin-dish.component.html',
  styleUrls: ['./admin-dish.component.css']
})
export class AdminDishComponent implements OnInit {

  constructor(public adminDishService: AdminDishService){}

  ngOnInit(){
    this.adminDishService.getDish().then(res => this.dish = res)
  }

  dish: Dish[];

}

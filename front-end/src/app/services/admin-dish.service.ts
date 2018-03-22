import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Dish} from "../models/dish";
import {Category} from "../models/category";

@Injectable()
export class AdminDishService {

  constructor(@Inject('API_URL') private dishApi: string, private http:HttpClient){}

  getDish(): Promise<Dish[]>{
    return this.http.get<Dish[]>(this.dishApi + "admin/dish/all").toPromise();
}

  deleteDish(id: number): Promise<any>{
      return this.http
        .delete(this.dishApi + "admin/dish/delete/" + id )
        .toPromise()
        .then()
  }


  // + category: Category,
  addDish(name: String, description: String,  calories: number, category: Category, weight: number, preparingtime: number, price: number): Promise<any>{
    return this.http
      .post(this.dishApi + "admin/dish/add", {name: name, description: description, calories: calories, weight})
      .toPromise()
      .then()
  }
}

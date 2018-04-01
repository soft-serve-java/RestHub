import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Dish} from "../models/dish";
import {Category} from "../models/category";
import {User} from "../models/user";
import {Tag} from "../models/tag";

@Injectable()
export class AdminDishService {

  constructor(@Inject('API_URL') private dishApi: string, private http:HttpClient){}

  getDish(): Promise<Dish[]>{
    return this.http.get<Dish[]>(this.dishApi + "admin/dish/all").toPromise();
  }

  deleteDish(id: number): Promise<any>{
    return this.http
      .delete(this.dishApi + "admin/dish/" + id )
      .toPromise()
      .then()
  }


  addDish(name: string, description: string, weight: number, category: Category, calories: number, preparingtime: number, price: number, tags: Tag[]): Promise<any>{
    return this.http
    //.post(this.dishApi + "admin/dish/add", {dish: new Dish ()})
      .post(this.dishApi + "admin/dish/add", {name, description, weight, category, calories, preparingtime, price, tags})
      .toPromise()
  }


  editDish(dish: Dish): Promise<any>{
    return this.http
      .post(this.dishApi + "admin/dish/add", dish)
      .toPromise()
  }

  getDishById(id: number): Promise<Dish>{
    return this.http.get<Dish>(this.dishApi + "admin/dish/" + id).toPromise();
  }
}
